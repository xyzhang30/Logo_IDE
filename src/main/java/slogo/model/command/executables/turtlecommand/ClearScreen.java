package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class ClearScreen extends TurtleExecutable{

  public ClearScreen(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  @Override
  public double execute(EnvironmentApi env) {
    env.getTurtle().setEraseTrace(true);

    double distMoved = Math.sqrt(
        Math.pow(env.getTurtle().getPosX(), 2) + Math.pow(env.getTurtle().getPosY(), 2));

    env.getTurtle().setPosX(0);
    env.getTurtle().setPosY(0);

    return distMoved;
  }
}
