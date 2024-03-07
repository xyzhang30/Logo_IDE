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
  private final List<Double> activeTurtleKeys;
  private final int width;
  private final int height;

  /**
   * Constructor for Environment.
   * @param w
   * @param h
   */
  public Environment(int w, int h) {
    variableMap = new HashMap<>();
    functionMap = new HashMap<>();
    turtleMap = new HashMap<>();
    activeTurtleKeys = new ArrayList<>();
    defaultTurtle();
    width = w;
    height = h;
  }
  private void defaultTurtle(){
    turtleMap.put(1.0, new TurtleModel(1.0));
    activeTurtleKeys.add(1.0);
  }

  /**
   * The map of user defined variables. Keys are variable signature strings, values are doubles.
   *
   * @return Map  user defined variables.
   */
  @Override
  public Map<String, Double> getVarMap() {
    return variableMap;
  }

  /**
   * The map of user defined functions. Keys are function signature strings, values are Command
   * Executables.
   *
   * @return Map  user defined functions.
   */
  @Override
  public Map<String, Executable> getFuncMap() {
    return functionMap;
  }

  /**
   * The map of Turtles. Keys are Turtle IDs, which are doubles. Values are TurtleModel objects.
   *
   * @return Map  map of all Turtle Models
   */
  @Override
  public Map<Double, TurtleModel> getTurtleMap() {
    return turtleMap;
  }

  /**
   * Generates and returns the IDs of all currently active Turtles.
   *
   * @return List  A list of doubles representing IDs of active turtles.
   */
  @Override
  public List<Double> getActiveTurtleKeys() {
    return activeTurtleKeys;
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
