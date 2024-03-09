package slogo.view;

import static slogo.view.IdeWindow.DEFAULT_RESOURCE_PACKAGE;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import slogo.xmlparser.CommandXmlParser;

/**
 * HelpWindow class represents a window displaying information about SLogo commands and their
 * usage.
 */
public class HelpWindow extends Stage {

  private final TextArea commandTextArea;
  private final String language;

  /**
   * Constructs a HelpWindow with the specified language.
   *
   * @param language the language used for the command documentation.
   */
  public HelpWindow(String language) {
    super();
    this.language = language;
    BorderPane root = new BorderPane();

    VBox helpPane = new VBox();
    helpPane.setAlignment(Pos.CENTER);
    helpPane.setSpacing(10);

    Label titleLabel = new Label("SLogo Command List");
    titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));

    loadCommandOverview(helpPane, language);

    Button exitButton = new Button("Exit");
    exitButton.setOnAction(event -> close());

    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(helpPane);
    scrollPane.setFitToWidth(true);

    root.setTop(titleLabel);
    BorderPane.setAlignment(titleLabel, Pos.CENTER);
    root.setCenter(scrollPane);
    root.setBottom(exitButton);
    BorderPane.setAlignment(exitButton, Pos.CENTER);

    Scene scene = new Scene(root, 400, 500);
    setScene(scene);

    // Initialize commandTextArea
    commandTextArea = new TextArea();
  }

  private void loadCommandOverview(VBox helpPane, String language) {
    File xmlFolder = new File("data/commandsXML/");
    ResourceBundle resourceBundle;
    if (language.equals("english")) {
      resourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "english");
    } else if (language.equals("spanish")) {
      resourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "spanish");
    } else if (language.equals("french")) {
      resourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "french");
    } else {

      return;
    }

    for (File xmlFile : xmlFolder.listFiles()) {
      String commandName = xmlFile.getName().replace(".xml", "");
      String localizedCommandName = resourceBundle.getString(commandName);
      Hyperlink commandLink = new Hyperlink(localizedCommandName);
      commandLink.setOnAction(event -> loadCommandDocumentation(helpPane, commandName,
          Controller.getInstance())); // Pass the controller instance
      helpPane.getChildren().addAll(commandLink);
    }
  }


  private void loadCommandDocumentation(VBox helpPane, String commandName, Controller controller) {
    CommandXmlParser xmlParser = new CommandXmlParser();
    try {
      xmlParser.readXml(commandName);
      String canonicalName = xmlParser.getCommandName();
      String description = xmlParser.getCommandDescription();
      int numParams = xmlParser.getNumParamsExpected();
      Map<String, String> parameters = xmlParser.getParameters();
      String example = xmlParser.getExample();

      VBox commandDetails = new VBox();
      commandDetails.setPadding(new Insets(5, 0, 5, 0));
      commandDetails.setAlignment(Pos.CENTER_LEFT);
      commandDetails.setSpacing(5);

      Button titleButton = new Button(canonicalName);
      titleButton.setOnAction(event -> {
        commandTextArea.setText(canonicalName); // Update the TextArea value
        helpPane.getChildren().add(commandTextArea); // Add TextArea to current VBox
      });

      Label descriptionLabel = new Label("Description: " + description);
      Label numParamsLabel = new Label("Number of Parameters: " + numParams);
      Label exampleLabel = new Label("Example: " + example);

      commandDetails.getChildren()
          .addAll(titleButton, descriptionLabel, numParamsLabel, exampleLabel);

      for (Map.Entry<String, String> entry : parameters.entrySet()) {
        Label paramLabel = new Label("Parameter: " + entry.getKey() + " - " + entry.getValue());
        commandDetails.getChildren().add(paramLabel);
      }

      Button backButton = new Button("Go Back");
      backButton.setOnAction(event -> {
        helpPane.getChildren().clear();
        loadCommandOverview(helpPane, language);
      });

      commandDetails.getChildren().add(backButton);

      Button runButton = new Button("Run"); // Add Run button
      runButton.setOnAction(event -> {
        System.out.println("button pressed");
        System.out.println("hi" + commandTextArea.getText());
        controller.runHelp(
            commandTextArea.getText()); // Execute run method if controller is not null
        System.out.println("run button working");
      });
      commandDetails.getChildren().add(runButton);

      helpPane.getChildren().clear();
      helpPane.getChildren().addAll(commandDetails);
    } catch (FileNotFoundException e) {
      // Handle file not found exception
    }
  }
}
