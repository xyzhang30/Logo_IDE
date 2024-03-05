package slogo.view;

import java.util.HashMap;
import java.util.Map;
import slogo.model.api.InputRecord;
import slogo.model.api.InvalidCommandException;
import slogo.model.api.InvalidParameterNumberException;
import slogo.model.parser.TreeParser;

public class UserVariable {
  private TreeParser treeParser; // Assuming you have an instance of TreeParser

  // Map to store user-defined variables
  private Map<String, Double> userVariables;

  // Map to store user-defined commands
  private Map<String, String> userCommands;

  public UserVariable() {
    userVariables = new HashMap<>();
    userCommands = new HashMap<>();
    treeParser = new TreeParser(); // Instantiate TreeParser
  }

  // Method to add a user-defined variable
  public void addUserVariable(String variableName, double value) {
    userVariables.put(variableName, value);
  }

  // Method to add a user-defined command
  public void addUserCommand(String commandName, String commandDefinition) {
    userCommands.put(commandName, commandDefinition);
  }

  // Method to parse and execute user input
  public void parseAndExecute(String input) {
    // Pass the input to TreeParser for parsing and execution
    try {
//      treeParser.parseTree(new InputRecord(input));
    } catch (InvalidParameterNumberException | InvalidCommandException e) {
      // Handle exceptions if needed
      e.printStackTrace();
    }
  }

  // Method to get user-defined variables
  public Map<String, Double> getUserVariables() {
    return userVariables;
  }

  // Method to get user-defined commands
  public Map<String, String> getUserCommands() {
    return userCommands;
  }
}
