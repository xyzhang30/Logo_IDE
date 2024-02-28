package slogo.model.command.executables;

import java.util.Map;

public class VariableExecutable implements Executable{
  private final String signature;
  private Map<String,Double> myMap;
  public VariableExecutable(String sig, Map<String,Double> map){
    signature = sig;
    myMap = map;
  }
  @Override
  public double execute() {
    return myMap.get(signature);
  }
  public void assign(double value){
    myMap.put(signature,value);
  }
}
