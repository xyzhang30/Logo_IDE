package slogo.model.command.executables.mathCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class MinusCommand extends CommandExecutable {

  private double num;

  public MinusCommand(List<Executable> parameterExecutables,
      TurtleModel turtle) {
    super(parameterExecutables, turtle);
    num = getParameterData().get(0);
  }

  @Override
  public double internalLogicExecution() {
    return 0 - num;
  }
}
