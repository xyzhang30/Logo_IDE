package slogo.model.command;

import java.util.List;

/**
 * External Interface for History tracker object.
 */
public interface HistoryApi {

//  void setTokens(List<Token> tokens);

//  double executeCurrentCommand();

//  void addCommand(Executable c);

//  void incrementCommandIndex();

  void saveFile(String fileName, String folderPath);

  void setStrings(List<String> inputStrings);

  void saveCurrent();

  String getCommands();

}
