package slogo.model.api;

/**
 * Interface for a single Executable.
 */
public interface Executable {

  /**
   * Calls a token to execute. All tokens return a double on execution, regardless of primary
   * function.
   *
   * @return double  The Executable's value after execution.
   */
  double execute();
}
