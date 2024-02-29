package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class Home extends CommandExecutable {

  public Home(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
  }

  @Override
  public double internalLogicExecution() {
    double distMoved = Math.sqrt(
        Math.pow(getTurtle().getPosX(), 2) + Math.pow(getTurtle().getPosY(), 2));

    getTurtle().setPosX(0);
    getTurtle().setPosY(0);

    return distMoved;
  }
}
