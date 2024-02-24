package slogo.model.command;

import java.util.List;
import slogo.model.api.Executable;
import slogo.model.turtle.TurtleModel;

public class Forward extends CommandExecutable {

  private double distance;

  public Forward(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    distance = getParameterData().get(0);
  }

  @Override
  public double internalLogicExecution() {
    double distX = distance * Math.cos(getTurtle().getDirection());
    double distY = distance * Math.sin(getTurtle().getDirection());

    getTurtle().setPosX(getTurtle().getPosX() + distX);
    getTurtle().setPosY(getTurtle().getPoxY() + distY);

    return 0;
  }

//  @Override
//  public double execute() {
//
//  }

}
