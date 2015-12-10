package jsphdev.cmu.barter2.ui;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jsphdev.cmu.barter2.R;
import jsphdev.cmu.barter2.utility.Logger;
import jsphdev.cmu.barter2.adapter.itemProxy.ItemListProxy;
import jsphdev.cmu.barter2.adapter.categoryProxy.*;
import jsphdev.cmu.barter2.entities.Category;
import jsphdev.cmu.barter2.entities.ItemList;
import jsphdev.cmu.barter2.ws.remote.SearchByCategaryTask;


public class SearchResultActivity extends ActionBarActivity {
    public SearchResultActivity() {
        super();
        logger = new Logger(this.getClass().getName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        Button myAccountButton = (Button) findViewById(R.id.myAccount);
        myAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent(view.getContext(), MyAccountActivity.class);
                startActivity(submit);
            }
        });

        Button myPostButton = (Button) findViewById(R.id.myPost);
        myPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent(view.getContext(), MyPostActivity.class);
                startActivity(submit);
            }
        });

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent(view.getContext(), LoginActivity.class);
                startActivity(submit);
            }
        });

        EditText searchText = (EditText) findViewById(R.id.search);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            search(query);
            System.out.println("handleIntent");
        }
    }

    private void search(String query) {
        Category category = new CategoryProxy().build();
        category.setName(query);

        ItemList itemList = new ItemListProxy().build();
        SearchByCategaryTask searchByCategaryTask = new SearchByCategaryTask(category, itemList);
        searchByCategaryTask.execute();
    }

    private Logger logger;
}