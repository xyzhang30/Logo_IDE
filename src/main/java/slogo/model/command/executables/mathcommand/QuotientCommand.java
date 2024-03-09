package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that calculates the quotient of two numbers.
 */

public class QuotientCommand extends CommandExecutable {

  private final Executable numOne;
  private final Executable numTwo;

  /**
   * Constructs a new {@code QuotientCommand} with the specified parameter executables.
   *
   * @param parameterExecutables the list of parameter executables representing the dividend and
   *                             divisor
   */
  public QuotientCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    numOne = parameterExecutables.get(0);
    numTwo = parameterExecutables.get(1);
  }

  /**
   * Executes the command and returns the quotient of the two numbers.
   *
   * @param env the environment in which the command is executed, including the turtle model, user
   *            defined variables/commands, and the environment dimensions
   * @return the quotient of the two numbers
   */
  @Override
  public double execute(EnvironmentApi env) {
    return numOne.execute(env) / numTwo.execute(env);
  }
}
