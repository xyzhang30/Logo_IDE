package slogo.model.api;

public class InvalidParameterNumberException extends RuntimeException{

  public InvalidParameterNumberException(String message){
    super(message);
  }

  public InvalidParameterNumberException(String message, Throwable cause){
    super(message, cause);
  }
}
