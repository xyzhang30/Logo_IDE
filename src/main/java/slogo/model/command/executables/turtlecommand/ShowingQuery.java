package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;


/**
 * This class represents a turtle command executable that queries whether the turtle is currently showing or not.
 */
public class ShowingQuery extends TurtleExecutable {


  /**
   * Constructs a new {@code ShowingQuery} executable.
   *
   * @param parameterExecutables the list of parameter executables (not used in this command)
   */
  public ShowingQuery(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  /**
   * Executes the command, querying whether the turtle is currently showing or not.
   *
   * @param env the environment in which the command is executed, including the turtle model, user-defined variables/commands, and the environment dimensions
   * @return {@code 1} if the turtle is showing, {@code 0} if it is hidden
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    if (turtle.isVisible()) {
      return 1;
    }
    return 0;
  }
}
