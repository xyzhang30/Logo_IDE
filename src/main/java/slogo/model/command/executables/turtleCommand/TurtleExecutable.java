package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public abstract class TurtleExecutable extends CommandExecutable {
  private TurtleModel turtle;
  public TurtleExecutable(List<Executable> parameterExecutables, TurtleModel t) {
    super(parameterExecutables);
    turtle = t;
  }
  public TurtleModel getTurtle(){
    return turtle;
  }
}
