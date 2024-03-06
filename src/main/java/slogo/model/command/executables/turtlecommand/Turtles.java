package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class Turtles extends TurtleExecutable{

  /**
   * Constructor for Turtles command
   *
   * @param params parameters passed into functions.
   */
  public Turtles(List<Executable> params) {
    super(params);
  }

  @Override
  public double executeSingle(EnvironmentApi env) {
    return env.getTurtleMap().size();
  }
}
