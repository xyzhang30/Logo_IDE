package slogo.model.command.executables;

import java.util.List;
import slogo.model.turtle.TurtleModel;

public class HideTurtle extends CommandExecutable{

  public HideTurtle(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
  }

  @Override
  public double internalLogicExecution() {
    getTurtle().setVisible(false);
    return 0;
  }
}
