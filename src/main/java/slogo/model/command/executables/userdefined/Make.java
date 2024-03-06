package slogo.model.command.executables.userdefined;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.environment.EnvironmentApi;

public class Make extends CommandExecutable {

  private VariableExecutable var;
  private ConstantExecutable value;

  public Make(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    var = (VariableExecutable) parameterExecutables.get(0);
    value = (ConstantExecutable) parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    env.getVarMap().put(var.getSignature(),value.execute(env));
    return value.execute(env);
  }
}
