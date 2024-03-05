package slogo.model.command.executables.mathcommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * AndCommand Executable. Takes two parameters.
 */
public class AndCommand extends CommandExecutable {
  private final Executable test1;
  private final Executable test2;

  /**
   * Constructor for this Command Executable.
   * @param params  List of Executables passed as parameters into this function. Should have size 2.
   */
  public AndCommand(List<Executable> params) {
    super(params);
    test1 = params.get(0);
    test2 = params.get(1);
  }

  /**
   * And checks if both parameters are nonzero and returns 1.0 if so, 0.0 otherwise.
   * @param env  The Environment for the Executable to execute on.
   * @return double  1.0 if both nonzero, 0.0 otherwise.
   */
  @Override
  public double execute(EnvironmentApi env) {
    if (test1.execute(env) != 0 && test2.execute(env) != 0){
      return 1.0;
    }
    return 0.0;
  }
}
