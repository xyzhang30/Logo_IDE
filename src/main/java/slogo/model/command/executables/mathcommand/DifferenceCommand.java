package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class DifferenceCommand extends CommandExecutable {

  private final Executable num1;
  private final Executable num2;

  public DifferenceCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    num1 = parameterExecutables.get(0);
    num2 = parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    return num1.execute(env) - num2.execute(env);
  }
}
