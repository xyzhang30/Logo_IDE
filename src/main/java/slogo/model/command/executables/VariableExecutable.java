package slogo.model.command.executables;

import java.util.Map;
import slogo.model.environment.EnvironmentApi;

/**
 * Executable class for variables that store constants.
 */
public class VariableExecutable implements Executable{
  private final String signature;

  /**
   * Constructor for Variable Executables.
   * @param sig  Variable Signature
   */
  public VariableExecutable(String sig){
    signature = sig;
  }

  /**
   * Variables return the constant stored under their signature when executed.
   * @return double  The value stored in this variable.
   */
  @Override
  public double execute(EnvironmentApi env) {
    return env.getVarMap().get(signature);
  }

  /**
   * Returns this variable executable's unique signature.
   * @return String  The variable signature
   */
  public String getSignature(){
    return signature;
  }
}
