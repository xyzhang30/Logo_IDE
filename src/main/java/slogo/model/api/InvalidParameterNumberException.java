package slogo.model.api;

/**
 * Exception thrown when a method is passed more or less parameters than expected.
 */
public class InvalidParameterNumberException extends RuntimeException {


  /**
   * Constructs a new {@code InvalidParameterNumberException} with the specified detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the
   *                {@link #getMessage()} method)
   */
  public InvalidParameterNumberException(String message) {
    super(message);
  }

  /**
   * Constructs a new {@code InvalidParameterNumberException} with the specified detail message and
   * cause.
   *
   * @param message the detail message (which is saved for later retrieval by the
   *                {@link #getMessage()} method)
   * @param cause   the cause of the exception
   */
  public InvalidParameterNumberException(String message, Throwable cause) {
    super(message, cause);
  }
}
