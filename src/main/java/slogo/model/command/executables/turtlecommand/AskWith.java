package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class AskWith extends CommandExecutable {

  private final Executable condition;
  private final ListExecutable commands;

  public AskWith(List<Executable> params) {
    super(params);
    condition = params.get(0);
    commands = (ListExecutable) params.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    List<Double> oldKeys = List.copyOf(env.getActiveTurtleKeys());
    env.getActiveTurtleKeys().clear();

    // Expression handling TBD!

    double output = 0;
    for (Executable e : commands.getList()) {
      output = e.execute(env);
    }

    env.getActiveTurtleKeys().clear();
    env.getActiveTurtleKeys().addAll(oldKeys);
    return output;
  }
}
