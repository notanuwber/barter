package jsphdev.cmu.barter2.ws.remote;

import android.os.AsyncTask;

import jsphdev.cmu.barter2.entities.User;
import jsphdev.cmu.barter2.ui.LoginActivity;
import jsphdev.cmu.barter2.utility.Logger;


public class AuthorityTask extends AsyncTask<Void, Void, String> {
    public AuthorityTask(LoginActivity activity, User user) {
        this.logger = new Logger(this.getClass().getName());
        this.activity = activity;
        this.user = user;
    }

    @Override
    protected String doInBackground(Void... params) {
        SocketClient client = new SocketClient();

        client.request(SocketClientConstants.AUTHORITY);
        client.sendObject(user);
        String result = (String) client.getResult();

        client.close();
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        logger.log(result);
        activity.finish();
    }

    private Logger logger;
    private LoginActivity activity;
    private User user;
}
