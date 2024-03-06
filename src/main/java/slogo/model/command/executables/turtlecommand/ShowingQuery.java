package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class ShowingQuery extends TurtleExecutable{

  public ShowingQuery(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    if (turtle.isVisible()){
      return 1;
    }
    return 0;
  }
}
