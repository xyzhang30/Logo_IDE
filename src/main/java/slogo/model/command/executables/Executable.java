package slogo.model.command.executables;

import slogo.model.environment.EnvironmentApi;

/**
 * Interface for a single Executable.
 */
public interface Executable {

  /**
   * Calls a token to execute. All tokens return a double on execution, regardless of primary
   * function.
   *
   * @param env  The Environment for the Executable to execute on.
   * @return double  The Executable's value after execution.
   */
  double execute(EnvironmentApi env);
}
