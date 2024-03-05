package slogo.model.environment;

import java.util.HashMap;
import java.util.Map;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class Environment implements EnvironmentApi {
  private final Map<String, Double> variableMap;
  private final Map<String, Executable> functionMap;
  private final Map<Double,TurtleModel> turtleMap;
  private final int width;
  private final int height;
  public Environment(int w,int h){
    variableMap = new HashMap<>();
    functionMap = new HashMap<>();
    turtleMap = new HashMap<>();
    turtleMap.put(1.0,new TurtleModel(1.0));
    turtleMap.get(1.0).setActive(true);
    width = w;
    height = h;
  }
  @Override
  public Map<String,Double> getVarMap(){
    return variableMap;
  }
  @Override
  public Map<String,Executable> getFuncMap(){
    return functionMap;
  }
  @Override
  public TurtleModel getTurtle(){
    return turtleMap.get(1.0);
  }
  @Override
  public int getWidth() {
    return width;
  }
  @Override
  public int getHeight() {
    return height;
  }
}
