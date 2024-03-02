package slogo.model.command.executables.turtleCommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class Heading extends TurtleExecutable{

  public Heading(List<Executable> parameterExecutables,
      TurtleModel t) {
    super(parameterExecutables, t);
  }

  @Override
  public double execute() {
    return getTurtle().getDegreesDirection();
  }
}
