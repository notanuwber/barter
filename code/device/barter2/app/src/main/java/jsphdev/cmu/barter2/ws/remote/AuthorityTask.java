package jsphdev.cmu.barter2.ws.remote;

import android.os.AsyncTask;

import jsphdev.cmu.barter2.entities.User;
import jsphdev.cmu.barter2.ui.LoginActivity;
import jsphdev.cmu.barter2.utility.Logger;
import jsphdev.cmu.barter2.utility.SharedContent;


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
        SharedContent.updateCurrentUser(activity.getApplicationContext(), user);

        activity.finish();
        return;
    }

    private Logger logger;
    private LoginActivity activity;
    private User user;
}
