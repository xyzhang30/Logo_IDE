package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a turtle command executable that turns the turtle to the right by a
 * specified angle.
 */

public class Right extends TurtleExecutable {

  private final Executable angle;

  /**
   * Constructs a new {@code Right} executable with the specified angle.
   *
   * @param parameterExecutables the list of parameter executables representing the angle of
   *                             rotation
   */
  public Right(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    angle = parameterExecutables.get(0);
  }

  /**
   * Executes the command, turning the turtle to the right by the specified angle.
   *
   * @param env the environment in which the command is executed, including the turtle model,
   *            user-defined variables/commands, and the environment dimensions
   * @return the absolute value of the angle rotated
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    double degrees = angle.execute(env);
    rotate(-degrees);
    return degrees;
  }
}
