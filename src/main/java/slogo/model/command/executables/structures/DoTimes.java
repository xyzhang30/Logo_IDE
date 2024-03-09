package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.environment.EnvironmentApi;

public class DoTimes extends CommandExecutable {

  private final VariableExecutable var;
  private final Executable limit;
  private final ListExecutable listContent;

  public DoTimes(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    var = (VariableExecutable) ((ListExecutable) parameterExecutables.get(0)).getList().get(0);
    limit = ((ListExecutable) parameterExecutables.get(0)).getList().get(1);
    listContent = (ListExecutable) parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    String indexKey = var.getSignature();
    env.getVarMap().put(indexKey, 1.0);
    double lim = limit.execute(env);
    double ret = 0;

    while (env.getVarMap().get(indexKey) <= lim) {
      ret = listContent.execute(env);
      env.getVarMap().put(indexKey, env.getVarMap().get(indexKey) + 1);
    }
    env.getVarMap().put(indexKey, lim);
    return ret;
  }
}
