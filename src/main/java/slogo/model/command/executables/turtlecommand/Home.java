package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * This class represents a turtle command executable that moves the turtle to its home position.
 */
public class Home extends TurtleExecutable {

  /**
   * Constructs a new {@code Home} command.
   *
   * @param parameterExecutables the list of parameter executables (unused in this command)
   */
  public Home(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  /**
   * Executes the command, moving the turtle to its home position.
   *
   * @param env the environment in which the command is executed, including the turtle model, user defined variables/commands, and the environment dimensions
   * @return the distance the turtle moved from its previous position to its home position
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    double distMoved = Math.sqrt(
        Math.pow(turtle.getPosX(), 2) + Math.pow(turtle.getPosY(), 2));

    turtle.setPosX(0);
    turtle.setPosY(0);

    return distMoved;
  }
}
