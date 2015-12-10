package jsphdev.cmu.barter2.ws.remote;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import jsphdev.cmu.barter2.entities.User;
import jsphdev.cmu.barter2.ui.LoginActivity;
import jsphdev.cmu.barter2.utility.Logger;


public class AuthorityTask extends AsyncTask<Void, Void, User> {
    public AuthorityTask(LoginActivity activity, User user) {
        this.logger = new Logger(this.getClass().getName());
        this.activity = activity;
        this.user = user;
    }

    @Override
    protected User doInBackground(Void... params) {
        SocketClient client = new SocketClient();

        client.request(SocketClientConstants.AUTHORITY);
        client.sendObject(user);
        User result = (User) client.getResult();

        client.close();
        return result;
    }

    @Override
    protected void onPostExecute(User user) {
        if (user == null)
        {
            logger.log("authority fail");
            activity.finish();
            return;
        }

        logger.log("authority ok");
        updateCurrentUser(user);

        activity.finish();
        return;
    }

    private void updateCurrentUser(User user) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        editor.putString("CurrentUser", userJson);
        editor.commit();
    }

    private Logger logger;
    private LoginActivity activity;
    private User user;
}
