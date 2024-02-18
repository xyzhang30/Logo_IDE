package command;

public interface commandParser {

  /**
   * Process input stream. Throw exceptions for bad commands/syntax. Interprets and adds commands to
   * Stack of commands, history.
   */
  public void parseInput(String);

  /**
   * Executes the command at the current line.
   */
  public void executeCurrentLine();

  /**
   * Returns the index of the current line marker. Where the commandParser is at in the code.
   * @return int  index of current line marker.
   */
  public int getCurrentLine();

  /**
   * Sets the current line marker to the specified index. Throws an exception if the index provided
   * is not a valid index.
   */
  public void setCurrentLine(int);
}
