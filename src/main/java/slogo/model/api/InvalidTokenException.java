package slogo.model.api;

/**
 * Exception thrown when attempting to utilize an invalid token. The token does not match any
 * provided regex code.
 */
public class InvalidTokenException extends RuntimeException {

  public InvalidTokenException(String message) {
    super(message);
  }

  public InvalidTokenException(String message, Throwable cause) {
    super(message, cause);
  }
}
