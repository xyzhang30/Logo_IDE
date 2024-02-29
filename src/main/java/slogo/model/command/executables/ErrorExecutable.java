package slogo.model.command.executables;

import slogo.model.api.InvalidCommandException;

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
   * @return nothing, just throws an exception.
   */
  @Override
  public double execute() throws InvalidCommandException {
    throw new InvalidCommandException(errorMessage);
  }
}
