package slogo.model.environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public class Environment implements EnvironmentApi {

  private final Map<String, Double> variableMap;
  private final Map<String, Executable> functionMap;
  private final Map<Double, TurtleModel> turtleMap;
  private final int width;
  private final int height;

  public Environment(int w, int h) {
    variableMap = new HashMap<>();
    functionMap = new HashMap<>();
    turtleMap = new HashMap<>();
    turtleMap.put(1.0, new TurtleModel(1.0));
    turtleMap.get(1.0).setActive(true);
    width = w;
    height = h;
  }

  /**
   * The map of user defined variables. Keys are variable signature strings, values are doubles.
   *
   * @return Map  user defined variables.
   */
  @Override
  public Map<String, Double> getVarMap() {
    return null;
  }

  /**
   * The map of user defined functions. Keys are function signature strings, values are Command
   * Executables.
   *
   * @return Map  user defined functions.
   */
  @Override
  public Map<String, Executable> getFuncMap() {
    return null;
  }

  /**
   * The map of Turtles. Keys are Turtle IDs, which are doubles. Values are TurtleModel objects.
   *
   * @return Map  map of all Turtle Models
   */
  @Override
  public Map<Double, TurtleModel> getTurtleMap() {
    return null;
  }

  /**
   * Generates and returns the IDs of all currently active Turtles.
   *
   * @return List  A list of doubles representing IDs of active turtles.
   */
  @Override
  public List<Double> getActiveTurtleKeys() {
    List<Double> activeKeys = new ArrayList<>();
    for (double id : turtleMap.keySet()){
      if (turtleMap.get(id).isActive()){
        activeKeys.add(id);
      }
    }
    return activeKeys;
  }

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }
}
