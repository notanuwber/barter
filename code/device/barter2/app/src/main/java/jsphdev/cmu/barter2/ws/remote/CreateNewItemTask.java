package jsphdev.cmu.barter2.ws.remote;

import android.app.Activity;
import android.os.AsyncTask;

import jsphdev.cmu.barter2.entities.Item;
import jsphdev.cmu.barter2.utility.Logger;

public class CreateNewItemTask extends AsyncTask<Void, Void, Boolean> {
    public CreateNewItemTask(Activity activity, Item item) {
        this.activity = activity;
        this.item = item;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        SocketClient client = new SocketClient();

        client.request(SocketClientConstants.CREATE_NEW_ITEM);
        client.sendObject(item);
        Boolean result = (Boolean) client.getResult();

        client.close();
        return result;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        logger.log("" + result);
        activity.finish();
    }

    private Logger logger;
    private Activity activity;
    private Item item;
}
