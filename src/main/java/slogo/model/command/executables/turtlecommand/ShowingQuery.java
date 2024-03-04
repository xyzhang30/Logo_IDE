package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class ShowingQuery extends TurtleExecutable{

  public ShowingQuery(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  @Override
  public double execute(EnvironmentApi env) {
    if (env.getTurtle().isVisible()){
      return 1;
    }
    return 0;
  }
}
