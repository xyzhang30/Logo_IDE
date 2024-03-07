package slogo.model.environment;

import java.util.List;
import java.util.Map;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

/**
 * An Interface for engaging with the environment variables
 */
public interface EnvironmentApi {

  /**
   * The map of user defined variables. Keys are variable signature strings, values are doubles.
   * @return Map  user defined variables.
   */
  Map<String, Double> getVarMap();

  /**
   * The map of user defined functions. Keys are function signature strings, values are Command
   * Executables.
   * @return Map  user defined functions.
   */
  Map<String, Executable> getFuncMap();

  /**
   * The map of Turtles. Keys are Turtle IDs, which are doubles. Values are TurtleModel objects.
   * @return Map  map of all Turtle Models
   */
  Map<Double, TurtleModel> getTurtleMap();
  /**
   * The list of all current active Turtles' IDs.
   * @return List  A list of doubles representing IDs of active turtles.
   */
  List<Double> getActiveTurtleKeys();
  int getWidth();

  int getHeight();
}
