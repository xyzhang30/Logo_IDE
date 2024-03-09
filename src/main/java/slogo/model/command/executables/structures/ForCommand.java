package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.environment.EnvironmentApi;

/**
 *  This class represents a command executable that iterates through a block of commands for a specified range of values.
 */

public class ForCommand extends CommandExecutable {

  private final VariableExecutable var;
  private final Executable start;
  private final Executable end;
  private final Executable increment;
  private final ListExecutable listContent;

  /**
   * Constructs a new {@code ForCommand} with the specified parameter executables.
   *
   * @param parameterExecutables the list of parameter executables representing the variable, start value, end value, increment, and list of commands
   */
  public ForCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    ListExecutable paramFirstList = (ListExecutable) parameterExecutables.get(0);
    var = (VariableExecutable) paramFirstList.getList().get(0);
    start = paramFirstList.getList().get(1);
    end = paramFirstList.getList().get(2);
    increment = paramFirstList.getList().get(3);

    listContent = (ListExecutable) parameterExecutables.get(1);
  }


  /**
   * Executes the command, iterating through the block of commands for each value within the specified range.
   *
   * @param env the environment in which the command is executed, including the turtle model, user defined variables/commands, and the environment dimensions
   * @return the result of executing the last command in the listContent, after the loop completes
   */
  @Override
  public double execute(EnvironmentApi env) {
    String indexKey = var.getSignature();
    env.getVarMap().put(indexKey, start.execute(env));
    double endLimit = end.execute(env);
    double step = increment.execute(env);
    double ret = 0;

    while (env.getVarMap().get(indexKey) < endLimit) {
      for (Executable e : listContent.getList()) {
        ret = e.execute(env);
      }
      env.getVarMap().put(indexKey, env.getVarMap().get(indexKey) + step);
    }
    env.getVarMap().put(indexKey, env.getVarMap().get(indexKey) - step);
    return ret;
  }
}
