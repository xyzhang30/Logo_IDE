package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that returns the number of turtles currently active in the environment.
 */
public class Turtles extends TurtleExecutable {

  /**
   * Constructor for Turtles command
   *
   * @param params parameters passed into functions.
   */
  public Turtles(List<Executable> params) {
    super(params);
  }

  /**
   * Executes the Turtles command, returning the total number of turtles currently active in the environment.
   *
   * @param env the environment in which the command is executed, including the turtle model, user-defined variables/commands, and the environment dimensions
   * @return the total number of turtles currently active in the environment
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    return env.getTurtleMap().size();
  }
}
