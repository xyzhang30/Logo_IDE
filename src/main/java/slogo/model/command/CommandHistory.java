package slogo.model.command;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CommandHistory implements HistoryApi {

  private List<String> inputStrings;
  private int currentIndex;
  private StringBuilder executedCommands;

  public CommandHistory(){
    currentIndex = 0;
    executedCommands = new StringBuilder();
  }

  @Override
  public String getCommands() {
    return executedCommands.toString();
  }

  @Override
  public void saveFile(String fileName, String folderPath) {
    String filePath = folderPath + "/" + fileName; // Constructing the file path

    try (FileWriter writer = new FileWriter(filePath)) {
      writer.write(executedCommands.toString()); // Writing the executedCommands string to the file
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
    executedCommands.append(inputStrings.get(currentIndex)).append("\n");
    currentIndex++;
  }
}
