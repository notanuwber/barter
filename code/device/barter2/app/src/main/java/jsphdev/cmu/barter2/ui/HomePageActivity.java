package jsphdev.cmu.barter2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jsphdev.cmu.barter2.R;

public class HomePageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

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
    }
}
