package slogo.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.util.Map;
import java.util.ResourceBundle;

public class UserDefPane extends CreatePane {

  private UserVariable userVariable;
  private VBox displayBox;
  private ResourceBundle resourceBundle;
  private String language;

  public UserDefPane(int height, int width, String language) {
    super(height, width, language);
    this.language = language;
    this.resourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
    this.userVariable = userVariable;

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
    displayBox.getChildren().clear();


    ListView<String> variablesListView = new ListView<>();
    ListView<String> commandsListView = new ListView<>();

    ObservableList<String> variablesItems = FXCollections.observableArrayList();
    ObservableList<String> commandsItems = FXCollections.observableArrayList();


    // Map<String, Double> userVariables = userVariable.getUserVariables();
    // Map<String, String> userCommands = userVariable.getUserCommands();

    // Add user-defined variables to the list
    String userDefinedVariablesTitle = resourceBundle.getString("userDefinedVariables");
    // Uncomment the following section when have access to userVariable
        /*
        variablesItems.add(userDefinedVariablesTitle + ":");
        for (String variableName : userVariables.keySet()) {
            variablesItems.add(variableName + ": " + userVariables.get(variableName));
        }
        */

    // Add user-defined commands to the list
    String userDefinedCommandsTitle = resourceBundle.getString("userDefinedCommands");
    // Uncomment the following section when have access to userVariable
        /*
        commandsItems.add(userDefinedCommandsTitle + ":");
        for (String commandName : userCommands.keySet()) {
            commandsItems.add(commandName + ": " + userCommands.get(commandName));
        }
        */

    variablesListView.setItems(variablesItems);
    commandsListView.setItems(commandsItems);

    Label variablesLabel = new Label(userDefinedVariablesTitle + ":");
    Label commandsLabel = new Label(userDefinedCommandsTitle + ":");


    displayBox.getChildren().addAll(variablesLabel, variablesListView, commandsLabel, commandsListView);
  }
}
