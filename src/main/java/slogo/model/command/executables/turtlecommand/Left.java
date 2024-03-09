package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a turtle command executable that rotates the turtle to the left by a
 * specified angle.
 */

public class Left extends TurtleExecutable {

  private final Executable angle;

  /**
   * Constructs a new {@code Left} executable with the specified angle.
   *
   * @param parameterExecutables the list of parameter executables containing the angle by which to
   *                             rotate the turtle
   */
  public Left(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    angle = parameterExecutables.get(0);
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
    double degrees = angle.execute(env);
    rotate(degrees);
    return degrees;
  }
}
