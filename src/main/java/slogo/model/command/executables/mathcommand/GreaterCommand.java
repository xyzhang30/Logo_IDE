package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class GreaterCommand extends CommandExecutable {

  private final Executable test1;
  private final Executable test2;

  public GreaterCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    test1 = parameterExecutables.get(0);
    test2 = parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    if (test1.execute(env) - test2.execute(env) > 0.001) {
      return 1;
    }
    return 0;
  }
}
