package slogo.model.api;

import slogo.model.command.executables.Executable;

/**
 * External Interface for History tracker object
 */
public interface HistoryApi {

  double executeCurrentCommand();

  void addCommand(Executable c);

  void incrementCommandIndex();
}
