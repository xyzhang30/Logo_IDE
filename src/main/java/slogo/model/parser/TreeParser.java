package slogo.model.parser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.InvalidCommandException;
import slogo.model.api.InvalidParameterNumberException;
import slogo.model.api.ParserApi;
import slogo.model.command.Executioner;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.token.Token;
import slogo.model.token.Tokenizer;
import slogo.model.token.TokenizerApi;

public class TreeParser implements ParserApi {
  public static final String EXEC_REFS = "slogo.model.command.executables.";
  private ExecutionerApi executioner;
  private final TokenizerApi tokenizer;
  private Map<String,Double> variablesTable;
  public TreeParser(){
    executioner = new Executioner();
    tokenizer = new Tokenizer("English");
    variablesTable = new HashMap<>();
  }
  @Override
  public Executable parseTree(InputRecord myRecord) throws InvalidParameterNumberException,
      InvalidCommandException {
    List<Executable> root = new ArrayList<>();
    List<Token> tokens = tokenizer.tokenize(myRecord.input());
    while (!tokens.isEmpty()){
      System.out.println(tokens.size());
      root.add(craftBranch(tokens));
    }
    return null;
  }

  private Executable craftBranch(List<Token> tokens){
    Token t = tokens.remove(0);
    Executable branch = null;
    switch (t.type()){
      case "Comment":
        return craftBranch(tokens);
      case "Constant":
        return new ConstantExecutable(Double.parseDouble(t.value()));
      case "Variable":
        return new VariableExecutable(t.value(), variablesTable);
      case "Command": break;
      case "ListStart": break;
      case "ListEnd": break;
      case "Error": break;
      default:
        try{
          branch = (CommandExecutable) Class.forName(EXEC_REFS + t.type())
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
    return branch;
  }
}
