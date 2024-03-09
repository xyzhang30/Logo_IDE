package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * This class represents a turtle command executable that lifts the pen up.
 */

public class PenUp extends TurtleExecutable {

  /**
   * Constructs a new {@code PenUp} executable.
   *
   * @param parameterExecutables the list of parameter executables (not used in this
   *                             implementation)
   */
  public PenUp(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  /**
   * Executes the command, lifting the pen of the current turtle up.
   *
   * @param env the environment in which the command is executed, including the turtle model,
   *            user-defined variables/commands, and the environment dimensions
   * @return always returns {@code 0}
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    turtle.setPenDown(false);
    return 0;
  }
}
