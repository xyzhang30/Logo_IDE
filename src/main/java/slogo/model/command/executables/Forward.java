package slogo.model.command.executables;

import java.util.List;
import slogo.model.turtle.TurtleModel;

/**
 * @author Alisha Zhang
 */

public class Forward extends CommandExecutable {

  private final double distance;

  public Forward(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    distance = getParameterData().get(0);
  }

  @Override
  public double internalLogicExecution() {
    double distX = distance * Math.cos(getTurtle().getRadianDirection());
    double distY = distance * Math.sin(getTurtle().getRadianDirection());

    getTurtle().setPosX(getTurtle().getPosX() + distX);
    getTurtle().setPosY(getTurtle().getPoxY() + distY);

    System.out.println(getTurtle().getRadianDirection());

    return distance;
  }

}
