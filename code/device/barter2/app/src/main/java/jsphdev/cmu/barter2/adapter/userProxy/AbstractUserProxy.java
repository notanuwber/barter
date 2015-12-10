package jsphdev.cmu.barter2.adapter.userProxy;

import jsphdev.cmu.barter2.entities.User;

public class AbstractUserProxy implements Authoritation, Validation, UserBuilder {

    public boolean authoritize(String userName, String passWord) {
        return false;
    }

    public User build(String name, String password, String email, String phone) {
        return null;
    }

    public User build(String password, String email) {
        return new User().setPassword(password).setEmail(email);
    }

    public boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    public boolean isUserNameValid(String userName) {
        return true;
    }
}
