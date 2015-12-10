package jsphdev.cmu.barter2.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jsphdev.cmu.barter2.R;
import jsphdev.cmu.barter2.adapter.userProxy.UserProxy;
import jsphdev.cmu.barter2.entities.User;
import jsphdev.cmu.barter2.ws.remote.SignUpTask;

public class SignUpActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signUpButton = (Button) findViewById(R.id.register);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("This is Sign Up Button click listener");
                attemptSignUp();
            }
        });

        Button resetButton = (Button) findViewById(R.id.reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("This is Reset Button click listener");
            }
        });

        emailEditText = (EditText) findViewById(R.id.emailInSignUp);
        passwordEditText = (EditText) findViewById(R.id.password);
        password2EditText = (EditText) findViewById(R.id.password2);
        userNameEditText = (EditText) findViewById(R.id.userName);
    }

    private void attemptSignUp() {
        if (signUpTask != null) {
            return;
        }

        // Reset errors.
        emailEditText.setError(null);
        passwordEditText.setError(null);
        password2EditText.setError(null);
        userNameEditText.setError(null);

        // Store values at the time of the login attempt.
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String password2 = password2EditText.getText().toString();
        String userName = userNameEditText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            emailEditText.setError(getString(R.string.error_field_required));
            focusView = emailEditText;
            focusView.requestFocus();
            return;
        }

        if (!userProxy.isEmailValid(email)) {
            emailEditText.setError(getString(R.string.error_invalid_email));
            focusView = emailEditText;
            focusView.requestFocus();
            return;
        }

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) || !userProxy.isPasswordValid(password)) {
            passwordEditText.setError(getString(R.string.error_invalid_password));
            focusView = passwordEditText;
            focusView.requestFocus();
            return;
        }

        if (!password.equals(password2)) {
            password2EditText.setError(getString(R.string.error_password_not_equal));
            focusView = password2EditText;
            focusView.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(userName) || !userProxy.isUserNameValid(userName)) {
            userNameEditText.setError(getString(R.string.user_name_illegal));
            focusView = userNameEditText;
            focusView.requestFocus();
            return;
        }

        UserProxy userProxy = new UserProxy();
        User user = userProxy.build(password, email);
        user.setEmail(email);
        user.setPassword(password);
        user.setName(userName);

        signUpTask = new SignUpTask(SignUpActivity.this, user);
        signUpTask.execute((Void) null);
    }

    private SignUpTask signUpTask = null;
    EditText emailEditText;
    EditText passwordEditText;
    EditText password2EditText;
    EditText userNameEditText;
    private UserProxy userProxy = new UserProxy();
}