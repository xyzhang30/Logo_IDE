package slogo.model.parser;

import java.lang.reflect.InvocationTargetException;
import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.InvalidCommandException;
import slogo.model.api.InvalidParameterNumberException;
import slogo.model.api.ParserApi;
import slogo.model.command.Executioner;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.token.Token;
import slogo.model.token.Tokenizer;
import slogo.model.token.TokenizerApi;

public class TreeParser implements ParserApi {
  public static final String EXEC_REFS = "slogo.model.command.executables.";
  private ExecutionerApi root;
  private TokenizerApi tokenizer;
  public TreeParser(){
    root = new Executioner();
    tokenizer = new Tokenizer("English");
  }
  @Override
  public Executable parseTree(InputRecord myRecord) throws InvalidParameterNumberException,
      InvalidCommandException {

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
              Executable n =  (CommandExecutable) Class.forName(EXEC_REFS + t.type())
                  .getDeclaredConstructor().newInstance();
            }
            catch (ClassNotFoundException e){
              throw new InvalidCommandException("Nonexistent Command");
            }
            catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                   InvocationTargetException e) {
              throw new RuntimeException(e);
            }
        }
      }
    }
    return null;
  }

  private Executable craftBranch(){
    return new ConstantExecutable(0);
  }
}
