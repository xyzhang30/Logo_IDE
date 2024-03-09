package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that negates a number.
 */

public class MinusCommand extends CommandExecutable {

  private final Executable num;

  /**
   * Constructs a new {@code MinusCommand} with the specified parameter executable.
   *
   * @param parameterExecutables the list of parameter executables representing the number to be negated
   */
  public MinusCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    num = parameterExecutables.get(0);
  }

  /**
   * Executes the command and returns the negation of the number.
   *
   * @param env the environment in which the command is executed, including the turtle model, user defined variables/commands, and the environment dimensions
   * @return the negation of the number
   */
  @Override
  public double execute(EnvironmentApi env) {
    return 0 - num.execute(env);
  }
}
