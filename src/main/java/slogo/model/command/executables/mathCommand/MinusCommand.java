package slogo.model.command.executables.mathCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class MinusCommand extends CommandExecutable {

  private double num;

  public MinusCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    num = getParameterData().get(0);
  }

  @Override
  public double execute() {
    return 0 - num;
  }
}
