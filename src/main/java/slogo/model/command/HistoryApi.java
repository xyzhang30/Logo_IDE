package slogo.model.command;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.token.Token;

/**
 * External Interface for History tracker object
 */
public interface HistoryApi {

  void setTokens(List<Token> tokens);

  double executeCurrentCommand();

  void addCommand(Executable c);

  void incrementCommandIndex();

  void saveFile(String fileName, String folderPath);

  void setStrings(List<String> inputStrings);

  void saveCurrent();
}
