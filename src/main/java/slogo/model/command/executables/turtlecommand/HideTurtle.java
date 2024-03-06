package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class HideTurtle extends TurtleExecutable {

  public HideTurtle(List<Executable> parameterExecutables) {
    super(parameterExecutables);
  }

  @Override
  public double executeSingle(EnvironmentApi env) {
    TurtleModel turtle = env.getTurtleMap().get(getCurrentTurtleId());
    turtle.setVisible(false);
    return 0.0;
  }
}
