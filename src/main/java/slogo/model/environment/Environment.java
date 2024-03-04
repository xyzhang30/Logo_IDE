package slogo.model.environment;

import java.util.HashMap;
import java.util.Map;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class Environment implements EnvironmentApi {
  private final Map<String, Double> variableMap;
  private final Map<String, Executable> functionMap;
  private final TurtleModel turtle;
  private final int width;
  private final int height;
  public Environment(int w,int h){
    variableMap = new HashMap<>();
    functionMap = new HashMap<>();
    turtle = new TurtleModel();
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
    return turtle;
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
