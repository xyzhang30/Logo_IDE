package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class Xcor extends TurtleExecutable{

  public Xcor(List<Executable> parameterExecutables,
      TurtleModel t) {
    super(parameterExecutables, t);
  }

  @Override
  public double execute() {
    return getTurtle().getPosX();
  }
}
