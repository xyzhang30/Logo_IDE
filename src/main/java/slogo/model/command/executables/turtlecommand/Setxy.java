package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class Setxy extends TurtleExecutable {

  private final Executable destinationX;
  private final Executable destinationY;

  public Setxy(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    destinationX = parameterExecutables.get(0);
    destinationY = parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env, TurtleModel turtle) {
    double newPosX = destinationX.execute(env);
    double newPoxY = destinationY.execute(env);
    double distMoved = Math.sqrt(
        Math.pow(turtle.getPosX() - newPosX, 2) + Math.pow(turtle.getPosY() - newPoxY, 2));

    turtle.setPosX(newPosX);
    turtle.setPosY(newPoxY);

    return distMoved;
  }

}
