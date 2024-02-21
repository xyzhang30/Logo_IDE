package slogo.model.command;

import java.util.List;
import java.util.ArrayList;

/**
 * A list of commandLines. Manages the history of entered commands.
 */
public class CommandHistory implements History{
  private List<CommandLine> commands;
  private int currentIndex;
  public CommandHistory(){
    clearHistory();
  }
  public double executeCurrentCommand(){
    return commands.get(currentIndex).execute();
  }
  public void incrementCommandIndex() {
    if (currentIndex>commands.size()){
      throw new IndexOutOfBoundsException(String.format(
          "Attempted to increment past end of history. History has %s items.", commands.size()));
    }
    currentIndex++;
  }
  public void addCommand(CommandLine com){
    commands.add(com);
  }
  public void jumpToCommand(int index){
    if (index>commands.size() || index<0){
      throw new IndexOutOfBoundsException("Attempted to jump to an invalid index in history");
    }
    currentIndex = index;
  }
  public CommandLine getCurrentCommand(){
    return commands.get(currentIndex);
  }
  public int getCurrentIndex(){
    return currentIndex;
  }
  private void clearHistory() {
    commands = new ArrayList<>();
    currentIndex = 0;
  }

}
