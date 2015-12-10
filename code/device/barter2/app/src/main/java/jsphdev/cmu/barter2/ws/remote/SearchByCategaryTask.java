package jsphdev.cmu.barter2.ws.remote;

import android.os.AsyncTask;

import jsphdev.cmu.barter2.utility.Logger;
import jsphdev.cmu.barter2.entities.Category;
import jsphdev.cmu.barter2.entities.ItemList;

public class SearchByCategaryTask extends AsyncTask<Void, Void, Boolean> {
    public SearchByCategaryTask(Category category, ItemList itemList) {
        this.category = category;
        this.itemList = itemList;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        SocketClient client = new SocketClient();

        client.request(SocketClientConstants.SEARCH_BY_CATEGARY);
        client.sendObject(category);
        this.itemList = (ItemList) client.getResult();

        client.close();
        return true;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        logger.log("" + result);
    }

    private Logger logger;
    private Category category;
    private ItemList itemList;
}
