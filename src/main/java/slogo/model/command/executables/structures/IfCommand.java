package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class IfCommand extends CommandExecutable {

  private final ConstantExecutable expr;
  private final ListExecutable listContent;

  public IfCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    expr = (ConstantExecutable) parameterExecutables.get(0);
    listContent = (ListExecutable) parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    if (expr.execute(env) != 0){
      double ret = 0;
      for (Executable e : listContent.getList()) {
        ret = e.execute(env);
      }
      return ret;
    }
    return 0;
  }
}
