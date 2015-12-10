package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DbOperation {
  public void initial() {
    try {
      connection = dbConnection.getConnection();
      statement = connection.createStatement();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void terminate() {
    try {
      statement.close();
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  static DbConnection dbConnection = new DbConnection();
  protected Connection connection = null;
  protected Statement statement = null;
}
