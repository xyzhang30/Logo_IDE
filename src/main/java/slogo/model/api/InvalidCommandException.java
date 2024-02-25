package slogo.model.api;

/**
 * This exception class handles errors caused by a non-existing command name input
 *
 * @author Alisha Zhang
 */

public class InvalidCommandException extends RuntimeException{

  public InvalidCommandException(String message){
    super(message);
  }

  public InvalidCommandException(String message, Throwable cause){
    super(message,cause);
  }
}
