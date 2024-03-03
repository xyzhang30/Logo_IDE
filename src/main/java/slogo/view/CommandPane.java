package slogo.view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import java.util.Map;

public class CommandPane extends CreatePane {
  private UserVariable userVariable;
  private VBox displayBox;

  public CommandPane(int height, int width, String language) {
    super(height, width, language);
    userVariable = new UserVariable();
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

    // Get user-defined variables and commands from UserVariable
    Map<String, Double> userVariables = userVariable.getUserVariables();
    Map<String, String> userCommands = userVariable.getUserCommands();

    // Display user-defined variables
    variablesTextArea.appendText("User-defined Variables:\n");
    for (String variableName : userVariables.keySet()) {
      variablesTextArea.appendText(variableName + ": " + userVariables.get(variableName) + "\n");
    }

    // Display user-defined commands
    commandsTextArea.appendText("User-defined Commands:\n");
    for (String commandName : userCommands.keySet()) {
      commandsTextArea.appendText(commandName + ": " + userCommands.get(commandName) + "\n");
    }

    // Disable editing for text areas
    variablesTextArea.setEditable(false);
    commandsTextArea.setEditable(false);

    // Add text areas to the displayBox
    displayBox.getChildren().addAll(variablesTextArea, commandsTextArea);
  }
}
