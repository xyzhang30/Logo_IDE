package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * This class represents a turtle command executable that sets the position of the turtle to a
 * specified (x, y) coordinate.
 */
public class Setxy extends TurtleExecutable {

  private final Executable destinationX;
  private final Executable destinationY;

  /**
   * Constructs a new {@code Setxy} executable with the specified destination coordinates.
   *
   * @param parameterExecutables the list of parameter executables representing the x and y
   *                             coordinates of the destination position
   */
  public Setxy(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    destinationX = parameterExecutables.get(0);
    destinationY = parameterExecutables.get(1);
  }

  /**
   * Executes the command, setting the position of the turtle to the specified (x, y) coordinate.
   *
   * @param env the environment in which the command is executed, including the turtle model,
   *            user-defined variables/commands, and the environment dimensions
   * @return the Euclidean distance moved by the turtle to reach the new position
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    double newPosX = destinationX.execute(env);
    double newPoxY = destinationY.execute(env);
    double distMoved = Math.sqrt(
        Math.pow(turtle.getPosX() - newPosX, 2) + Math.pow(turtle.getPosY() - newPoxY, 2));

    turtle.setPosX(newPosX);
    turtle.setPosY(newPoxY);

    return distMoved;
  }

}
