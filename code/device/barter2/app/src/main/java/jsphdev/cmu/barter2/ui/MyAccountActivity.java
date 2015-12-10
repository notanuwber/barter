package jsphdev.cmu.barter2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jsphdev.cmu.barter2.R;
import jsphdev.cmu.barter2.entities.User;
import jsphdev.cmu.barter2.utility.SharedContent;

public class MyAccountActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        User user = SharedContent.getCurrentUser(getApplicationContext());
        if (user == null) {
            Intent submit = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(submit);
            finish();
            return;
        }

        TextView nameTextView = (TextView) findViewById(R.id.textViewNameInMyAccount);
        nameTextView.setText(user.getName());

        TextView emailTextView = (TextView) findViewById(R.id.textViewEmailInMyAccount);
        emailTextView.setText(user.getEmail());

        TextView phoneTextView = (TextView) findViewById(R.id.textViewPhoneInMyAccount);
        phoneTextView.setText(user.getPhone());

        Button myPostButton = (Button) findViewById(R.id.myPost);
        myPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent(view.getContext(), MyPostActivity.class);
                startActivity(submit);
            }
        });

        Button logoutButton = (Button) findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedContent.clearCurrentUser(getApplicationContext());
                finish();
            }
        });
    }
}
