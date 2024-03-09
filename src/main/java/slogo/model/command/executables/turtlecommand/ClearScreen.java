package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * This class represents a turtle command executable that clears the screen and resets the turtle's position to the center.
 */
public class ClearScreen extends TurtleExecutable {

  /**
   * Constructs a new {@code ClearScreen}.
   *
   * @param parameterExecutables the list of parameter executables (unused in this command)
   */
  public ClearScreen(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }


  /**
   * Executes the command, clearing the screen and resetting the turtle's position to the center.
   *
   * @param env the environment in which the command is executed, including the turtle model, user defined variables/commands, and the environment dimensions
   * @return the distance moved by the turtle to clear the screen (0, as the turtle is reset to the center)
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    turtle.setEraseTrace(true);

    double distMoved = Math.sqrt(
        Math.pow(turtle.getPosX(), 2) + Math.pow(turtle.getPosY(), 2));

    turtle.setPosX(0);
    turtle.setPosY(0);

    return distMoved;
  }
}
