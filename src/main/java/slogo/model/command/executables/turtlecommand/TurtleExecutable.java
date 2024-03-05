package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

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

  /**
   * Executes commands related to Turtles. Calls each command on a given active Turtle.
   *
   * @param env The Environment for the Executable to execute on.
   * @return double  The return of the execution on the final active turtle.
   */
  @Override
  public double execute(EnvironmentApi env) {
    double output = 0;
    for (TurtleModel turtle : env.getTurtleMap().values()) {
      if (turtle.isActive()) {
        output = execute(env, turtle);
      }
    }
    return output;
  }

  /**
   * Executes a command on a single Turtle. Behavior is command specific. Target is turtle
   * specific.
   *
   * @param env    The run environment.
   * @param turtle Specific turtle to execute this command upon.
   * @return double  The execution return value of the command on the specific turtle.
   */
  public abstract double execute(EnvironmentApi env, TurtleModel turtle);
}
