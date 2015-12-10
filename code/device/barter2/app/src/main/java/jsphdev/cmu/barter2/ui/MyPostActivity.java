package jsphdev.cmu.barter2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import jsphdev.cmu.barter2.R;
import jsphdev.cmu.barter2.adapter.itemProxy.ItemListProxy;
import jsphdev.cmu.barter2.adapter.userProxy.UserProxy;
import jsphdev.cmu.barter2.entities.User;
import jsphdev.cmu.barter2.utility.SharedContent;
import jsphdev.cmu.barter2.ws.remote.GetUserPostsTask;

public class MyPostActivity extends ActionBarActivity {
    private static ImageView imgView;
    private static ImageView imgView2;
    private static ImageView imgView3;
    private static ImageView imgView4;

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
        OnClickButtonListener();
    }

    public void getPosts() {
        User user = new UserProxy().build("", "");
        jsphdev.cmu.barter2.entities.ItemList itemList = new ItemListProxy().build();

        GetUserPostsTask getUserPostsTask = new GetUserPostsTask(user, itemList);
        getUserPostsTask.execute();
    }

    public void OnClickButtonListener() {
        imgView = (ImageView)findViewById(R.id.imageView);
        imgView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("jsphdev.cmu.barter2.ui.DetailActivity");
                        startActivity(intent);
                    }
                }
        );
        imgView2 = (ImageView)findViewById(R.id.imageView2);
        imgView2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("jsphdev.cmu.barter2.ui.DetailActivity");
                        startActivity(intent);
                    }
                }
        );
        imgView3 = (ImageView)findViewById(R.id.imageView3);
        imgView3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("jsphdev.cmu.barter2.ui.DetailActivity");
                        startActivity(intent);
                    }
                }
        );
        imgView4 = (ImageView)findViewById(R.id.imageView4);
        imgView4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("jsphdev.cmu.barter2.ui.DetailActivity");
                        startActivity(intent);
                    }
                }
        );
    }


}
