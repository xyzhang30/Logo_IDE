package slogo.model.api;

/**
 * Exception for when the data is a list is opened but never closed.
 */
public class UnterminatedListException extends RuntimeException {

  /**
   * Constructs a new {@code UnterminatedListException} with the specified detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the
   *                {@link #getMessage()} method)
   */
  public UnterminatedListException(String message) {
    super(message);
  }

  /**
   * Constructs a new {@code UnterminatedListException} with the specified detail message and
   * cause.
   *
   * @param message the detail message (which is saved for later retrieval by the
   *                {@link #getMessage()} method)
   * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()}
   *                method)
   */
  public UnterminatedListException(String message, Throwable cause) {
    super(message, cause);
  }
}
