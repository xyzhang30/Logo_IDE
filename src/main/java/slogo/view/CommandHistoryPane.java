package slogo.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.util.ResourceBundle;

public class CommandHistoryPane extends CreatePane {

  private ScrollPane scrollPane;
  private ListView<String> listView;
  private ObservableList<String> commands;
  private ResourceBundle resourceBundle;

  public CommandHistoryPane(int height, int width, String language) {
    super(height, width, language);
    resourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);

    commands = FXCollections.observableArrayList();
    listView = new ListView<>(commands);

    scrollPane = new ScrollPane();
    scrollPane.setContent(listView);
    scrollPane.setFitToWidth(true); // Adjusts width to fit content
    scrollPane.setFitToHeight(true); // Adjusts height to fit content

    Label titleLabel = new Label(resourceBundle.getString("commandHistory"));

    VBox root = new VBox();
    root.getChildren().addAll(titleLabel, scrollPane);

    getRoot().getChildren().add(root);
  }

  public void addCommand(String command) {
    commands.add(command);
  }

  public void clearHistory() {
    commands.clear();
  }

  @Override
  public void create() {
    // Override if necessary
  }
}
