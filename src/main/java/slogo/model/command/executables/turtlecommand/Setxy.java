package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class Setxy extends TurtleExecutable {

  private Executable destinationX;
  private Executable destinationY;

  public Setxy(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    destinationX = parameterExecutables.get(0);
    destinationY = parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    double newPosX = destinationX.execute(env);
    double newPoxY = destinationY.execute(env);
    double distMoved = Math.sqrt(
        Math.pow(env.getTurtle().getPosX() - newPosX, 2) + Math.pow(env.getTurtle().getPosY() - newPoxY,
            2));

    env.getTurtle().setPosX(newPosX);
    env.getTurtle().setPosY(newPoxY);

    return distMoved;
  }

}
