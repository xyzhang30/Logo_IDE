package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class Repeat extends CommandExecutable {

  private final Executable repetitions;
  private final ListExecutable listContent;

  private int index;

  public Repeat(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    repetitions = parameterExecutables.get(0);
    listContent = (ListExecutable) parameterExecutables.get(1);
    index = 0;
  }

  @Override
  public double execute(EnvironmentApi env) {
    if (index == 0){
      env.getContextStack().add(this);
    }
    double val = listContent.execute(env);
    index++;
    if (index >= repetitions.execute(env)){
      index = 0;
      env.getContextStack().remove(this);
    }
    return val;
  }
}
