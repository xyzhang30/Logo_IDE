package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class Id extends TurtleExecutable{

  /**
   * Constructor for ID Executable
   *
   * @param params parameters passed into functions.
   */
  public Id(List<Executable> params) {
    super(params);
  }

  @Override
  public double executeSingle(EnvironmentApi env) {
    return getCurrentTurtleId();
  }
}
