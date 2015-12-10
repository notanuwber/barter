package jsphdev.cmu.barter2.adapter.userProxy;

import jsphdev.cmu.barter2.entities.User;

public class AbstractUserProxy implements jsphdev.cmu.barter2.adapter.userProxy.Authoritation, jsphdev.cmu.barter2.adapter.userProxy.UserBuilder {

    @Override
    public boolean authoritize(String userName, String passWord) {
        return false;
    }

    @Override
    public User build(String name, String password, String email, String phone) {
        return null;
    }
    
    @Override
    public User build(String password, String email) {
        return new User().setPassword(password).setEmail(email);
    }
}
