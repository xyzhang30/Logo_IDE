package slogo.model.api;

/**
 * Exception thrown when attempting to utilize an invalid token as a constant
 */
public class InvalidConstantException extends RuntimeException{

  public InvalidConstantException(String message) {
    super(message);
  }

  public InvalidConstantException(String message, Throwable cause) {
    super(message, cause);
  }
}
