package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class MinusCommand extends CommandExecutable {

  private final Executable num;

  public MinusCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    num = parameterExecutables.get(0);
  }

  @Override
  public double execute(EnvironmentApi env) {
    return 0 - num.execute(env);
  }
}
