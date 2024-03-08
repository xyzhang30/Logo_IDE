package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * @author Alisha Zhang
 */

public class Forward extends TurtleExecutable {

  private final Executable distance;

  public Forward(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    distance = parameterExecutables.get(0);
  }

  @Override
  public double executeSingle(EnvironmentApi env) {
    double traversalDistance = distance.execute(env);
    move(traversalDistance);
    return traversalDistance;
  }

}
