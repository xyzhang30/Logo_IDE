package slogo.model.api;

/**
 * Error for when an uninstantiated variable is referenced.
 */
public class InvalidVariableException extends RuntimeException {

  /**
   * Constructs a new {@code InvalidVariableException} with the specified detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the
   *                {@link #getMessage()} method)
   */
  public InvalidVariableException(String message) {
    super(message);
  }

  /**
   * Constructs a new {@code InvalidVariableException} with the specified detail message and cause.
   *
   * @param message the detail message (which is saved for later retrieval by the
   *                {@link #getMessage()} method)
   * @param cause   the cause of the exception
   */
  public InvalidVariableException(String message, Throwable cause) {
    super(message, cause);
  }
}
