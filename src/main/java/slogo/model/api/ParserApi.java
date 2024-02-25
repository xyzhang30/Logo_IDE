package slogo.model.api;

import slogo.model.command.executables.Executable;

public interface ParserApi {

  Executable parseTree(Record inputRecord) throws InvalidParameterNumberException;

}
