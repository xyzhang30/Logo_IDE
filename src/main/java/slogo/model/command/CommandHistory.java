package slogo.model.command;

import java.io.FileWriter;
import java.io.IOException;
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
    executedCommands = "";
  }

  @Override
  public void setTokens(List<Token> tokens) {
    this.tokens = tokens;
  }

  @Override
  public double executeCurrentCommand() {
    return commands.get(currentIndex).execute();
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

  @Override
  public void saveFile(String fileName, String folderPath) {
    String filePath = folderPath + "/" + fileName; // Constructing the file path

    try (FileWriter writer = new FileWriter(filePath)) {
      writer.write(executedCommands); // Writing the executedCommands string to the file
      System.out.println("File saved successfully: " + filePath);
    } catch (IOException e) {
      System.err.println("Error saving file: " + e.getMessage());
    }
  }

  @Override
  public void setStrings(List<String> inputStrings) {
    this.inputStrings = inputStrings;
  }

  @Override
  public void saveCurrent() {
    executedCommands += inputStrings.get(currentIndex);
    executedCommands += " ";
    currentIndex ++;
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
