package slogo.model.parser;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
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
  private ExecutionerApi executioner;
  private TokenizerApi tokenizer;
  public TreeParser(){
    executioner = new Executioner();
    tokenizer = new Tokenizer("English");
  }
  @Override
  public Executable parseTree(InputRecord myRecord) throws InvalidParameterNumberException,
      InvalidCommandException {
    List<Token> tokens = tokenizer.tokenize(myRecord.input());
    while (!tokens.isEmpty()){
      Token t = tokens.remove(0);
      System.out.println(t.type());
    }
    for (Token t : tokenizer.tokenize(myRecord.input())){
      switch (t.type()){
        case "Comment": break;
        case "Constant": break;
        case "Variable": break;
        case "Command": break;
        case "ListStart": break;
        case "ListEnd": break;
        case "Error": break;
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
    return null;
  }

  private Executable craftBranch(){
    return new ConstantExecutable(0);
  }
}
