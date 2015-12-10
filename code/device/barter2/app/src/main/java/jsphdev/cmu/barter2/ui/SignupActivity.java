package jsphdev.cmu.barter2.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jsphdev.cmu.barter2.R;

public class SignupActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signUpButton = (Button) findViewById(R.id.register);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("This is Sign Up Button click listener");
            }
        });

        Button resetButton = (Button) findViewById(R.id.reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("This is Reset Button click listener");
            }
        });

        EditText searchText = (EditText) findViewById(R.id.search);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        EditText password2 = (EditText) findViewById(R.id.password2);
        EditText userName = (EditText) findViewById(R.id.userName);
    }
}