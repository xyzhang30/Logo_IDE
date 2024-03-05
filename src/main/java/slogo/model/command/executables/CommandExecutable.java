package slogo.model.command.executables;

import java.util.List;
import slogo.model.environment.EnvironmentApi;

public abstract class CommandExecutable implements Executable {

  private List<Executable> parameterExecutables;
  public CommandExecutable(List<Executable> params) {
    parameterExecutables = params;
  }
  @Override
  public abstract double execute(EnvironmentApi env);
}
