package jsphdev.cmu.barter2.adapter.userProxy;

import database.DbReadOperation;
import jsphdev.cmu.barter2.entities.User;

public class AbstractUserProxy implements Authoritation, jsphdev.cmu.barter2.adapter.userProxy.UserBuilder {
    public AbstractUserProxy() {
      readOperation = new DbReadOperation();
    }
    
    @Override
    public User authoritize(String email, String password) {
      return readOperation.getUser(email, password);
    }

    @Override
    public User build(String name, String password, String email, String phone) {
        return null;
    }
    
    @Override
    public User build(String password, String email) {
        return new User().setPassword(password).setEmail(email);
    }
    
    private DbReadOperation readOperation;
}
