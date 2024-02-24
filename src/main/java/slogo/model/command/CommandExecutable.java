package slogo.model.command;

import java.util.List;

public abstract class CommandExecutable implements Executable{
  private List<Executable> parameterExecutables;
  private List<Double> parameterData;

  public abstract double internalLogicExecution();

  @Override
  public double execute() {
    for (Executable e: parameterExecutables) {
      parameterData.add(e.execute());
    }
    return 0;
  }
}
