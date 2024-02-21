package slogo.model.command;

public interface CommandLine {

  /**
   * Executes the code stored on this commandLine object
   * @return double  return value of the SLogo keyword
   */
  public double execute();

}
