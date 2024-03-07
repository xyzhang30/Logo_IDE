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
  private double currentTurtleKey;
  private TurtleModel currentTurtle;

  /**
   * Default constructor for Turtle Executable.
   *
   * @param params parameters passed into functions.
   */
  public TurtleExecutable(List<Executable> params) {
    super(params);
  }

  /**
   * Returns the ID of the current active Turtle.
   * Each Turtle command uses logic specific to a single turtle. This is its ID.
   * @return double  The current ID of the active Turtle.
   */
  public double getCurrentTurtleId(){
    return currentTurtleKey;
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
    for (double key : env.getActiveTurtleKeys()){
      currentTurtleKey = key;
      currentTurtle = env.getTurtleMap().get(key);
      output = executeSingle(env);
    }
    return output;
  }

  /**
   * Executes a command on a single Turtle. Behavior is command specific. Target is turtle
   * specific.
   *
   * @param env The run environment.
   * @return double  The execution return value of the command on the specific turtle.
   */
  public abstract double executeSingle(EnvironmentApi env);

  /**
   * Helper function to move a Turtle in space.
   * @param distance The distance to move the Turtle in the direction it's facing.
   */
  public void move(double distance){
    double distX = distance * Math.cos(currentTurtle.getRadianDirection());
    double distY = distance * Math.sin(currentTurtle.getRadianDirection());
    currentTurtle.setPosX(currentTurtle.getPosX() + distX);
    currentTurtle.setPosY(currentTurtle.getPosY() + distY);
  }
  public void rotate(double degrees){

  }
}
