package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

/**
 * @author Alisha Zhang
 */

public class Right extends TurtleExecutable {

  private double degrees;

  public Right(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    degrees = parameterExecutables.get(0).execute();
  }

  @Override
  public double execute() {
    double currRadianDirection = getTurtle().getRadianDirection();
    double newRadianDirection = currRadianDirection - Math.toRadians(degrees);
    getTurtle().setDirection(Math.toDegrees(newRadianDirection));
    return degrees;
  }
}
