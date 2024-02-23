package slogo.model.command;

/**
 * Interface for a single token.
 */
public interface Token {

  /**
   * Calls a token to execute.
   * All tokens return a double on execution, regardless of primary function.
   * @return double  The token's value after execution.
   */
  double execute();
}
