package slogo.model.command.executables;

import java.util.List;
import slogo.model.turtle.TurtleModel;

public class PenDown extends CommandExecutable{

  public PenDown(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
  }

  @Override
  public double internalLogicExecution() {
    getTurtle().setPenDown(true);
    return 1;
  }
}
