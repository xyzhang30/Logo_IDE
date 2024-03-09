package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class QuotientCommand extends CommandExecutable {

  private final Executable numOne;
  private final Executable numTwo;

  public QuotientCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    numOne = parameterExecutables.get(0);
    numTwo = parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    return numOne.execute(env) / numTwo.execute(env);
  }
}
