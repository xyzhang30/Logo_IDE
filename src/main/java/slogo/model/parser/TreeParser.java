package slogo.model.parser;


import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import slogo.model.api.InvalidCommandException;
import slogo.model.api.ParserApi;
import slogo.model.command.CommandHistory;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.CustomCommandExecutable;
import slogo.model.command.executables.ErrorExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.command.executables.RootExecutable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.token.Token;
import slogo.xmlparser.CommandXmlParser;

/**
 * The {@code TreeParser} class is responsible for parsing tokens into an executable tree structure.
 * It converts a list of tokens into a hierarchical structure of executable commands.
 */

public class TreeParser implements ParserApi {

  public static final String EXEC_REFS = "slogo.model.command.executables.";
  private final CommandXmlParser xmlParser;
  private final CommandHistory history;
  private final List<String> inputStrings;

  public TreeParser() {
    xmlParser = new CommandXmlParser();
    inputStrings = new ArrayList<>();
    history = new CommandHistory();
  }

  /**
   * Parses a list of tokens into an executable tree structure.
   *
   * @param tokens the list of tokens to be parsed
   * @return the root of the executable tree structure
   */
  @Override
  public Executable parseTree(List<Token> tokens) {
    List<Executable> tree = new ArrayList<>();
    while (!tokens.isEmpty()) {
      String string = "";
      List<String> commandString = new ArrayList<>();
      commandString.add(string);

      tree.add(craftBranch(tokens, commandString));
      inputStrings.add(commandString.get(0));
    }
    history.setStrings(inputStrings);
    return new RootExecutable(tree);
  }

  private Executable craftBranch(List<Token> tokens, List<String> commandString) {
    Token t = tokens.remove(0);
    commandString.set(0, commandString.get(0) + t.value() + " "); //add token value into string
    switch (t.type()) {
      case "Comment":
        return craftBranch(tokens, commandString);
      case "Constant":
        return new ConstantExecutable(Double.parseDouble(t.value()));
      case "Variable":
        return new VariableExecutable(t.value());
      case "Command":
        return new CustomCommandExecutable(t.value());
      case "ListStart":
        List<Executable> listContents = new ArrayList<>();
        while (!tokens.get(0).type().equals("ListEnd")) {
          listContents.add(craftBranch(tokens, commandString));
        }
        tokens.remove(0);
        commandString.set(0, commandString.get(0) + "] ");
        return new ListExecutable(listContents);
      case "ListEnd":
        return new ErrorExecutable("Incorrect Syntax: Unpaired ] Detected.");
      case "Error":
        return new ErrorExecutable("Detected Invalid Regex: " + t.value());
      default:
        Class<?> cc = ErrorExecutable.class;
        try {
          xmlParser.readXml(t.type());
          cc = Class.forName(EXEC_REFS + getClassPath(t.type()));
        } catch (ClassNotFoundException | FileNotFoundException e) {
          throw new InvalidCommandException(e.getMessage());
        }

        List<Executable> parameters = new ArrayList<>();
        for (int i = 0; i < getNumParams(t.type()); i++) {
          parameters.add(craftBranch(tokens, commandString));
        }

        try {
          return (Executable) cc.getDeclaredConstructor(List.class).newInstance(parameters);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                 InstantiationException e) {
          throw new RuntimeException(e);
        }
    }
  }


  /**
   * Retrieves the command history associated with this parser.
   *
   * @return the command history
   */
  public CommandHistory getHistory() {
    return history;
  }

  private int getNumParams(String sig) {
    return xmlParser.getNumParamsExpected();
  }

  private String getClassPath(String sig) {
    return xmlParser.getImplementationName();
  }

}
