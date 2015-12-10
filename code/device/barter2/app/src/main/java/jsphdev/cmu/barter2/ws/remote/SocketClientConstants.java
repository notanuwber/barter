package jsphdev.cmu.barter2.ws.remote;

public final class SocketClientConstants {
  private SocketClientConstants() {
    // restrict instantiation
  }

  public static final int DEFAULT_PORT = 9876;
  public static  boolean DEBUG = true;

  public static final int AUTHORITY = 1;
  public static final int SEARCH_BY_KEY_WORD = 2;
  public static final int SEARCH_BY_CATEGARY = 3;
  public static final int CREATE_NEW_ITEM = 4;
  public static final int UPDATE_ITEM = 5;
  public static final int GET_USER_POSTS = 6;

  public static final String SERVER_ID_ADD = "10.0.2.2";
}
