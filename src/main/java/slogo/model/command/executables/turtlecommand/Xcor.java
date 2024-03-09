package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that retrieves the x-coordinate of the current
 * turtle's position.
 */
public class Xcor extends TurtleExecutable {


  /**
   * Constructs a new {@code Xcor} command.
   *
   * @param parameterExecutables the list of parameters passed into the function (not required for
   *                             this command)
   */
  public Xcor(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  /**
   * Executes the Xcor command, returning the x-coordinate of the current turtle's position.
   *
   * @param env the environment in which the command is executed, including the turtle model,
   *            user-defined variables/commands, and the environment dimensions
   * @return the x-coordinate of the current turtle's position
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    return env.getTurtleMap().get(getCurrentTurtleId()).getPosX();
  }
}
