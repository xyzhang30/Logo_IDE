package slogo.view;

import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import slogo.model.api.ExecutionerApi;

/**
 * UserDefPane class represents a pane displaying user-defined variables and commands.
 */
public class UserDefPane extends CreatePane {

  //private UserVariable userVariable;
  private final VBox displayBox;
  private final ResourceBundle resourceBundle;
  private String language;
  private ExecutionerApi executioner;

  /**
   * Constructs a UserDefPane with the specified height, width, language, and executioner.
   *
   * @param height      the height of the pane.
   * @param width       the width of the pane.
   * @param language    the language used for localization.
   * @param executioner the executioner responsible for managing user-defined variables and
   *                    commands.
   */
  public UserDefPane(int height, int width, String language, ExecutionerApi executioner) {
    super(height, width, language);
    this.executioner = executioner;
    this.language = language;
    if (this.language == null) {
      this.language = "english";
    }
    this.resourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
//    variableItems = executioner.getVariableMap();

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

  /**
   * Updates the display of user-defined variables and commands in the pane.
   */
  public void updateDisplay() {
    // Clear the existing content in displayBox
    displayBox.getChildren().clear();

    // Create ListView instances for user-defined variables and commands
    ListView<String> variablesListView = new ListView<>();
    ListView<String> commandsListView = new ListView<>();

    // Populate ListView instances with user-defined variables
    Map<String, Double> variableMap = executioner.getVariableMap();
    for (Map.Entry<String, Double> entry : variableMap.entrySet()) {
      String variableName = entry.getKey();
      Double value = entry.getValue();
      // Remove ":" from the variable name if it starts with ":"
      if (variableName.startsWith(":")) {
        variableName = variableName.substring(1);
      }
      variablesListView.getItems().add(variableName + " : " + value);
    }

    // Populate ListView instances with user-defined commands
    // Assuming you have a method in executioner to get user-defined commands
    // List<String> userCommands = executioner.getUserCommands();
    // commandsListView.getItems().addAll(userCommands);

    // Create labels for variables and commands
    Label variablesLabel = new Label(resourceBundle.getString("userDefinedVariables") + ":");
    Label commandsLabel = new Label(resourceBundle.getString("userDefinedCommands") + ":");

    // Add labels and ListView instances to displayBox
    displayBox.getChildren().addAll(
        variablesLabel,
        variablesListView,
        commandsLabel,
        commandsListView
    );
  }

}
