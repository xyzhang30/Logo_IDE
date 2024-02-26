package slogo.model.api;

/**
 * Error for when a uninstantiated variable is referenced.
 */
public class InvalidVariableException extends RuntimeException{

  public InvalidVariableException(String message) {
    super(message);
  }

  public InvalidVariableException(String message, Throwable cause) {
    super(message, cause);
  }
}
