package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * @author Alisha Zhang
 */

public class Left extends TurtleExecutable {

  private final Executable angle;

  public Left(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    angle = parameterExecutables.get(0);
  }

  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    double degrees = angle.execute(env);
    double newRadianDirection = turtle.getRadianDirection() + Math.toRadians(degrees);
    turtle.setDirection(Math.toDegrees(newRadianDirection));
    return degrees;
  }
}
