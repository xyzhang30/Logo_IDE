package slogo.model.command.executables;

import java.util.List;
import slogo.model.turtle.TurtleModel;

public class PenUp extends CommandExecutable{

  public PenUp(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
  }

  @Override
  public double internalLogicExecution() {
    getTurtle().setPenDown(false);
    return 0;
  }
}
