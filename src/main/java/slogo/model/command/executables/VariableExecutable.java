package slogo.model.command.executables;

import java.util.Map;

/**
 * Executable class for variables that store constants.
 */
public class VariableExecutable implements Executable{
  private final String signature;
  private Map<String,Double> myMap;

  /**
   * Constructor for Variable Executables.
   * @param sig  Variable Signature
   * @param map  Mapping of all Variable names to corresponding values
   */
  public VariableExecutable(String sig, Map<String,Double> map){
    signature = sig;
    myMap = map;
  }

  /**
   * Variables return the constant stored under their signature when executed.
   * @return double  The value stored in this variable.
   */
  @Override
  public double execute() {
    return myMap.get(signature);
  }

  /**
   * Instantiates this variable. Assigns a value to be stored by this variable.
   * @param value  The constant value to be assigned to this variable.
   */
  public void assign(double value){
    myMap.put(signature,value);
  }
}
