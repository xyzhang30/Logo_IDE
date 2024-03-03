package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class Ycor extends TurtleExecutable{

  public Ycor(List<Executable> parameterExecutables,
      TurtleModel t) {
    super(parameterExecutables, t);
  }

  @Override
  public double execute() {
    return getTurtle().getPosY();
  }
}
