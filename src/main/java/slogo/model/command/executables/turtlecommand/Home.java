package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class Home extends TurtleExecutable {


  public Home(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  @Override
  public double execute(EnvironmentApi env, TurtleModel turtle) {
    double distMoved = Math.sqrt(
        Math.pow(turtle.getPosX(), 2) + Math.pow(turtle.getPosY(), 2));

    turtle.setPosX(0);
    turtle.setPosY(0);

    return distMoved;
  }
}
