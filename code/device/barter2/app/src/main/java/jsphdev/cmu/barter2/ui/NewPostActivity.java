package jsphdev.cmu.barter2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jsphdev.cmu.barter2.R;
import jsphdev.cmu.barter2.adapter.itemProxy.ItemProxy;
import jsphdev.cmu.barter2.database.DbHelper;
import jsphdev.cmu.barter2.entities.Item;
import jsphdev.cmu.barter2.ws.remote.CreateNewItemTask;

public class NewPostActivity extends ActionBarActivity {

    private EditText detailText;
    private EditText priceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        init();
        registerClickListener();
    }

    private void init() {
        detailText = (EditText) findViewById(R.id.description);
        priceText = (EditText) findViewById(R.id.price);
    }

    private void registerClickListener() {
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

        Button uploadImageButton = (Button) findViewById(R.id.upload_Image);
        uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: design needed reaction here
            }
        });

        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("This is Submit Button click listener");
                post();
            }
        });
    }

    private void post() {
        String detail = detailText.getText().toString();
        String price = priceText.getText().toString();

        View focusView = null;

        if (TextUtils.isEmpty(detail)) {
            detailText.setError(getString(R.string.error_field_required));
            focusView = detailText;
            focusView.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(price)) {
            priceText.setError(getString(R.string.error_field_required));
            focusView = priceText;
            focusView.requestFocus();
            return;
        }

        if (!isNumeric(price)) {
            priceText.setError("This is not a integer. Please type a new one.");
            focusView = priceText;
            focusView.requestFocus();
            return;
        }

        ItemProxy itemProxy = new ItemProxy();
        Item item = itemProxy.build();
        item.setCategory("").setDescription(detail).setPrice(Integer.getInteger(price));

        storeInLocal(item);

        CreateNewItemTask createNewItemTask = new CreateNewItemTask(NewPostActivity.this, item);
        createNewItemTask.execute();
    }

    private void storeInLocal(Item item) {
        DbHelper db = new DbHelper(getApplicationContext());
        db.insert(item);
    }

    public static boolean isNumeric(String input)
    {
        try
        {
            Integer i = Integer.parseInt(input);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}