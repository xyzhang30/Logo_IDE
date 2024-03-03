package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class ShowingQuery extends TurtleExecutable{

  public ShowingQuery(List<Executable> parameterExecutables,
      TurtleModel t) {
    super(parameterExecutables, t);
  }

  @Override
  public double execute() {
    if (getTurtle().isVisible()){
      return 1;
    }
    return 0;
  }
}
