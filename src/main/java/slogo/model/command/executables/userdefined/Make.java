package slogo.model.command.executables.userdefined;

import java.util.List;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that assigns a value to a variable.
 */

public class Make extends CommandExecutable {

  private final VariableExecutable var;
  private final Executable value;

  /**
   * Constructs a new {@code Make} command with the specified parameters.
   *
   * @param parameterExecutables the list of parameters passed into the function, containing the variable and its assigned value
   */
  public Make(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    var = (VariableExecutable) parameterExecutables.get(0);
    value = parameterExecutables.get(1);
  }

  /**
   * Executes the Make command, assigning the value to the specified variable in the environment.
   *
   * @param env the environment in which the command is executed, including user-defined variables/commands
   * @return the value assigned to the variable
   */
  @Override
  public double execute(EnvironmentApi env) {
    env.getVarMap().put(var.getSignature(), value.execute(env));
    return var.execute(env);
  }
}
