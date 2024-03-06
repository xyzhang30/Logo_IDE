package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class Tell extends CommandExecutable {
  List<Executable> ids;
  public Tell(List<Executable> params) {
    super(params);
    ids = params;
  }

  @Override
  public double execute(EnvironmentApi env) {
    ids.forEach(exec -> {
      double id = exec.execute(env);
      env.getTurtleMap().putIfAbsent(id,new TurtleModel(id));
      env.getTurtleMap().get(id).setActive(true);
    });
    return 0;
  }
}
