package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a turtle command executable that returns the ID of the current turtle.
 */
public class Id extends TurtleExecutable {

  /**
   * Constructor for ID Executable
   *
   * @param params parameters passed into functions.
   */
  public Id(List<Executable> params) {
    super(params);
  }

  /**
   * Executes the command, returning the ID of the current turtle.
   *
   * @param env the environment in which the command is executed, including the turtle model, user-defined variables/commands, and the environment dimensions
   * @return the ID of the current turtle
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    return getCurrentTurtleId();
  }
}
