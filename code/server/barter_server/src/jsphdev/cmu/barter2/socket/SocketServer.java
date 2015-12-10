package jsphdev.cmu.barter2.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import jsphdev.cmu.barter2.adapter.userProxy.UserProxy;
import jsphdev.cmu.barter2.entities.User;
import jsphdev.cmu.barter2.utility.Logger;

public class SocketServer extends Thread implements SocketServerConstants, SocketServerInterface {
  public SocketServer() {
    logger = new Logger(this.getClass().getName());
    userProxy = new UserProxy();
  }

  public void init() {
    try {
      server = new ServerSocket(DEFAULT_PORT);
    } catch (IOException e) {
      System.err.println(e);
    }
  }

  @Override
  public void handleSession() {
    while (true) {
      if (!accept()) {
        continue;
      }

      Integer request = getRequest();
      handleRequest(request);
    }
  }

  private Integer getRequest() {
    Integer request = null;

    try {
      request = (Integer) reader.readObject();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return request;
  }

  private void handleRequest(Integer request) {
    try {
      switch (request) {
      case AUTHORITY:
        logger.log("get AUTHORITY request");
        User user = (User) reader.readObject();
        User userInDb = userProxy.authoritize(user.getEmail(), user.getPassword());
        writer.writeObject(userInDb);
        break;

      case GET_LIST_BY_KEY_WORD:
        logger.log("get GET_LIST_BY_KEY_WORD request");
        break;

      case GET_LIST_BY_CATEGARY:
        logger.log("get GET_LIST_BY_CATEGARY request");
        break;

      case CREATE_POST:
        logger.log("get CREATE_POST request");
        break;

      case UPDATE_POSTS:
        logger.log("get UPDATE_POSTS request");
        break;

      case GET_USER_POSTS:
        logger.log("get GET_USER_POSTS request");
        break;

      default:
        logger.log("get UNKNOWN request");
        break;
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean accept() {
//    if (client != null && !client.isClosed()) {
//      return true;
//    }

    try {
      client = server.accept();
      reader = new ObjectInputStream(client.getInputStream());
      writer = new ObjectOutputStream(client.getOutputStream());

      System.out.println("Accept succeeded.");
    } catch (IOException e) {
      System.err.println(e);
      return false;
    }
    return true;
  }

  @Override
  public void closeSession() {
    try {
      writer = null;
      reader = null;
      client.close();
    } catch (Exception e) {
      if (DEBUG) {
        System.err.println("Error closing client socket " + client.getInetAddress().getHostAddress());
      }
    }
  }

  public void run() {
    init();

    handleSession();
    closeSession();
  }

  private Logger logger;
  private ObjectInputStream reader;
  private ObjectOutputStream writer;
  private ServerSocket server;
  private Socket client;
  private UserProxy userProxy;
}
