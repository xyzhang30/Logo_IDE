package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 *  * This class represents a turtle command executable that retrieves the heading of the turtle.
 */

public class Heading extends TurtleExecutable {

  /**
   * Constructs a new {@code Heading}.
   *
   * @param parameterExecutables the list of parameter executables (unused in this command)
   */
  public Heading(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  /**
   * Executes the command, retrieving the heading of the turtle.
   *
   * @param env the environment in which the command is executed, including the turtle model, user defined variables/commands, and the environment dimensions
   * @return the heading of the turtle (in degrees)
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    return turtle.getDegreesDirection();
  }
}
