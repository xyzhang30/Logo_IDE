package slogo.model.command.executables;

import java.util.HashMap;
import java.util.Map;
import slogo.model.api.InvalidVariableException;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents a custom command executable in the environment.
 */

public class CustomCommandExecutable implements Executable {

  private final String signature;
  private final Map<String, Double> localVariables;

  /**
   * Constructs a new {@code CustomCommandExecutable} with the specified signature.
   *
   * @param sig the signature of the custom command
   */
  public CustomCommandExecutable(String sig) {
    signature = sig;
    localVariables = new HashMap<>();
  }

  /**
   * Executes the custom command in the environment.
   *
   * @param env the environment in which the command is executed
   * @return the result of executing the command
   */
  @Override
  public double execute(EnvironmentApi env) {

    return env.getFuncMap().get(signature).execute(env);
  }

  /**
   * Retrieves the signature of the custom command.
   *
   * @return the signature of the custom command
   */
  public String getSignature() {
    return signature;
  }

  /**
   * Sets the local parameters (variables) for the custom command.
   *
   * @param params the list of local parameters for the command
   * @throws InvalidVariableException if there is an error setting the local parameters
   */
  public void setLocalParameters(ListExecutable params) throws InvalidVariableException {
    try {
      for (Executable e : params.getList()) {
        localVariables.put(((VariableExecutable) e).getSignature(), 0.0);
      }
    } catch (ClassCastException e) {
      throw new InvalidVariableException(e.getMessage());
    }
  }
}
