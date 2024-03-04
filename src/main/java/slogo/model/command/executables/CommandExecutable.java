package slogo.model.command.executables;

import java.util.ArrayList;
import java.util.List;
import slogo.model.environment.EnvironmentApi;

public abstract class CommandExecutable implements Executable {

  private final List<Executable> parameterExecutables;
  private List<Double> parameterData;

  public CommandExecutable(List<Executable> parameterExecutables) {
    this.parameterExecutables = parameterExecutables;
    this.parameterData = new ArrayList<>();
  }
  @Override
  public abstract double execute(EnvironmentApi env);

  protected List<Double> getParameterData() {
    return parameterData;
  }
}
