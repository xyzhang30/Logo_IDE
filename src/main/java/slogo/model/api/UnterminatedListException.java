package slogo.model.api;

/**
 * Exception for when the data is a list is opened but never closed.
 */
public class UnterminatedListException extends RuntimeException{

  public UnterminatedListException(String message) {
    super(message);
  }

  public UnterminatedListException(String message, Throwable cause) {
    super(message, cause);
  }
}
