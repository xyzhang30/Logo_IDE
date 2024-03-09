package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

/**
 * This class represents a turtle command executable that shows the turtle on the screen.
 */
public class ShowTurtle extends TurtleExecutable {

  /**
   * Constructs a new {@code ShowTurtle} executable.
   *
   * @param parameterExecutables the list of parameter executables (not used in this command)
   */
  public ShowTurtle(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  /**
   * Executes the command, making the turtle visible on the screen.
   *
   * @param env the environment in which the command is executed, including the turtle model,
   *            user-defined variables/commands, and the environment dimensions
   * @return {@code 1} to indicate that the turtle is now visible
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    turtle.setVisible(true);
    return 1;
  }
}
