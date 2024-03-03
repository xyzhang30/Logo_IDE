package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;

public class ProductCommand extends CommandExecutable {

  private double numOne;
  private double numTwo;

  public ProductCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    numOne = parameterExecutables.get(0).execute();
    numTwo = parameterExecutables.get(1).execute();
  }

  @Override
  public double execute() {
    return (numOne * numTwo);
  }
}
