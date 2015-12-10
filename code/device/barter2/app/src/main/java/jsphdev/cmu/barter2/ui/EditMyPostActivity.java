package jsphdev.cmu.barter2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import jsphdev.cmu.barter2.R;
import jsphdev.cmu.barter2.adapter.itemProxy.ItemProxy;
import jsphdev.cmu.barter2.entities.Item;
import jsphdev.cmu.barter2.ws.remote.UpdateItemTask;

public class EditMyPostActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_post);

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

        Button editButton = (Button) findViewById(R.id.edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent(view.getContext(), MyPostActivity.class);
                startActivity(submit);
            }
        });
    }

    public void update() {
        Item item = new ItemProxy().build().setCategaryId(1).setDetails("details").setPrice(100).setPrice(100);
        UpdateItemTask updateItemTask = new UpdateItemTask(item);
        updateItemTask.execute();
    }
}