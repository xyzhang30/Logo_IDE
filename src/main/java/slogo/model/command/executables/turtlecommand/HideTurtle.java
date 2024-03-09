package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * This class represents a turtle command executable that hides the turtle.
 */

public class HideTurtle extends TurtleExecutable {

  /**
   * Constructs a new {@code HideTurtle}.
   *
   * @param parameterExecutables the list of parameter executables (unused in this command)
   */
  public HideTurtle(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  /**
   * Executes the command, hiding the turtle from view.
   *
   * @param env the environment in which the command is executed, including the turtle model, user defined variables/commands, and the environment dimensions
   * @return 0.0 indicating successful execution
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    turtle.setVisible(false);
    return 0.0;
  }
}
