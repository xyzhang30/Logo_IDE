package slogo.model.command;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CommandHistory implements HistoryApi {

  private List<String> inputStrings;
  private int currentIndex;
//  private StringBuilder executedCommands;
    private String executedCommands;


  public CommandHistory(){
    currentIndex = 0;
    executedCommands = "";
  }

  @Override
  public String getCommands() {
//    return executedCommands.toString();
    return executedCommands;
  }

  @Override
  public void saveFile(String fileName, String folderPath) {
    String filePath = folderPath + "/" + fileName; // Constructing the file path

    try (FileWriter writer = new FileWriter(filePath)) {
//      writer.write(executedCommands.toString()); // Writing the executedCommands string to the file
      writer.write(executedCommands);
      System.out.println("File saved successfully: " + filePath);
    } catch (IOException e) {
      System.err.println("Error saving file: " + e.getMessage());
    }
  }

  @Override
  public void setStrings(List<String> inputStrings) {
    this.inputStrings = inputStrings;
    System.out.println(this.inputStrings);
    saveCurrent();
  }

  @Override
  public void saveCurrent() {
    for (String s : inputStrings){
      executedCommands = executedCommands.concat(s + "\n");
      System.out.println("exe:"+executedCommands);
    }
    System.out.println("inputStrings: "+inputStrings);
//    executedCommands.append(inputStrings.get(currentIndex)).append("\n");
//    System.out.println("executed commands: "+ executedCommands);
//    currentIndex++;
//    System.out.println("curr index: "+ currentIndex);

  }
}
