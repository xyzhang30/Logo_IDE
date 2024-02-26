package slogo.model.api;

public class InvalidVariableException extends RuntimeException{

  public InvalidVariableException(String message) {
    super(message);
  }

  public InvalidVariableException(String message, Throwable cause) {
    super(message, cause);
  }
}
