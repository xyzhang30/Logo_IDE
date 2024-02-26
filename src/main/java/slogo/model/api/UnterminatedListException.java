package slogo.model.api;

public class UnterminatedListException extends RuntimeException{

  public UnterminatedListException(String message) {
    super(message);
  }

  public UnterminatedListException(String message, Throwable cause) {
    super(message, cause);
  }
}
