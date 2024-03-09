package slogo.view;

import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CommandHistoryPane extends CreatePane {

  private final ScrollPane scrollPane;
  private final TextFlow commandTextFlow;
  private final ResourceBundle resourceBundle;

  public CommandHistoryPane(int height, int width, String language) {
    super(height, width, language);
    resourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);

    commandTextFlow = new TextFlow();

    scrollPane = new ScrollPane();
    scrollPane.setContent(commandTextFlow);
    scrollPane.setFitToWidth(true); // Adjusts width to fit content
    scrollPane.setFitToHeight(true); // Adjusts height to fit content

    Label titleLabel = new Label(resourceBundle.getString("commandHistory"));

    VBox root = new VBox();
    root.getChildren().addAll(titleLabel, scrollPane);

    getRoot().getChildren().add(root);
  }

  public void addCommand(String command) {
    clearHistory();
    String[] commandLines = command.split("\n");

    for (String s : commandLines) {
      Hyperlink link = new Hyperlink(s);
      link.setOnAction(event -> {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Execute Command");

        TextArea commandTextArea = new TextArea(s);
        commandTextArea.setEditable(true);

        Button runButton = new Button("Run");
        runButton.setOnAction(runEvent -> {
          // Handle the run button click action here
          // For example, you can execute the clicked command
          Controller.getInstance().runCmdHist(
              commandTextArea.getText()); // Execute run method if controller is not null
          popupStage.close();
        });

        VBox popupLayout = new VBox(10);
        popupLayout.getChildren().addAll(commandTextArea, runButton);
        popupLayout.setPrefWidth(300);

        Scene popupScene = new Scene(popupLayout);
        popupStage.setScene(popupScene);
        popupStage.show();
      });
      Text text = new Text("\n");
      commandTextFlow.getChildren().addAll(link, text);

//    List<String> commandLines = new ArrayList<>();
//    commandLines = List.of(command.split("\n"));
//    System.out.println("commands" + commandLines);
//    for (String s : commandLines){
//      commandText.appendText(s);
//      commandText.appendText("\n");
    }
  }

  public void clearHistory() {
    commandTextFlow.getChildren().clear();
  }

  @Override
  public void create() {
    // Override if necessary
  }
}

