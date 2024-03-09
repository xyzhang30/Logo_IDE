package slogo.model.command.executables.userdefined;

import java.util.List;
import slogo.model.api.InvalidVariableException;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.CustomCommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a command executable that defines a custom command in the environment.
 */
public class ToCommand extends CommandExecutable {

  private final CustomCommandExecutable command;
  private final ListExecutable paramVariables;
  private final ListExecutable functionBody;

  /**
   * Constructs a new {@code ToCommand} with the specified parameters.
   *
   * @param parameterExecutables the list of parameters passed into the function, containing the
   *                             command name, its parameters, and its function body
   */
  public ToCommand(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    command = (CustomCommandExecutable) parameterExecutables.get(0);
    paramVariables = (ListExecutable) parameterExecutables.get(1);
    functionBody = (ListExecutable) parameterExecutables.get(2);
  }

  /**
   * Executes the {@code ToCommand} to define a new custom command in the environment.
   *
   * @param env the environment in which the command is executed, including user-defined
   *            variables/commands
   * @return 1 if the command is executed successfully, 0 otherwise
   */
  @Override
  public double execute(EnvironmentApi env) {
    try {
      command.setLocalParameters(paramVariables);
      env.getFuncMap().put(command.getSignature(), functionBody);
      return 1;
    } catch (InvalidVariableException e) {
      return 0;
    }
  }
}
