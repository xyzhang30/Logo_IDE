package slogo.model.command.executables;

import java.util.HashMap;
import java.util.Map;
import slogo.model.api.InvalidVariableException;
import slogo.model.environment.EnvironmentApi;

public class CustomCommandExecutable implements Executable {

  private final String signature;
  private final Map<String, Double> localVariables;

  public CustomCommandExecutable(String sig) {
    signature = sig;
    localVariables = new HashMap<>();
  }

  @Override
  public double execute(EnvironmentApi env) {

    return env.getFuncMap().get(signature).execute(env);
  }

  public String getSignature() {
    return signature;
  }

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
