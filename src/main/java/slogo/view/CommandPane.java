package slogo.view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import java.util.Map;
import java.util.ResourceBundle;

public class CommandPane extends CreatePane {
  private UserVariable userVariable;
  public static final String DEFAULT_RESOURCE_PACKAGE = "View.";
  public static final String DEFAULT_RESOURCE_FOLDER = "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");

  private VBox displayBox;
  private ResourceBundle resourceBundle;
  private String language;

  public CommandPane(int height, int width, String language) {
    super(height, width, language);
    this.language = language;
    this.resourceBundle = resourceBundle;
    this.userVariable = userVariable;
    displayBox = new VBox();
    getRoot().setPrefHeight(height);
    getRoot().setPrefWidth(width);

    updateDisplay();

    // Add the displayBox to this CommandPane's root
    getRoot().getChildren().add(displayBox);
  }



  @Override
  public void create() {
    // No additional initialization needed for this pane
  }

  public void updateDisplay() {
    displayBox.getChildren().clear();

    TextArea variablesTextArea = new TextArea();
    TextArea commandsTextArea = new TextArea();

    // Enable text wrapping
    variablesTextArea.setWrapText(true);
    commandsTextArea.setWrapText(true);

    // Get user-defined variables and commands from UserVariable
    //Map<String, Double> userVariables = userVariable.getUserVariables();
    //Map<String, String> userCommands = userVariable.getUserCommands();

    // Fetch specific titles directly from the resource bundle

    String userDefinedVariablesTitle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language).getString("userDefinedVariables");
    String userDefinedCommandsTitle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language).getString("userDefinedCommands");


    // Display user-defined variables
    variablesTextArea.appendText(userDefinedVariablesTitle + ":\n");
    // Uncomment the following section when you have access to userVariable
        /*
        Map<String, Double> userVariables = userVariable.getUserVariables();
        for (String variableName : userVariables.keySet()) {
            variablesTextArea.appendText(variableName + ": " + userVariables.get(variableName) + "\n");
        }
        */

    // Display user-defined commands
    commandsTextArea.appendText(userDefinedCommandsTitle + ":\n");
    // Display user-defined variables
//    variablesTextArea.appendText(userDefinedVariablesTitle + ":\n");
//    for (String variableName : userVariables.keySet()) {
//      variablesTextArea.appendText(variableName + ": " + userVariables.get(variableName) + "\n");
//    }
//
//    // Display user-defined commands
//    commandsTextArea.appendText(userDefinedCommandsTitle + ":\n");
//    for (String commandName : userCommands.keySet()) {
//      commandsTextArea.appendText(commandName + ": " + userCommands.get(commandName) + "\n");
//    }



    // Disable editing for text areas
    variablesTextArea.setEditable(false);
    commandsTextArea.setEditable(false);

    // Add text areas to the displayBox
    displayBox.getChildren().addAll(variablesTextArea, commandsTextArea);
  }
}
