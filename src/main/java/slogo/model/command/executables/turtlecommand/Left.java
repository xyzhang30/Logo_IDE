package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * @author Alisha Zhang
 */

public class Left extends TurtleExecutable {

  private Executable angle;

  public Left(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    angle = parameterExecutables.get(0);
  }

  @Override
  public double execute(EnvironmentApi env) {
    double degrees = angle.execute(env);
    double currRadianDirection = env.getTurtle().getRadianDirection();
    double newRadianDirection = currRadianDirection + Math.toRadians(degrees);
    env.getTurtle().setDirection(Math.toDegrees(newRadianDirection));
    return degrees;
  }
}
