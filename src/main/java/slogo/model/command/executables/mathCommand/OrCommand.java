package slogo.model.command.executables.mathCommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;

public class OrCommand extends CommandExecutable {

  private double test1;
  private double test2;

  public OrCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    test1 = parameterExecutables.get(0).execute();
    test2 = parameterExecutables.get(1).execute();
  }

  @Override
  public double execute() {
    if (Math.abs(test1) > 0.001 || Math.abs(test2) > 0.001){
      return 1;
    }
    return 0;
  }
}
