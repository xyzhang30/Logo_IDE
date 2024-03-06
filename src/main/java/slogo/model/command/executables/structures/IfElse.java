package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class IfElse extends CommandExecutable {

  private final ConstantExecutable expr;
  private final ListExecutable trueCommands;
  private final ListExecutable falseCommands;

  public IfElse(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    expr = (ConstantExecutable) parameterExecutables.get(0);
    trueCommands = (ListExecutable) parameterExecutables.get(1);
    falseCommands = (ListExecutable) parameterExecutables.get(2);
  }

  @Override
  public double execute(EnvironmentApi env) {
    double ret = 0;
    if (expr.execute(env) != 0){
      for (Executable e : trueCommands.getList()) {
        ret = e.execute(env);
      }
    } else {
      for (Executable e : falseCommands.getList()) {
        ret = e.execute(env);
      }
    }
    return ret;
  }
}
