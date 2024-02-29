package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class ShowTurtle extends TurtleExecutable {

  public ShowTurtle(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
  }

  @Override
  public double execute() {
    getTurtle().setVisible(true);
    return 1;
  }
}
