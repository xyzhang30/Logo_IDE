package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

/**
 *  * This class represents a command executable that conditionally executes one of two blocks of commands based on a given expression.
 */
public class IfElse extends CommandExecutable {

  private final Executable expr;
  private final ListExecutable trueCommands;
  private final ListExecutable falseCommands;


  /**
   * Constructs a new {@code IfElse} with the specified parameter executables.
   *
   * @param parameterExecutables the list of parameter executables representing the boolean expression, the list of commands to execute if true, and the list of commands to execute if false
   */
  public IfElse(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    expr = parameterExecutables.get(0);
    trueCommands = (ListExecutable) parameterExecutables.get(1);
    falseCommands = (ListExecutable) parameterExecutables.get(2);
  }

  /**
   * Executes the command, conditionally executing one of the blocks of commands based on the result of the expression.
   *
   * @param env the environment in which the command is executed, including the turtle model, user defined variables/commands, and the environment dimensions
   * @return the result of executing the last command in the executed block of commands
   */
  @Override
  public double execute(EnvironmentApi env) {
    double ret = 0;
    if (expr.execute(env) != 0) {
      for (Executable e : trueCommands.getList()) {
        ret = e.execute(env);
      }
    } else {
      for (Executable e : falseCommands.getList()) {
        ret = e.execute(env);
      }
    }
    return ret;
  }
}
