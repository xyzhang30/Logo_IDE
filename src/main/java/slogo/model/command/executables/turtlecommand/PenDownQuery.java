package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * This class represents a turtle command executable that queries whether the pen is down.
 */

public class PenDownQuery extends TurtleExecutable {

  /**
   * Constructs a new {@code PenDownQuery} executable.
   *
   * @param parameterExecutables the list of parameter executables (not used in this
   *                             implementation)
   */
  public PenDownQuery(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  /**
   * Executes the command, querying whether the pen of the current turtle is down.
   *
   * @param env the environment in which the command is executed, including the turtle model,
   *            user-defined variables/commands, and the environment dimensions
   * @return {@code 1} if the pen is down, {@code 0} otherwise
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    if (turtle.isPenDown()) {
      return 1;
    }
    return 0;
  }
}
