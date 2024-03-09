package slogo.model.api;

import java.util.List;
import java.util.Map;
import slogo.model.command.CommandHistory;
import slogo.xmlparser.CommandXmlParser;

/**
 * External API for the Executioner. Manages the execution of commands.
 */
public interface ExecutionerApi {

  /**
   * Resets the program, jumping back to the first instruction in the tree.
   */
  void reset();

  /**
   * Performs one instruction from the tree.
   */
  void step();

  /**
   * Calls parser to parse the command tree from the provided input record.
   *
   * @param commandInput the input record containing the command tree
   */
  void parseTree(InputRecord commandInput);

  /**
   * Runs the next instruction in the tree.
   */
  void runNext();

  /**
   * Checks if there are more instructions in the tree to be executed.
   * @return true if there are more instructions, false otherwise
   */
  boolean hasNext();

  /**
   * Retrieves the turtle model associated with the specified ID.
   *
   * @return the turtle model
   * @deprecated This method is deprecated and will be removed in future versions
   */
  @Deprecated
  TurtleModelApi getTurtleModel();

  /**
   * Retrieves a map of all turtle models associated with their IDs.
   *
   * @return a map of turtle models
   */
  Map<Double, TurtleModelApi> getTurtleModels();

  /**
   * Retrieves the IDs of all active turtles.
   *
   * @return a list of active turtle IDs
   */
  List<Double> getActiveTurtles();

  /**
   * Retrieves the command history.
   *
   * @return the command history
   */
  CommandHistory getHistory();

  /**
   * Retrieves the XML parser used for parsing commands.
   *
   * @return the XML parser
   */
  CommandXmlParser getXmlParser();


  /**
   * Saves the current state to a file.
   *
   * @param fileName the name of the file
   * @param filePath the path where the file should be saved
   */
  void saveFile(String fileName, String filePath);

  /**
   * Retrieves the map of variables.
   *
   * @return a map of variables
   */
  Map<String, Double> getVariableMap();
//  Map<String, Executable> getFunctionMap();
}
