package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that checks if one number is less than another.
 */
public class LessCommand extends CommandExecutable {

  private final Executable test1;
  private final Executable test2;

  /**
   * Constructs a new {@code LessCommand} with the specified parameter executables.
   *
   * @param parameterExecutables the list of parameter executables representing the two numbers
   */
  public LessCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    test1 = parameterExecutables.get(0);
    test2 = parameterExecutables.get(1);
  }

  /**
   * Executes the command and returns 1 if the first number is less than the second, and 0
   * otherwise.
   *
   * @param env the environment in which the command is executed, including the turtle model, user
   *            defined variables/commands, and the environment dimensions
   * @return 1 if the first number is less than the second, and 0 otherwise
   */
  @Override
  public double execute(EnvironmentApi env) {
    if (test1.execute(env) - test2.execute(env) < 0.001) {
      return 1;
    }
    return 0;
  }
}
