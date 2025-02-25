package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that repeats a block of commands a specified number of
 * times.
 */

public class Repeat extends CommandExecutable {

  private final Executable repetitions;
  private final ListExecutable listContent;
  private int index;

  /**
   * Constructs a new {@code Repeat} with the specified parameter executables.
   *
   * @param parameterExecutables the list of parameter executables representing the number of
   *                             repetitions and the list of commands to execute
   */
  public Repeat(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    repetitions = parameterExecutables.get(0);
    listContent = (ListExecutable) parameterExecutables.get(1);
    index = 0;
  }

  /**
   * Executes the command, repeating the block of commands a specified number of times.
   *
   * @param env the environment in which the command is executed, including the turtle model, user
   *            defined variables/commands, and the environment dimensions
   * @return the result of executing the last command in the listContent after completing all
   * repetitions
   */
  @Override
  public double execute(EnvironmentApi env) {
    if (index == 0) {
      env.getContextStack().add(this);
    }
    double val = listContent.execute(env);
    index++;
    if (index >= repetitions.execute(env)) {
      index = 0;
      env.getContextStack().remove(this);
    }
    return val;
  }
}
