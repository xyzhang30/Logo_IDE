package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public abstract class TurtleExecutable extends CommandExecutable {
  public TurtleExecutable(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }
}
