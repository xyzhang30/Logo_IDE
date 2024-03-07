package slogo.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import java.util.ResourceBundle;
import javafx.scene.text.Text;

public class CommandHistoryPane extends CreatePane {

  private ScrollPane scrollPane;
  private ObservableList<String> commands;
  private ResourceBundle resourceBundle;
  private TextArea commandText;

  public CommandHistoryPane(int height, int width, String language) {
    super(height, width, language);
    resourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);

    commands = FXCollections.observableArrayList();
    commandText = new TextArea();
    commandText.setEditable(false);

    scrollPane = new ScrollPane();
    scrollPane.setContent(commandText);
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
    System.out.println("commandLines");

    for (String s : commandLines){
      commandText.appendText(s);
      commandText.appendText("\n");
      System.out.println(s);
    }
//    commandText.setText(command);
//    System.out.println(command);
  }

  public void clearHistory() {
    commandText.clear();
  }

  @Override
  public void create() {
    // Override if necessary
  }
}
