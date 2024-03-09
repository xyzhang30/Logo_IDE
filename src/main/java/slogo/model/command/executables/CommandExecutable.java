package slogo.model.command.executables;

import java.util.List;
import slogo.model.environment.EnvironmentApi;

/**
 * This abstract class represents a command executable in the environment.
 */

public abstract class CommandExecutable implements Executable {

  private final List<Executable> parameterExecutables;


  /**
   * Constructs a new {@code CommandExecutable} with the specified parameters.
   *
   * @param params the list of parameters passed into the command
   */
  public CommandExecutable(List<Executable> params) {
    parameterExecutables = params;
  }

  /**
   * Executes the command in the environment.
   *
   * @param env the environment in which the command is executed, including user-defined variables/commands
   * @return the result of executing the command
   */
  @Override
  public abstract double execute(EnvironmentApi env);
}
