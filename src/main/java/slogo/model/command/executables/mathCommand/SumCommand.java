package slogo.model.command.executables.mathCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class SumCommand extends CommandExecutable {

  private double numOne;
  private double numTwo;

  public SumCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    numOne = getParameterData().get(0);
    numTwo = getParameterData().get(1);
  }

  @Override
  public double execute() {
    return numOne + numTwo;
  }
}
