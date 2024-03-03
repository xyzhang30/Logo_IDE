package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class SetHeading extends TurtleExecutable {

  private double degrees;

  public SetHeading(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    degrees = parameterExecutables.get(0).execute();
  }

  @Override
  public double execute() {
    double originalDirection = getTurtle().getDegreesDirection();
    getTurtle().setDirection(degrees); //set the new direction to degrees
    return Math.abs(originalDirection - getTurtle().getDegreesDirection());
  }
}
