package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class ShowTurtle extends TurtleExecutable {

  public ShowTurtle(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    turtle.setVisible(true);
    return 1;
  }
}
