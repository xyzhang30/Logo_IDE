package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class Setxy extends CommandExecutable {

  private double newPosX;
  private double newPoxY;

  public Setxy(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    newPosX = getParameterData().get(0);
    newPoxY = getParameterData().get(1);
  }

  @Override
  public double internalLogicExecution() {
    double distMoved = Math.sqrt(
        Math.pow(getTurtle().getPosX() - newPosX, 2) + Math.pow(getTurtle().getPosY() - newPoxY,
            2));

    getTurtle().setPosX(newPosX);
    getTurtle().setPosY(newPoxY);

    return distMoved;
  }

}
