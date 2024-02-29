package slogo.model.command.executables.mathCommand;

import java.util.List;
import java.util.Random;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class RandomCommand extends CommandExecutable {

  private double max;

  public RandomCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    max = getParameterData().get(0);
  }

  @Override
  public double execute() {
    Random rand = new Random();
    return rand.nextDouble(max);
  }
}
