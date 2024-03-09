package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that calculates the difference between two numbers.
 */

public class DifferenceCommand extends CommandExecutable {

  private final Executable num1;
  private final Executable num2;

  /**
   * Constructs a new {@code DifferenceCommand} with the specified parameter executables.
   *
   * @param parameterExecutables the list of parameter executables representing the two numbers
   */
  public DifferenceCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    num1 = parameterExecutables.get(0);
    num2 = parameterExecutables.get(1);
  }

  /**
   * Executes the command and returns the difference between the two numbers.
   *
   * @param env the environment in which the command is executed, including the turtle model,
   *            user defined variables/commands, and the environment dimensions
   * @return the difference between the two numbers
   */
  @Override
  public double execute(EnvironmentApi env) {
    return num1.execute(env) - num2.execute(env);
  }
}
