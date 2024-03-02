package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class ClearScreen extends TurtleExecutable{

  public ClearScreen(List<Executable> parameterExecutables,
      TurtleModel t) {
    super(parameterExecutables, t);
  }

  @Override
  public double execute() {
    getTurtle().setEraseTrace(true);

    double distMoved = Math.sqrt(
        Math.pow(getTurtle().getPosX(), 2) + Math.pow(getTurtle().getPosY(), 2));

    getTurtle().setPosX(0);
    getTurtle().setPosY(0);

    return distMoved;
  }
}
