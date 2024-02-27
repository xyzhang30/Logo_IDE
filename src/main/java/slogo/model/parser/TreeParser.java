package slogo.model.parser;

import slogo.model.api.InputRecord;
import slogo.model.api.InvalidParameterNumberException;
import slogo.model.api.ParserApi;
import slogo.model.command.executables.Executable;
import slogo.model.token.Tokenizer;
import slogo.model.token.TokenizerApi;

public class TreeParser implements ParserApi {
  private TokenizerApi tokenizer;
  public TreeParser(){
    tokenizer = new Tokenizer("English");
  }
  @Override
  public Executable parseTree(InputRecord myRecord) throws InvalidParameterNumberException {
    String base = myRecord.input();
    return null;
  }
}
