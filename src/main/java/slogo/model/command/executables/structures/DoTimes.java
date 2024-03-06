package slogo.model.command.executables.structures;

import java.util.ArrayList;
import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.command.executables.userdefined.Make;
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
    double ret = 0; //default return
    double count = 1;

    if (env.getVarMap().get(var.getSignature()) == null) { //when the variable does not exist
      ConstantExecutable constant = new ConstantExecutable(0);
      List<Executable> tempList = new ArrayList<>();
      tempList.add(var);
      tempList.add(constant);
      Make make = new Make(tempList);
      make.execute(env);
    }

    env.getVarMap().replace(var.getSignature(), count);

    for (int i = 0; i < limit.execute(env); i++) {
      for (Executable e : listContent.getList()) {
        ret = e.execute(env);
      }
      count ++;
      env.getVarMap().replace(var.getSignature(), count);
    }
    env.getVarMap().replace(var.getSignature(), count-1);
    return ret;
  }
}
