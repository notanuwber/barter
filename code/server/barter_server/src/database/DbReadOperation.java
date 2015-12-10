package database;

import java.sql.ResultSet;

import jsphdev.cmu.barter2.entities.User;

public class DbReadOperation extends DbOperation {

  public User getUser(String email, String password) {
    initial();

    ResultSet result = null;
    try {
      result = statement.executeQuery(
          "SELECT * FROM USER "
          + "WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "';");
      
      if (!result.next()) {
        terminate();
        return null;
      }
      
      Integer id = result.getInt("ID");
      String name = result.getString("NAME");
      String mail = result.getString("EMAIL");
      String phone = result.getString("PHONE");
      User user = new User().setId(id).setName(name).setEmail(mail).setPhone(phone);
      return user;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
