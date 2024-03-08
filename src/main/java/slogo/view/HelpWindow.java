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
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import slogo.xmlparser.CommandXmlParser;

public class HelpWindow extends Stage {

  private TextArea commandTextArea;

  public HelpWindow(String language) {
    BorderPane root = new BorderPane();

    VBox helpPane = new VBox();
    helpPane.setAlignment(Pos.CENTER);
    helpPane.setSpacing(10);

    Label titleLabel = new Label("SLogo Command List");
    titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));

    loadCommandOverview(helpPane);

    Button exitButton = new Button("Exit");
    exitButton.setOnAction(event -> close());

    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(helpPane);
    scrollPane.setFitToWidth(true);

    root.setTop(titleLabel);
    root.setAlignment(titleLabel, Pos.CENTER);
    root.setCenter(scrollPane);
    root.setBottom(exitButton);
    BorderPane.setAlignment(exitButton, Pos.CENTER);

    Scene scene = new Scene(root, 400, 500);
    setScene(scene);

    // Initialize commandTextArea
    commandTextArea = new TextArea();
  }

  private void loadCommandOverview(VBox helpPane) {
    File xmlFolder = new File("data/commandsXML/");
    for (File xmlFile : xmlFolder.listFiles()) {
      String commandName = xmlFile.getName().replace(".xml", "");
      Hyperlink commandLink = new Hyperlink(commandName);
      commandLink.setOnAction(event -> loadCommandDocumentation(helpPane, commandName, Controller.getInstance())); // Pass the controller instance
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
      List<String> paramOrder = xmlParser.getParamOrder();
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

      commandDetails.getChildren().addAll(titleButton, descriptionLabel, numParamsLabel, exampleLabel);

      for (Map.Entry<String, String> entry : parameters.entrySet()) {
        Label paramLabel = new Label("Parameter: " + entry.getKey() + " - " + entry.getValue());
        commandDetails.getChildren().add(paramLabel);
      }

      Button backButton = new Button("Go Back");
      backButton.setOnAction(event -> {
        helpPane.getChildren().clear();
        loadCommandOverview(helpPane);
      });

      commandDetails.getChildren().add(backButton);

      Button runButton = new Button("Run"); // Add Run button
      runButton.setOnAction(event -> {
        System.out.println("button pressed");
        System.out.println("hi" + commandTextArea.getText());
        controller.runHelp(commandTextArea.getText()); // Execute run method if controller is not null
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
