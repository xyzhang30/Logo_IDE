package slogo.model.command.executables;

import slogo.model.environment.EnvironmentApi;

public class CustomCommandExecutable extends CommandExecutable{
  private final String signature;

  public CustomCommandExecutable(String sig){
    signature = sig;
  }
  @Override
  public double execute(EnvironmentApi env) {
    return 0;
  }
}
