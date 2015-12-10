package database;

import java.sql.ResultSet;

import jsphdev.cmu.barter2.entities.User;

public class DbWriteOperation extends DbOperation {

  public User insertUser(User user) {
    initial();

    int result = 0;
    try {
      String query = "INSERT INTO USER (NAME, PASSWORD, PHONE, EMAIL) VALUES('"
          + user.getName() + "', '" + user.getPassword() + "', '"
          + user.getPhone() + "', '" + user.getEmail() + "');";
      result = statement.executeUpdate(query);
   
      if (result == 0) {
        terminate();
        return null;
      }
      
      User insertedUser = getUser(user.getName());
      return insertedUser;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  
  public User getUser(String name) {
    initial();

    ResultSet result = null;
    try {
      result = statement.executeQuery(
          "SELECT * FROM USER WHERE NAME = '" + name + "';");
      
      if (!result.next()) {
        terminate();
        return null;
      }
      
      Integer id = result.getInt("ID");
      String email = result.getString("EMAIL");
      String phone = result.getString("PHONE");
      String password = result.getString("PASSWORD");
      User user = new User().setId(id).setName(name).setEmail(email).setPassword(password).setPhone(phone);
      return user;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}