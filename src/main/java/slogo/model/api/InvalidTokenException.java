package slogo.model.api;

/**
 * Exception thrown when attempting to utilize an invalid token. The token does not match any
 * provided regex code.
 */
public class InvalidTokenException extends RuntimeException {

  /**
   * Constructs a new {@code InvalidTokenException} with the specified detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the
   *                {@link #getMessage()} method)
   */
  public InvalidTokenException(String message) {
    super(message);
  }

  /**
   * Constructs a new {@code InvalidTokenException} with the specified detail message and cause.
   *
   * @param message the detail message (which is saved for later retrieval by the
   *                {@link #getMessage()} method)
   * @param cause   the cause of the exception
   */
  public InvalidTokenException(String message, Throwable cause) {
    super(message, cause);
  }
}
