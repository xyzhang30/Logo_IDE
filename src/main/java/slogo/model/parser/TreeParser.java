package slogo.model.parser;


import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import slogo.model.api.InputRecord;
import slogo.model.api.InvalidCommandException;
import slogo.model.api.InvalidParameterNumberException;
import slogo.model.api.ParserApi;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.CommandHistory;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.ErrorExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.command.executables.RootExecutable;
import slogo.model.token.Token;
import slogo.model.token.Tokenizer;
import slogo.model.token.TokenizerApi;
import slogo.model.turtle.TurtleModel;
import slogo.model.xmlparser.CommandXmlParser;

public class TreeParser implements ParserApi {
  public static final String EXEC_REFS = "slogo.model.command.executables.";
  private final TokenizerApi tokenizer;
  private final Map<String,Double> variablesTable;
  private CommandHistory history;
  private CommandXmlParser xmlParser;
  private List<String> inputStrings;

  public TreeParser(){
    tokenizer = new Tokenizer("English");
    variablesTable = new HashMap<>();
    xmlParser = new CommandXmlParser();
    inputStrings = new ArrayList<>();
  }
  @Override
  public Executable parseTree(InputRecord myRecord) throws InvalidParameterNumberException,
      InvalidCommandException {
    List<Executable> tree = new ArrayList<>();
    List<Token> tokens = tokenizer.tokenize(myRecord.input());
    history = new CommandHistory();
    history.setTokens(tokens);
    while (!tokens.isEmpty()){
      System.out.println(tokens.size());
      tree.add(craftBranch(tokens));
    }
    history.setStrings(inputStrings);
    Executable root = new RootExecutable(tree);
    return root;
  }

  private Executable craftBranch(List<Token> tokens) {
    Token t = tokens.remove(0);
    String inputString = t.value();
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
        Class<?> cc = ErrorExecutable.class;
        try{
          xmlParser.readXml(t.type());
          cc = Class.forName(EXEC_REFS + "mathcommand." + t.type() + "Command");
        }
        catch (ClassNotFoundException e){
          try {
            xmlParser.readXml(t.type());
            cc = Class.forName(EXEC_REFS + "turtlecommand." + t.type());
          }
          catch (ClassNotFoundException | FileNotFoundException ex) {
            throw new InvalidCommandException(ex.getMessage());
          }
        } catch (FileNotFoundException e) {
          throw new InvalidCommandException(e.getMessage());
        }

        List<Executable> parameters = new ArrayList<>();
        for (int i=0;i<getNumParams(t.type());i++){
          parameters.add(craftBranch(tokens));
        }

        try{
          inputStrings.add(inputString);
          return (Executable) cc.getDeclaredConstructor(List.class).newInstance(parameters);
        }
        catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                 InstantiationException e) {
          throw new RuntimeException(e);
        }
    }
    return new ErrorExecutable("Detected Invalid Regex: "+t.value());
  }

  private int getNumParams(String sig){
    return xmlParser.getNumParamsExpected();
  }

}
