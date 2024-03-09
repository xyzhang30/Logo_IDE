package slogo.view;

/**
 * Exception thrown when invalid or missing variables are encountered during parsing or execution.
 */
public class InvalidOrMissingVariablesException extends RuntimeException {

  /**
   * Constructs a new InvalidOrMissingVariablesException with the specified detail message.
   *
   * @param message the detail message
   */
  public InvalidOrMissingVariablesException(String message) {
    super(message);
  }

  /**
   * Constructs a new InvalidOrMissingVariablesException with the specified detail message and
   * cause.
   *
   * @param message the detail message
   * @param cause   the cause
   */
  public InvalidOrMissingVariablesException(String message, Throwable cause) {
    super(message, cause);
  }
}

