package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class ShowTurtle extends CommandExecutable {

  public ShowTurtle(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
  }

  @Override
  public double internalLogicExecution() {
    getTurtle().setVisible(true);
    return 1;
  }
}
