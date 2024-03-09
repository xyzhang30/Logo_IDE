package slogo.view;

public class InvalidOrMissingVariablesException extends RuntimeException {

  public InvalidOrMissingVariablesException(String message) {
    super(message);
  }

  public InvalidOrMissingVariablesException(String message, Throwable cause) {
    super(message, cause);
  }
}

