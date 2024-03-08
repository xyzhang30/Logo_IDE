package slogo.model.command.executables;

import slogo.model.environment.EnvironmentApi;

public class CustomCommandExecutable implements Executable{
  private final String signature;

  public CustomCommandExecutable(String sig){
    signature = sig;
  }
  @Override
  public double execute(EnvironmentApi env) {
    return env.getFuncMap().get(signature).execute(env);
  }

  public String getSignature(){
    return signature;
  }
}
