package slogo.model.command;

/**
 * External Interface for History tracker object
 */
public interface HistoryAPI {
  double executeCurrentCommand();
  void addCommand(CommandLineAPI c);
  void incrementCommandIndex();
}
