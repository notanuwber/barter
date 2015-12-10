package jsphdev.cmu.barter2.adapter.userProxy;

public interface Validation {
    public boolean isEmailValid(String email);
    public boolean isPasswordValid(String password);
    public boolean isUserNameValid(String userName);
}
