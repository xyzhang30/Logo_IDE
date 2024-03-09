package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a turtle command executable that moves the turtle backward by a specified
 * distance.
 */
public class Back extends TurtleExecutable {

  private final Executable distance;

  /**
   * Constructs a new {@code Back} with the specified parameter executables.
   *
   * @param parameterExecutables the list of parameter executables representing the distance by
   *                             which to move the turtle backward
   */
  public Back(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    distance = parameterExecutables.get(0);
  }

  /**
   * Executes the command, moving the turtle backward by the specified distance.
   *
   * @param env the environment in which the command is executed, including the turtle model, user
   *            defined variables/commands, and the environment dimensions
   * @return the distance by which the turtle moved backward
   */
  @Override
  public double executeSingle(EnvironmentApi env) {
    double traversalDistance = distance.execute(env);
    move(-traversalDistance);
    return traversalDistance;
  }

}
