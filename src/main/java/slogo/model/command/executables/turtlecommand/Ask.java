package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that executes a block of commands with a specified set
 * of turtles.
 */
public class Ask extends CommandExecutable {

  private final ListExecutable turtleKeys;
  private final ListExecutable commands;

  /**
   * Constructs a new {@code Ask} with the specified parameter executables.
   *
   * @param params the list of parameter executables representing the list of turtle keys and the
   *               list of commands to execute
   */
  public Ask(List<Executable> params) {
    super(params);
    turtleKeys = (ListExecutable) params.get(0);
    commands = (ListExecutable) params.get(1);
  }

  /**
   * Executes the command, executing the block of commands with the specified set of turtles.
   *
   * @param env the environment in which the command is executed, including the turtle model, user
   *            defined variables/commands, and the environment dimensions
   * @return the result of executing the last command in the block of commands
   */
  @Override
  public double execute(EnvironmentApi env) {
    List<Double> oldKeys = List.copyOf(env.getActiveTurtleKeys());
    env.getActiveTurtleKeys().clear();
    turtleKeys.getList().forEach(exec -> {
      env.getActiveTurtleKeys().add(exec.execute(env));
    });
    env.syncTurtleActivation();

    double output = commands.execute(env);

    env.getActiveTurtleKeys().clear();
    env.getActiveTurtleKeys().addAll(oldKeys);
    env.syncTurtleActivation();
    return output;
  }
}
