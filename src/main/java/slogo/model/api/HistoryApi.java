package slogo.model.api;

/**
 * External Interface for History tracker object
 */
public interface HistoryApi {
  double executeCurrentCommand();
  void addCommand(Executable c);
  void incrementCommandIndex();
}
