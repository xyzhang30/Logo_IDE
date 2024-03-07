package slogo.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import slogo.model.xmlparser.CommandXmlParser;

public class HelpWindow extends Stage {

  public HelpWindow() {
    BorderPane root = new BorderPane(); // Create a layout for the new scene

    // Create content for the new scene
    VBox helpPane = new VBox(); // Vertical box to contain help documentation and exit button
    helpPane.setAlignment(Pos.CENTER);
    helpPane.setSpacing(10);

    // Help Documentation
    Label titleLabel = new Label("SLogo Command List");
    titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));

    // Load command overview documentation
    loadCommandOverview(helpPane);

    // Exit Button
    Button exitButton = new Button("Exit");
    exitButton.setOnAction(event -> close()); // Close the stage when the button is clicked

    // Create a ScrollPane and set its content to the helpPane
    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(helpPane);
    scrollPane.setFitToWidth(true); // Allow horizontal scrolling if needed

    root.setTop(titleLabel);
    root.setAlignment(titleLabel, Pos.CENTER);
    root.setCenter(scrollPane);
    root.setBottom(exitButton);
    BorderPane.setAlignment(exitButton, Pos.CENTER);

    Scene scene = new Scene(root, 400, 500); // Create a scene with the layout and desired dimensions
    setScene(scene); // Set the scene to the stage
  }

  // Method to load command overview documentation
  private void loadCommandOverview(VBox helpPane) {
    // Load command names and parameters from XML files
    File xmlFolder = new File("data/commandsXML/");
    for (File xmlFile : xmlFolder.listFiles()) {
      String commandName = xmlFile.getName().replace(".xml", "");
      Hyperlink commandLink = new Hyperlink(commandName);

      // Add action to load detailed documentation when the hyperlink is clicked
      commandLink.setOnAction(event -> loadCommandDocumentation(helpPane, commandName));

      // Add the hyperlink to the help pane
      helpPane.getChildren().addAll(commandLink);
    }
  }

  // Method to load detailed documentation for a command
  private void loadCommandDocumentation(VBox helpPane, String commandName) {
    // Load detailed documentation for the specified command
    CommandXmlParser xmlParser = new CommandXmlParser();
    try {
      xmlParser.readXml(commandName);

      // Extract command information
      String canonicalName = xmlParser.getCommandName();
      String description = xmlParser.getCommandDescription();
      int numParams = xmlParser.getNumParamsExpected();
      Map<String, String> parameters = xmlParser.getParameters();
      List<String> paramOrder = xmlParser.getParamOrder();
      String example = xmlParser.getExample();

      // Create a VBox to hold command details
      VBox commandDetails = new VBox();
      commandDetails.setPadding(new Insets(5, 0, 5, 0));
      commandDetails.setAlignment(Pos.CENTER_LEFT);
      commandDetails.setSpacing(5);

      // Add command details to the VBox
      Label nameLabel = new Label("Name: " + canonicalName);
      nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
      Label descriptionLabel = new Label("Description: " + description);
      Label numParamsLabel = new Label("Number of Parameters: " + numParams);
      Label exampleLabel = new Label("Example: " + example);

      commandDetails.getChildren().addAll(nameLabel, descriptionLabel, numParamsLabel, exampleLabel);

      // Add parameters to the VBox
      for (Map.Entry<String, String> entry : parameters.entrySet()) {
        Label paramLabel = new Label("Parameter: " + entry.getKey() + " - " + entry.getValue());
        commandDetails.getChildren().add(paramLabel);
      }

      // Create a "Back" button to return to the main help screen
      Button backButton = new Button("Back");
      backButton.setOnAction(event -> {
        helpPane.getChildren().clear();
        loadCommandOverview(helpPane);
      });

      commandDetails.getChildren().add(backButton);

      // Clear existing documentation and add the new documentation
      helpPane.getChildren().clear();
      helpPane.getChildren().addAll(commandDetails);
    } catch (FileNotFoundException e) {
      // Handle file not found exception
    }
  }
}
