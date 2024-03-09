package slogo.view;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class UserDefPane extends CreatePane {

  private UserVariable userVariable;
  private final VBox displayBox;
  private final ResourceBundle resourceBundle;
  private String language;
  private final Map<String, Double> variableItems;


  public UserDefPane(int height, int width, String language) {
    super(height, width, language);
    this.language = language;
    if (this.language == null) {
      this.language = "english";
    }
    this.resourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
//    this.userVariable ;
    variableItems = new HashMap<>();

    // Create a VBox to hold the content
    displayBox = new VBox();

    // Update the display
    updateDisplay();

    // Create a ScrollPane to make the content scrollable
    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(displayBox);
    scrollPane.setFitToWidth(true);
    scrollPane.setFitToHeight(true);

    // Add the ScrollPane to this UserDefPane's root
    getRoot().getChildren().add(scrollPane);
  }

  @Override
  public void create() {

  }

  public void updateDisplay() {
    // Clear the existing content in displayBox
    displayBox.getChildren().clear();

    // Create ListView instances if needed
    ListView<String> variablesListView = new ListView<>();
    ListView<String> commandsListView = new ListView<>();

    // Clear existing items in ListView instances
    variablesListView.getItems().clear();
    commandsListView.getItems().clear();

    // Populate ListView instances with variable items
    for (String variable : variableItems.keySet()) {
      variablesListView.getItems().add(variable);
    }

//    for (/* iterate over command items */) {
//      // Add command items to commandsListView
//    }

    // Create labels for variables and commands
    Label variablesLabel = new Label(resourceBundle.getString("userDefinedVariables") + ":");
    Label commandsLabel = new Label(resourceBundle.getString("userDefinedCommands") + ":");

    // Add labels and ListView instances to displayBox
    displayBox.getChildren()
        .addAll(variablesLabel, variablesListView, commandsLabel, commandsListView);
  }

}
