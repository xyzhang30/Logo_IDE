package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * This class represents a turtle command executable that sets the heading of the turtle to a specified angle.
 */

public class SetHeading extends TurtleExecutable {

  private final Executable angle;

  /**
   * Constructs a new {@code SetHeading} executable with the specified angle.
   *
   * @param parameterExecutables the list of parameter executables representing the angle to set the heading to
   */
  public SetHeading(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    angle = parameterExecutables.get(0);
  }

  /**
   * Executes the command, setting the heading of the turtle to the specified angle.
   *
   * @param env the environment in which the command is executed, including the turtle model, user-defined variables/commands, and the environment dimensions
   * @return the absolute value of the angle rotated to reach the new heading
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    double degrees = angle.execute(env);
    double originalDirection = turtle.getDegreesDirection();
    turtle.setDirection(degrees); //set the new direction to degrees
    return Math.abs(originalDirection - turtle.getDegreesDirection());
  }
}
