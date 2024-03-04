package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * @author Alisha Zhang
 */

public class Back extends TurtleExecutable {

  private Executable distance;

  public Back(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    distance = parameterExecutables.get(0);
  }

  @Override
  public double execute(EnvironmentApi env) {
    double traversalDistance = distance.execute(env);

    double distX = traversalDistance * Math.cos(env.getTurtle().getRadianDirection());
    double distY = traversalDistance * Math.sin(env.getTurtle().getRadianDirection());

    env.getTurtle().setPosX(env.getTurtle().getPosX() - distX);
    env.getTurtle().setPosY(env.getTurtle().getPosY() - distY);

    return traversalDistance;
  }


}
