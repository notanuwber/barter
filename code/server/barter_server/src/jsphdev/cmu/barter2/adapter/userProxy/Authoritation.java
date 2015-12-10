package jsphdev.cmu.barter2.adapter.userProxy;

import jsphdev.cmu.barter2.entities.User;

public interface Authoritation {
    public User authoritize(String userName, String passWord);
}
