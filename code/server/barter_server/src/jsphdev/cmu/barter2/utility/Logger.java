package jsphdev.cmu.barter2.utility;

public class Logger {
  public Logger(String module) {
    this.module = module;
  }
  
  public void log(String s) {
    System.out.println(module + ": " + s);
  }
  
  private String module;
}
