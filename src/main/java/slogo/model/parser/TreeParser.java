package slogo.model.parser;

import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.InvalidTokenException;
import slogo.model.api.InvalidParameterNumberException;
import slogo.model.api.ParserApi;
import slogo.model.command.Executioner;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.token.Token;
import slogo.model.token.Tokenizer;
import slogo.model.token.TokenizerApi;

public class TreeParser implements ParserApi {
  private ExecutionerApi root;
  private TokenizerApi tokenizer;
  public TreeParser(){
    root = new Executioner();
    tokenizer = new Tokenizer("English");
  }
  @Override
  public Executable parseTree(InputRecord myRecord) throws InvalidParameterNumberException {

    for (String line : myRecord.input().split("\n")){
      for (Token t : tokenizer.tokenize(line)){
        switch (t.type()){
          case "Comment": break;
          case "Constant": break;
          case "Variable": break;
          case "Command": break;
          case "ListStart": break;
          case "ListEnd": break;
          default:
            try{
              //reflection
            }
            catch (InvalidParameterNumberException e){

            }
        }
        System.out.println(t.type());
      }
    }
    return null;
  }

  private Executable craftBranch(){
    return new ConstantExecutable(0);
  }
}
