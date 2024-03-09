package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that executes a block of commands with turtles that
 * satisfy a given condition.
 */
public class AskWith extends CommandExecutable {

  private final Executable condition;
  private final ListExecutable commands;

  /**
   * Constructs a new {@code AskWith} with the specified parameter executables.
   *
   * @param params the list of parameter executables representing the condition expression and the
   *               list of commands to execute
   */
  public AskWith(List<Executable> params) {
    super(params);
    condition = params.get(0);
    commands = (ListExecutable) params.get(1);
  }

  /**
   * Executes the command, executing the block of commands with turtles that satisfy the given
   * condition.
   *
   * <p>
   * Note: Expression handling for the condition is TBD.
   * </p>
   *
   * @param env the environment in which the command is executed, including the turtle model, user
   *            defined variables/commands, and the environment dimensions
   * @return the result of executing the last command in the block of commands
   */
  @Override
  public double execute(EnvironmentApi env) {
    List<Double> oldKeys = List.copyOf(env.getActiveTurtleKeys());
    env.getActiveTurtleKeys().clear();

    // Expression handling TBD!

    double output = commands.execute(env);

    env.getActiveTurtleKeys().clear();
    env.getActiveTurtleKeys().addAll(oldKeys);
    return output;
  }
}
