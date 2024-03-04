package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class PenDown extends TurtleExecutable {


  public PenDown(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  @Override
  public double execute(EnvironmentApi env) {
    env.getTurtle().setPenDown(true);
    return 1;
  }
}
