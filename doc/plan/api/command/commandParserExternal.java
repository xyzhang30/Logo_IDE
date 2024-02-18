package command;

public interface commandParser {
  public void parseInput(String);
  public void executeCurrentLine();
  public int getCurrentLine();
  public void setCurrentLine(int);
}
