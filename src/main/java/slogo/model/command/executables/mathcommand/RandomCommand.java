package slogo.model.command.executables.mathcommand;

import java.util.List;
import java.util.Random;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

public class RandomCommand extends CommandExecutable {

  private final Executable max;

  public RandomCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    max = parameterExecutables.get(0);
  }

  @Override
  public double execute(EnvironmentApi env) {
    Random rand = new Random();
    return rand.nextDouble(max.execute(env));
  }
}
