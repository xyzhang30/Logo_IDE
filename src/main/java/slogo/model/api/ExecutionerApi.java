package slogo.model.api;

/**
 * External API for the Executioner. Manages the execution of commands.
 */
public interface ExecutionerApi {

  /**
   * Resets the program, jumping back to the first instruction in the tree.
   */
  void reset();

  /**
   * Performs one instruction from the tree.
   */
  void step();
}
