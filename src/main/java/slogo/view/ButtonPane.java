package slogo.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import slogo.model.command.CommandHistory;
import slogo.model.command.executables.Executable;

import java.util.List;

public class ButtonPane extends HBox {
  private Button commandHistoryButton;
  private Button helpButton;
  private CommandHistory commandHistory;

  public ButtonPane(CommandHistory commandHistory) {
    this.commandHistory = commandHistory;
    initializeComponents();
    layoutComponents();
  }

  private void initializeComponents() {
    commandHistoryButton = new Button("Command History");
    commandHistoryButton.setOnAction(event -> {
      List<Executable> commandHistoryList = getCommandHistory();
      // Process the command history list as needed
    });

    helpButton = new Button("Help");
    // Add logic for help button if needed
  }

  private void layoutComponents() {
    getChildren().addAll(commandHistoryButton, helpButton);
    setSpacing(10);
  }

  private List<Executable> getCommandHistory() {
    return commandHistory.getCommands();
  }

  public Button getCommandHistoryButton() {
    return commandHistoryButton;
  }

  public Button getHelpButton() {
    return helpButton;
  }
}
