package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

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
    double degrees = angle.execute(env);
    rotate(degrees);
    return degrees;
  }
}
