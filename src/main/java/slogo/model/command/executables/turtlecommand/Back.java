package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * @author Alisha Zhang
 */

public class Back extends TurtleExecutable {

  private final Executable distance;

  public Back(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    distance = parameterExecutables.get(0);
  }

  @Override
  public double execute(EnvironmentApi env, TurtleModel turtle) {
    double traversalDistance = distance.execute(env);

    double distX = traversalDistance * Math.cos(turtle.getRadianDirection());
    double distY = traversalDistance * Math.sin(turtle.getRadianDirection());

    turtle.setPosX(turtle.getPosX() - distX);
    turtle.setPosY(turtle.getPosY() - distY);

    return traversalDistance;
  }


}
