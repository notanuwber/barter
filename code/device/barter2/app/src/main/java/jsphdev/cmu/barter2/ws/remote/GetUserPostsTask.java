package jsphdev.cmu.barter2.ws.remote;

import android.os.AsyncTask;

import jsphdev.cmu.barter2.utility.Logger;
import jsphdev.cmu.barter2.entities.ItemList;
import jsphdev.cmu.barter2.entities.User;

public class GetUserPostsTask extends AsyncTask<Void, Void, Boolean> {
    public GetUserPostsTask(User user, ItemList itemList) {
        this.user = user;
        this.itemList = itemList;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        SocketClient client = new SocketClient();

        client.request(SocketClientConstants.SEARCH_BY_CATEGARY);
        client.sendObject(user);
        this.itemList = (ItemList) client.getResult();

        client.close();
        return true;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        logger.log("" + result);
    }

    private Logger logger;
    private User user;
    private ItemList itemList;
}
