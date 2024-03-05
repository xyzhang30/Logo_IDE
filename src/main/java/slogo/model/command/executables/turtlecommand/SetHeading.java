package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class SetHeading extends TurtleExecutable {

  private Executable angle;

  public SetHeading(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    angle = parameterExecutables.get(0);
  }

  @Override
  public double execute(EnvironmentApi env, TurtleModel turtle) {
    double degrees = angle.execute(env);
    double originalDirection = turtle.getDegreesDirection();
    turtle.setDirection(degrees); //set the new direction to degrees
    return Math.abs(originalDirection - turtle.getDegreesDirection());
  }
}
