package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

/**
 * @author Alisha Zhang
 */

public class Back extends TurtleExecutable {

  private double distance;

  public Back(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    distance = getParameterData().get(0);
  }

  @Override
  public double execute() {
    double distX = distance * Math.cos(getTurtle().getRadianDirection());
    double distY = distance * Math.sin(getTurtle().getRadianDirection());

    getTurtle().setPosX(getTurtle().getPosX() - distX);
    getTurtle().setPosY(getTurtle().getPosY() - distY);

    return distance;
  }


}
