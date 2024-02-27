package slogo.model.api;

import slogo.model.command.executables.Executable;

/**
 * External API for the Parser. Constructs the Executables tree.
 */
public interface ParserApi {

  /**
   * Converts a Record of input from controller into an tree of Executables.
   * @param inputRecord  data to be tokenized and parsed. Contains a string of commands.
   * @return Executable  The root of the tree of command Executables.
   * @throws InvalidParameterNumberException  If the data is syntactically incorrect.
   */
  Executable parseTree(InputRecord inputRecord) throws InvalidParameterNumberException;

}
