package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;

public class GreaterCommand extends CommandExecutable {

  private double test1;
  private double test2;

  public GreaterCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    test1 = parameterExecutables.get(0).execute();
    test2 = parameterExecutables.get(1).execute();
  }

  @Override
  public double execute() {
    if ((test1 - test2) > 0.001){
      return 1;
    }
    return 0;
  }
}
