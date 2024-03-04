package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class PenDownQuery extends TurtleExecutable{


  public PenDownQuery(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  @Override
  public double execute(EnvironmentApi env) {
    if (env.getTurtle().isPenDown()){
      return 1;
    }
    return 0;
  }
}
