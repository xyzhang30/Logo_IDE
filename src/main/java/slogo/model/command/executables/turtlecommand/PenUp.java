package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class PenUp extends TurtleExecutable {

  public PenUp(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
  }

  @Override
  public double execute() {
    getTurtle().setPenDown(false);
    return 0;
  }
}
