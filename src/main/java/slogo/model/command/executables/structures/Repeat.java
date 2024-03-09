package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class Repeat extends CommandExecutable {

  private final Executable repetitions;
  private final ListExecutable listContent;

  public Repeat(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    repetitions = parameterExecutables.get(0);
    listContent = (ListExecutable) parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    double val = 0;
    for (int i = 0; i < repetitions.execute(env); i++) {
      val = listContent.execute(env);
    }
    return val;
  }
}
