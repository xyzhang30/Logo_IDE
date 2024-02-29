package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class SetHeading extends CommandExecutable {

  private double degrees;

  public SetHeading(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    degrees = getParameterData().get(0);
  }

  @Override
  public double internalLogicExecution() {
    double originalDirection = getTurtle().getDegreesDirection();
    getTurtle().setDirection(degrees); //set the new direction to degrees
    return Math.abs(originalDirection - getTurtle().getDegreesDirection());
  }
}
