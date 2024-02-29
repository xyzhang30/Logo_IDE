package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class HideTurtle extends TurtleExecutable {

  public HideTurtle(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
  }

  @Override
  public double execute() {
    getTurtle().setVisible(false);
    return 0;
  }
}
