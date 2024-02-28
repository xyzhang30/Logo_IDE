package slogo.model.command.executables;

import java.util.List;
import slogo.model.turtle.TurtleModel;

/**
 * @author Alisha Zhang
 */

public class Left extends CommandExecutable {

  private double degrees;

  public Left(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    degrees = getParameterData().get(0);
  }

  @Override
  public double internalLogicExecution() {
    double currRadianDirection = getTurtle().getRadianDirection();
    double newRadianDirection = currRadianDirection + Math.toRadians(degrees);
    getTurtle().setDirection(Math.toDegrees(newRadianDirection));
    return degrees;
  }
}
