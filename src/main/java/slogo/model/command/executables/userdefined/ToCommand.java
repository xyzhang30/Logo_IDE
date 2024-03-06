package slogo.model.command.executables.userdefined;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class ToCommand extends CommandExecutable {

  private String commandName;
  private ListExecutable paramVariables;
  private ListExecutable functionBody;

  public ToCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
//    commandName = parameterExecutables.get(0);
    paramVariables = (ListExecutable) parameterExecutables.get(1);
    functionBody = (ListExecutable) parameterExecutables.get(2);
  }

  @Override
  public double execute(EnvironmentApi env) {

    return 0;
  }
}
