package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that conditionally executes a block of commands based on a given expression.

 */

public class IfCommand extends CommandExecutable {

  private final Executable expr;
  private final ListExecutable listContent;

  /**
   * Constructs a new {@code IfCommand} with the specified parameter executables.
   *
   * @param parameterExecutables the list of parameter executables representing the boolean expression and the list of commands
   */
  public IfCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    expr = parameterExecutables.get(0);
    listContent = (ListExecutable) parameterExecutables.get(1);
  }

  /**
   * Executes the command, conditionally executing the block of commands if the expression evaluates to true (non-zero).
   *
   * @param env the environment in which the command is executed, including the turtle model, user defined variables/commands, and the environment dimensions
   * @return the result of executing the last command in the listContent if the expression evaluates to true, otherwise 0
   */
  @Override
  public double execute(EnvironmentApi env) {
    if (expr.execute(env) != 0) {
      double ret = 0;
      for (Executable e : listContent.getList()) {
        ret = e.execute(env);
      }
      return ret;
    }
    return 0;
  }
}
