package slogo.model.command.executables.userdefined;

import java.util.List;
import slogo.model.api.InvalidVariableException;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.CustomCommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class ToCommand extends CommandExecutable {

  private final CustomCommandExecutable command;
  private final ListExecutable paramVariables;
  private final ListExecutable functionBody;

  public ToCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    command = (CustomCommandExecutable) parameterExecutables.get(0);
    paramVariables = (ListExecutable) parameterExecutables.get(1);
    functionBody = (ListExecutable) parameterExecutables.get(2);
  }

  @Override
  public double execute(EnvironmentApi env) {
    try{
      command.setLocalParameters(paramVariables);
      env.getFuncMap().put(command.getSignature(), functionBody);
      return 1;
    }
    catch (InvalidVariableException e){
      return 0;
    }
  }
}
