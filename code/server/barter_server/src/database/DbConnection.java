package database;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class DbConnection {
  
  public Connection getConnection() {
    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
  
  private static HikariDataSource dataSource = null;
  static{
    dataSource = new HikariDataSource();
    dataSource.setMaximumPoolSize(10);
    dataSource.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
    dataSource.addDataSourceProperty("serverName", "localhost");
    dataSource.addDataSourceProperty("port", "3306");
    dataSource.addDataSourceProperty("databaseName", "barter");
    dataSource.addDataSourceProperty("user", "root");
    dataSource.addDataSourceProperty("password", "123456");
    dataSource.addDataSourceProperty("useUnicode", "true");
    dataSource.addDataSourceProperty("characterEncoding", "utf8");
  }
}
