package slogo.model.api;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.token.Token;

/**
 * External API for the Parser. Constructs the Executables tree.
 */
public interface ParserApi {

  /**
   * Converts a Record of input from controller into an tree of Executables.
   * @param tokens  data to be parsed. Contains a string of commands.
   * @return Executable  The root of the tree of command Executables.
   * @throws InvalidParameterNumberException  If the data is syntactically incorrect.
   */
  Executable parseTree(List<Token> tokens) throws InvalidParameterNumberException;

}
