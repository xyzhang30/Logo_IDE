package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class Ycor extends TurtleExecutable{


  public Ycor(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  @Override
  public double executeSingle(EnvironmentApi env) {
    return env.getTurtleMap().get(getCurrentTurtleId()).getPosY();
  }
}
