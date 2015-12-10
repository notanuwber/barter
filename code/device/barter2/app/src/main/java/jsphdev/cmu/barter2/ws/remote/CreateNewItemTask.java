package jsphdev.cmu.barter2.ws.remote;

import android.os.AsyncTask;

import jsphdev.cmu.barter2.utility.Logger;
import jsphdev.cmu.barter2.entities.Item;

public class CreateNewItemTask extends AsyncTask<Void, Void, Boolean> {
    public CreateNewItemTask(Item item) {
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
    }

    private Logger logger;
    private Item item;
}
