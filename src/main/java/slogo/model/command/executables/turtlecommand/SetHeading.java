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
  public double execute(EnvironmentApi env) {
    double degrees = angle.execute(env);
    double originalDirection = env.getTurtle().getDegreesDirection();
    env.getTurtle().setDirection(degrees); //set the new direction to degrees
    return Math.abs(originalDirection - env.getTurtle().getDegreesDirection());
  }
}
