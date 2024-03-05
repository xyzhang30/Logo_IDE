package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;

/**
 * Abstract parent class for all Executables that use Turtle.
 */
public abstract class TurtleExecutable extends CommandExecutable {

  /**
   * Default constructor for Turtle Executable.
   *
   * @param params parameters passed into functions.
   */
  public TurtleExecutable(List<Executable> params) {
    super(params);
  }
}
