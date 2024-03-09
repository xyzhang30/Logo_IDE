package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that performs logical OR operation.
 */

public class OrCommand extends CommandExecutable {

  private final Executable test1;
  private final Executable test2;


  /**
   * Constructs a new {@code OrCommand} with the specified parameter executables.
   *
   * @param parameterExecutables the list of parameter executables representing the boolean
   *                             expressions
   */
  public OrCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    test1 = parameterExecutables.get(0);
    test2 = parameterExecutables.get(1);
  }

  /**
   * Executes the command and returns 1 if either of the boolean expressions evaluates to true, and
   * 0 otherwise.
   *
   * @param env the environment in which the command is executed, including the turtle model, user
   *            defined variables/commands, and the environment dimensions
   * @return 1 if either of the boolean expressions evaluates to true, and 0 otherwise
   */
  @Override
  public double execute(EnvironmentApi env) {
    if (Math.abs(test1.execute(env)) > 0.001 || Math.abs(test2.execute(env)) > 0.001) {
      return 1;
    }
    return 0;
  }
}
