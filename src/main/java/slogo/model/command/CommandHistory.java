package slogo.model.command;

import java.util.List;
import javafx.scene.web.HTMLEditorSkin.Command;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.token.Token;

/**
 * A list of commandLines. Manages the history of entered commands.
 */
public class CommandHistory implements HistoryApi {

  private List<String> inputStrings;
  private List<Executable> commands;
  private List<Token> tokens;
  private int currentIndex;

  private String executedCommands;


//  public CommandHistory() {
//    clearHistory();
//  }

  public CommandHistory(){
    currentIndex = 0;
  }

  @Override
  public void setTokens(List<Token> tokens) {
    this.tokens = tokens;
  }

  @Override
  public double executeCurrentCommand() {
    return 0; //disabled, corrections forthcoming
  }

  @Override
  public void incrementCommandIndex() {
    if (currentIndex > commands.size()) {
      throw new IndexOutOfBoundsException(String.format(
          "Attempted to increment past end of history. History has %s items.", commands.size()));
    }
    currentIndex++;
  }

  public void addCommand(Executable com) {
    commands.add(com);
  }

//  public List<Executable> getCommands() {
//    return commands;
//  }

  public void saveFile(String filename){

  }

  @Override
  public void setStrings(List<String> inputStrings) {
    this.inputStrings = inputStrings;
  }

  @Override
  public void saveCurrent() {
    executedCommands += inputStrings.get(currentIndex);
  }

//  public void jumpToCommand(int index) {
//    if (index > commands.size() || index < 0) {
//      throw new IndexOutOfBoundsException("Attempted to jump to an invalid index in history");
//    }
//    currentIndex = index;
//  }
//
//  public Executable getCurrentCommand() {
//    return commands.get(currentIndex);
//  }
//
//  public int getCurrentIndex() {
//    return currentIndex;
//  }
//
//  private void clearHistory() {
//    commands = new ArrayList<>();
//    currentIndex = 0;
//  }

}
