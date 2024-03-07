package slogo.model.command.executables.turtlecommand;

import java.util.List;
import java.util.Map;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class Ask extends CommandExecutable {
  private ListExecutable turtleKeys;
  private ListExecutable commands;

  public Ask(List<Executable> params) {
    super(params);
    turtleKeys = (ListExecutable) params.get(0);
    commands = (ListExecutable) params.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    List<Double> externalTurtleKeys = List.copyOf(env.getActiveTurtleKeys());
    env.getActiveTurtleKeys().clear();

    env.getActiveTurtleKeys();
    return 0;
  }
}
