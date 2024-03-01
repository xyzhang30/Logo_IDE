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
import slogo.model.api.TurtleModelApi;
import slogo.model.command.Executioner;
import slogo.model.command.executables.CommandExecutable;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.ErrorExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.token.Token;
import slogo.model.token.Tokenizer;
import slogo.model.token.TokenizerApi;
import slogo.model.turtle.TurtleModel;

public class TreeParser implements ParserApi {
  public static final String EXEC_REFS = "slogo.model.command.executables.";
  private ExecutionerApi executioner;
  private final TokenizerApi tokenizer;
  private final Map<String,Double> variablesTable;
  private TurtleModelApi turtle;
  public TreeParser(){
    executioner = new Executioner();
    tokenizer = new Tokenizer("English");
    variablesTable = new HashMap<>();
    turtle = new TurtleModel();
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

  private Executable craftBranch(List<Token> tokens) {
    Token t = tokens.remove(0);
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
        Class<?> clazz = ErrorExecutable.class;
        try{
          clazz = Class.forName(EXEC_REFS + "mathCommand." + t.type());
          System.out.println(clazz.getConstructors()[0].getParameterCount());
        }
        catch (ClassNotFoundException e){
          try {
            clazz = Class.forName(EXEC_REFS + "turtleCommand." + t.type());
          }
          catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
          }
        }
        try{
          CommandExecutable branch = (CommandExecutable) clazz.getDeclaredConstructor().newInstance();
        }
        catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                 InstantiationException e) {
          throw new RuntimeException(e);
        }
        return null;
    }
    return new ErrorExecutable("Detected Invalid Regex: "+t.value());
  }
}
