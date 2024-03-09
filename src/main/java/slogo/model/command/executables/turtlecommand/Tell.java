package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that changes the active turtles based on the specified
 * IDs.
 */
public class Tell extends CommandExecutable {

  List<Executable> ids;

  /**
   * Constructs a new {@code Tell} command with the specified turtle IDs.
   *
   * @param params the list of parameter executables representing turtle IDs
   */
  public Tell(List<Executable> params) {
    super(params);
    ids = params;
  }

  /**
   * Executes the Tell command, changing the active turtles based on the specified IDs.
   *
   * @param env the environment in which the command is executed, including the turtle model,
   *            user-defined variables/commands, and the environment dimensions
   * @return {@code 0} indicating successful execution
   */
  @Override
  public double execute(EnvironmentApi env) {
    env.getActiveTurtleKeys().clear();
    ids.forEach(exec -> {
      env.getActiveTurtleKeys().add(exec.execute(env));
    });
    env.syncTurtleActivation();
    return 0;
  }
}
