package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * This class represents a turtle command executable that rotates the turtle to the left by a
 * specified angle.
 */
public class PenDown extends TurtleExecutable {

  /**
   * Constructs a new {@code Left} executable with the specified angle.
   *
   * @param parameterExecutables the list of parameter executables containing the angle by which to
   *                             rotate the turtle
   */
  public PenDown(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  /**
   * Executes the command, rotating the turtle to the left by the specified angle.
   *
   * @param env the environment in which the command is executed, including the turtle model,
   *            user-defined variables/commands, and the environment dimensions
   * @return the angle by which the turtle was rotated
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    turtle.setPenDown(true);
    return 1;
  }
}
