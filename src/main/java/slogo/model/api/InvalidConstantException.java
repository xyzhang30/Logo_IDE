package slogo.model.api;

public class InvalidConstantException extends RuntimeException{

  public InvalidConstantException(String message) {
    super(message);
  }

  public InvalidConstantException(String message, Throwable cause) {
    super(message, cause);
  }
}
