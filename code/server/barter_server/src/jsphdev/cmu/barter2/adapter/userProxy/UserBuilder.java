package jsphdev.cmu.barter2.adapter.userProxy;

import jsphdev.cmu.barter2.entities.User;

public interface UserBuilder {
    public User build(String name, String password, String email, String phone);
    public User build(String password, String email);
}
