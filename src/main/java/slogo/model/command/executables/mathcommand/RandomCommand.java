package slogo.model.command.executables.mathcommand;

import java.util.List;
import java.util.Random;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;


/**
 * This class represents a command executable that generates a random number.
 */

public class RandomCommand extends CommandExecutable {

  private final Executable max;

  /**
   * Constructs a new {@code RandomCommand} with the specified parameter executable representing the
   * maximum value.
   *
   * @param parameterExecutables the list of parameter executables representing the maximum value
   */
  public RandomCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    max = parameterExecutables.get(0);
  }

  /**
   * Executes the command and returns a random number between 0 (inclusive) and the maximum value
   * (exclusive).
   *
   * @param env the environment in which the command is executed, including the turtle model, user
   *            defined variables/commands, and the environment dimensions
   * @return a random number between 0 (inclusive) and the maximum value (exclusive)
   */
  @Override
  public double execute(EnvironmentApi env) {
    Random rand = new Random();
    return rand.nextDouble(max.execute(env));
  }
}
