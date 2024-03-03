package slogo.model.command.executables.mathCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;

public class AndCommand extends CommandExecutable {

  private double test1;
  private double test2;

  public AndCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    test1 = parameterExecutables.get(0).execute();
    test2 = parameterExecutables.get(1).execute();
  }

  @Override
  public double execute() {
    if (test1 != 0 && test2 != 0){
      return 1;
    }
    return 0;
  }
}
