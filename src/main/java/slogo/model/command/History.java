package slogo.model.command;

/**
 * External Interface for History tracker object
 */
public interface History {
  double executeCurrentCommand();
  void addCommand(CommandLine c);
  void incrementCommandIndex();
}
