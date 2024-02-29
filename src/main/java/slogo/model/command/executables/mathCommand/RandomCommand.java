package slogo.model.command.executables.mathCommand;

import java.util.List;
import java.util.Random;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class RandomCommand extends CommandExecutable {

  private double max;

  public RandomCommand(List<Executable> parameterExecutables,
      TurtleModel turtle) {
    super(parameterExecutables, turtle);
    max = getParameterData().get(0);
  }

  @Override
  public double internalLogicExecution() {
    Random rand = new Random();
    return rand.nextDouble(max);
  }
}
