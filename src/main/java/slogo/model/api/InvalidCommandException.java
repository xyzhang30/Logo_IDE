package slogo.model.api;

/**
 * This exception class handles errors caused by a non-existing command name input
 */

public class InvalidCommandException extends RuntimeException {

  /**
   * Constructs a new {@code InvalidCommandException} with the specified detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
   */
  public InvalidCommandException(String message) {
    super(message);
  }


  /**
   * Constructs a new {@code InvalidCommandException} with the specified detail message and cause.
   *
   * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
   * @param cause   the cause of the exception
   */
  public InvalidCommandException(String message, Throwable cause) {
    super(message, cause);
  }
}
