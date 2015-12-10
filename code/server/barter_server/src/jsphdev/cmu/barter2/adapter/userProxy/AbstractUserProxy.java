package jsphdev.cmu.barter2.adapter.userProxy;

import database.DbReadOperation;
import database.DbWriteOperation;
import jsphdev.cmu.barter2.entities.User;

public class AbstractUserProxy implements Authoritation, jsphdev.cmu.barter2.adapter.userProxy.UserBuilder {
    public AbstractUserProxy() {
      readOperation = new DbReadOperation();
      writeOperation = new DbWriteOperation();
    }
    
    public User authoritize(String email, String password) {
      return readOperation.getUser(email, password);
    }
    
    public User insert(User user) {
      return writeOperation.insertUser(user);
    }
    
    public User find(String name) {
      return readOperation.getUser(name);
    }

    public User build(String name, String password, String email, String phone) {
        return null;
    }
    
    public User build(String password, String email) {
        return new User().setPassword(password).setEmail(email);
    }
    
    private DbReadOperation readOperation;
    private DbWriteOperation writeOperation;
}
