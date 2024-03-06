package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.environment.EnvironmentApi;

public class DoTimes extends CommandExecutable {

  private VariableExecutable var;
  private ConstantExecutable limit;
  private final ListExecutable listContent;

  public DoTimes(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    var = (VariableExecutable) ((ListExecutable) parameterExecutables.get(0)).getList().get(0);
    limit = (ConstantExecutable) ((ListExecutable) parameterExecutables.get(0)).getList().get(1);
    listContent = (ListExecutable) parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    double val = 0; //default return
    for (int i = 0; i < limit.execute(env); i++) {
      for (Executable e : listContent.getList()) {
        val = e.execute(env);
      }
      val ++;
      env.getVarMap().replace(var.getSignature(), val);
    }
    return val;
  }
}
