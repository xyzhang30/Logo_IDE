package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class Setxy extends TurtleExecutable {

  private double newPosX;
  private double newPoxY;

  public Setxy(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    newPosX = parameterExecutables.get(0).execute();
    newPoxY = parameterExecutables.get(1).execute();
  }

  @Override
  public double execute() {
    double distMoved = Math.sqrt(
        Math.pow(getTurtle().getPosX() - newPosX, 2) + Math.pow(getTurtle().getPosY() - newPoxY,
            2));

    getTurtle().setPosX(newPosX);
    getTurtle().setPosY(newPoxY);

    return distMoved;
  }

}
