package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;

public class MinusCommand extends CommandExecutable {

  private double num;

  public MinusCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    num = parameterExecutables.get(0).execute();
  }

  @Override
  public double execute() {
    return 0 - num;
  }
}
