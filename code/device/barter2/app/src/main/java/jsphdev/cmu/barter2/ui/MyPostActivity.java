package jsphdev.cmu.barter2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jsphdev.cmu.barter2.R;
import jsphdev.cmu.barter2.adapter.itemProxy.ItemListProxy;
import jsphdev.cmu.barter2.adapter.userProxy.UserProxy;
import jsphdev.cmu.barter2.entities.User;
import jsphdev.cmu.barter2.utility.SharedContent;
import jsphdev.cmu.barter2.ws.remote.GetUserPostsTask;

public class MyPostActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post);

        User user = SharedContent.getCurrentUser(getApplicationContext());
        if (user == null) {
            Intent submit = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(submit);
            return;
        }

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

        EditText title = (EditText) findViewById(R.id.title);
        //EditText description = (EditText) findViewById(R.id.description);
    }

    public void getPosts() {
        User user = new UserProxy().build("", "");
        jsphdev.cmu.barter2.entities.ItemList itemList = new ItemListProxy().build();

        GetUserPostsTask getUserPostsTask = new GetUserPostsTask(user, itemList);
        getUserPostsTask.execute();
    }
}
