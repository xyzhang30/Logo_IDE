package slogo.model.command.executables;

import slogo.model.api.InvalidCommandException;
import slogo.model.environment.EnvironmentApi;

/**
 * Executable class for an Error.
 */
public class ErrorExecutable implements Executable{
  private final String errorMessage;
  public ErrorExecutable(String message){
    errorMessage = message;
  }
  /**
   * When asked to execute, Error throws an exception
   * @param env the Environment that the executable is running in.
   * @return nothing, just throws an exception.
   */
  @Override
  public double execute(EnvironmentApi env) throws InvalidCommandException {
    throw new InvalidCommandException(errorMessage);
  }
}
