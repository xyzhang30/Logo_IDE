package slogo.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import slogo.model.xmlparser.CommandXmlParser;

import java.io.File;
import java.io.FileNotFoundException;

public class HelpWindow extends Stage {

  public HelpWindow() {
    BorderPane root = new BorderPane(); // Create a layout for the new scene

    // Create content for the new scene
    VBox helpPane = new VBox(); // Vertical box to contain help documentation and exit button

    // Help Documentation
    Label titleLabel = new Label("SLogo Command List");

    // Load command overview documentation
    loadCommandOverview(helpPane);

    // Exit Button
    Button exitButton = new Button("Exit");
    exitButton.setOnAction(event -> close()); // Close the stage when the button is clicked
    helpPane.getChildren().add(exitButton); // Add the exit button to the help pane

    root.setCenter(helpPane);

    Scene scene = new Scene(root, 600, 800); // Create a scene with the layout and desired dimensions
    setScene(scene); // Set the scene to the stage
  }

  private void loadCommandOverview(VBox helpPane) {
    // Load command names and parameters from XML files
    // For each command, create a Hyperlink to display the command name
    // and make it clickable to load detailed documentation

    VBox commandOverview = new VBox(); // Vertical box to contain command overview

    // Iterate through the XML files and create Hyperlinks for each command
    File xmlFolder = new File("data/commandsXML/");
    for (File xmlFile : xmlFolder.listFiles()) {
      String commandName = xmlFile.getName().replace(".xml", "");
      Hyperlink commandLink = new Hyperlink(commandName);

      // Add action to load detailed documentation when the hyperlink is clicked
      commandLink.setOnAction(event -> loadCommandDocumentation(helpPane, commandName));

      commandOverview.getChildren().add(commandLink);
    }

    // Add command overview to the help pane
    helpPane.getChildren().addAll(commandOverview, new Label("")); // Add some spacing
  }

  private void loadCommandDocumentation(VBox helpPane, String commandName) {
    // Load detailed documentation for the specified command
    CommandXmlParser xmlParser = new CommandXmlParser();
    try {
      xmlParser.readXml(commandName);
      Label commandDescriptionLabel = new Label(xmlParser.getCommandDescription());
      helpPane.getChildren().add(commandDescriptionLabel);
    } catch (FileNotFoundException e) {
      // Handle file not found exception
    }
  }
}
