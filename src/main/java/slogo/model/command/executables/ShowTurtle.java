package slogo.model.command.executables;

import java.util.List;
import slogo.model.turtle.TurtleModel;

public class ShowTurtle extends CommandExecutable{

  public ShowTurtle(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
  }

  @Override
  public double internalLogicExecution() {
    getTurtle().setVisible(true);
    return 1;
  }
}
