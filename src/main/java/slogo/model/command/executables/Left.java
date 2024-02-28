package slogo.model.command.executables;

import java.util.List;
import slogo.model.turtle.TurtleModel;

public class Left extends CommandExecutable{

  private double degrees;

  public Left(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    degrees = getParameterData().get(0);
  }

  @Override
  public double internalLogicExecution() {
    double currDirection = getTurtle().getRadianDirection();

    return degrees;
  }
}
