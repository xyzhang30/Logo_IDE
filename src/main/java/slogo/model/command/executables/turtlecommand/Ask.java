package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class Ask extends CommandExecutable {
  private final ListExecutable turtleKeys;
  private ListExecutable commands;

  public Ask(List<Executable> params) {
    super(params);
    turtleKeys = (ListExecutable) params.get(0);
    commands = (ListExecutable) params.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    List<Double> oldKeys = List.copyOf(env.getActiveTurtleKeys());
    env.getActiveTurtleKeys().clear();
    turtleKeys.getList().forEach(exec -> {env.getActiveTurtleKeys().add(exec.execute(env));});

    commands.getList().forEach(exec -> {exec.execute(env);});

    env.getActiveTurtleKeys().clear();
    env.getActiveTurtleKeys().addAll(oldKeys);
    return 0;
  }
}
