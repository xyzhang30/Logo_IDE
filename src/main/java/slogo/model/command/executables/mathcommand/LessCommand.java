package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class LessCommand extends CommandExecutable {

  private Executable test1;
  private Executable test2;

  public LessCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    test1 = parameterExecutables.get(0);
    test2 = parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    if (test1.execute(env) - test2.execute(env) < 0.001){
      return 1;
    }
    return 0;
  }
}
