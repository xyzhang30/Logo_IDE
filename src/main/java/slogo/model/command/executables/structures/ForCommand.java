package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.environment.EnvironmentApi;

public class ForCommand extends CommandExecutable {

  private final VariableExecutable var;
  private final ConstantExecutable start;
  private final ConstantExecutable end;
  private final ConstantExecutable increment;
  private final ListExecutable listContent;

  public ForCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    ListExecutable paramFirstList = (ListExecutable) parameterExecutables.get(0);
    var = (VariableExecutable) paramFirstList.getList().get(0);
    start = (ConstantExecutable) paramFirstList.getList().get(1);
    end = (ConstantExecutable) paramFirstList.getList().get(2);
    increment = (ConstantExecutable) paramFirstList.getList().get(3);

    listContent = (ListExecutable) parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    double ret = 0;
    double count = start.execute(env);
    env.getVarMap().replace(var.getSignature(), count);

    for (double i = start.execute(env); i < end.execute(env); i += increment.execute(env)) {
      for (Executable e : listContent.getList()) {
        ret = e.execute(env);
      }
      count ++;
      env.getVarMap().replace(var.getSignature(), count);
    }
    return ret;
  }
}
