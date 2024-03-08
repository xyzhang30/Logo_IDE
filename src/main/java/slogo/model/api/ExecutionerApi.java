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

  void parseTree(InputRecord commandInput);

  void runNext();

  boolean hasNext();
  @Deprecated
  TurtleModelApi getTurtleModel();
  Map<Double, TurtleModelApi> getTurtleModels();
  List<Double> getActiveTurtles();

  CommandHistory getHistory();

  CommandXmlParser getXmlParser();

  void saveFile(String fileName, String filePath);

//  Map<String, Double> getVariableMap();
//  Map<String, Executable> getFunctionMap();
}
