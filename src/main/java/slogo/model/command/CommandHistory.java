package slogo.model.command;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class represents the command history functionality.
 */

public class CommandHistory implements HistoryApi {

  private List<String> inputStrings;
  private final int currentIndex;
  private String executedCommands;


  /**
   * Constructs a new {@code CommandHistory} instance.
   */
  public CommandHistory() {
    currentIndex = 0;
    executedCommands = "";
  }

  /**
   * Retrieves the executed commands.
   *
   * @return a string containing the executed commands
   */
  @Override
  public String getCommands() {
    return executedCommands;
  }

  /**
   * Saves the executed commands to a file.
   *
   * @param fileName   the name of the file to save
   * @param folderPath the path of the folder where the file will be saved
   */
  @Override
  public void saveFile(String fileName, String folderPath) {
    String filePath = folderPath + "/" + fileName; // Constructing the file path

    try (FileWriter writer = new FileWriter(filePath)) {
      writer.write(executedCommands);
      System.out.println("File saved successfully: " + filePath);
    } catch (IOException e) {
      System.err.println("Error saving file: " + e.getMessage());
    }
  }

  /**
   * Sets the list of input strings.
   *
   * @param inputStrings the list of input strings to set
   */
  @Override
  public void setStrings(List<String> inputStrings) {
    this.inputStrings = inputStrings;
    System.out.println(this.inputStrings);
    saveCurrent();
  }

  /**
   * Saves the current input strings as executed commands.
   */
  @Override
  public void saveCurrent() {
    executedCommands = String.join("\n", inputStrings);
    System.out.println("exe:" + executedCommands);
    System.out.println("inputStrings: " + inputStrings);
  }
}
