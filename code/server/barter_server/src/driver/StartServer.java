package driver;

import jsphdev.cmu.barter2.socket.SocketServer;

public class StartServer {
  public static void main(String[] args) {
    SocketServer server = new SocketServer();
    server.start();
  }
}
