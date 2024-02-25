package slogo.model.command.executables;

import java.util.ArrayList;
import java.util.List;
import slogo.model.turtle.TurtleModel;

public abstract class CommandExecutable implements Executable {

  private final List<Executable> parameterExecutables;
  private List<Double> parameterData;
  private final TurtleModel turtle;

  public CommandExecutable(List<Executable> parameterExecutables, TurtleModel turtle) {
    this.parameterExecutables = parameterExecutables;
    this.turtle = turtle;
    this.parameterData = new ArrayList<>();
    execute(); //?
  }

  public abstract double internalLogicExecution();

  @Override
  public double execute() {
    for (Executable e : parameterExecutables) {
      parameterData.add(e.execute());
    }
    return 0;
  }

  protected TurtleModel getTurtle() {
    return turtle;
  }

  protected List<Double> getParameterData() {
    return parameterData;
  }
}
