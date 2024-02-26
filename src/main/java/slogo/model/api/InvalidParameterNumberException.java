package slogo.model.api;

/**
 * Exception thrown when a method is passed more or less parameters than expected.
 */
public class InvalidParameterNumberException extends RuntimeException {

  public InvalidParameterNumberException(String message) {
    super(message);
  }

  public InvalidParameterNumberException(String message, Throwable cause) {
    super(message, cause);
  }
}
