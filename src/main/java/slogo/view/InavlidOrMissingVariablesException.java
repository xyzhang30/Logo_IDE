package slogo.view;

public class InavlidOrMissingVariablesException extends RuntimeException {

    public InavlidOrMissingVariablesException(String message) {
      super(message);
    }

    public InavlidOrMissingVariablesException(String message, Throwable cause) {
      super(message, cause);
    }
  }

