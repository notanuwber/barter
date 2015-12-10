package jsphdev.cmu.barter2.ws.remote;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import jsphdev.cmu.barter2.utility.Logger;

public class SocketClient {

    public SocketClient() {
        logger = new Logger(SocketClient.class.getName());
        try {
            server = new Socket(SocketClientConstants.SERVER_ID_ADD, SocketClientConstants.DEFAULT_PORT);
            writer = new ObjectOutputStream(server.getOutputStream());
            reader = new ObjectInputStream(server.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void request(Integer request) {
        if (request == null)
            return;

        sendObject(request);
        logger.log("request " + request + "sent");
    }

    public void sendObject(Object object) {
        try {
            writer.writeObject(object);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getResult() {
        Object object = null;
        try {
            object = reader.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public void close() {
        try {
            server.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private Logger logger;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private Socket server;
}
