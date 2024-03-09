package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class Tell extends CommandExecutable {

  List<Executable> ids;

  public Tell(List<Executable> params) {
    super(params);
    ids = params;
  }

  @Override
  public double execute(EnvironmentApi env) {
    env.getActiveTurtleKeys().clear();
    ids.forEach(exec -> {
      env.getActiveTurtleKeys().add(exec.execute(env));
    });
    env.syncTurtleActivation();
    return 0;
  }
}
