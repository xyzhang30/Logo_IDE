package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that repeats a set of commands a specified number of times.
 */

public class DoTimes extends CommandExecutable {

  private final VariableExecutable var;
  private final Executable limit;
  private final ListExecutable listContent;

  /**
   * Constructs a new {@code DoTimes} command with the specified parameter executables.
   *
   * @param parameterExecutables the list of parameter executables representing the variable, limit, and list of commands
   */
  public DoTimes(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    var = (VariableExecutable) ((ListExecutable) parameterExecutables.get(0)).getList().get(0);
    limit = ((ListExecutable) parameterExecutables.get(0)).getList().get(1);
    listContent = (ListExecutable) parameterExecutables.get(1);
  }

  /**
   * Executes the command, repeating the list of commands for each index value from 1 to the specified limit.
   *
   * @param env the environment in which the command is executed, including the turtle model, user defined variables/commands, and the environment dimensions
   * @return the result of executing the last command in the listContent, after the loop completes, 0 if no commands were executed
   */
  @Override
  public double execute(EnvironmentApi env) {
    String indexKey = var.getSignature();
    env.getVarMap().put(indexKey, 1.0);
    double lim = limit.execute(env);
    double ret = 0;

    while (env.getVarMap().get(indexKey) <= lim) {
      ret = listContent.execute(env);
      env.getVarMap().put(indexKey, env.getVarMap().get(indexKey) + 1);
    }
    env.getVarMap().put(indexKey, lim);
    return ret;
  }
}
