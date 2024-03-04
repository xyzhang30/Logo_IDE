package slogo.model.environment;

import java.util.HashMap;
import java.util.Map;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class Environment {
  private final Map<String, Double> variableMap;
  private final Map<String, Executable> functionMap;
  private final TurtleModelApi turtle;
  private final int width;
  private final int height;
  public Environment(int w,int h){
    variableMap = new HashMap<>();
    functionMap = new HashMap<>();
    turtle = new TurtleModel();
    width = w;
    height = h;
  }
  public Map<String,Double> getVarMap(){
    return variableMap;
  }
  public Map<String,Executable> getFuncMap(){
    return functionMap;
  }
  public TurtleModelApi getTurtle(){
    return turtle;
  }
  public int[] getScreen(){
    return new int[]{width, height};
  }
}
