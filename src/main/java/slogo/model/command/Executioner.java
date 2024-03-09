package slogo.model.command;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.executables.RootExecutable;
import slogo.model.environment.Environment;
import slogo.model.parser.TreeParser;
import slogo.model.token.Token;
import slogo.model.token.Tokenizer;
import slogo.xmlparser.CommandXmlParser;

/**
 * The {@code Executioner} class is responsible for executing commands and managing the execution
 * environment.
 */

public class Executioner implements ExecutionerApi {

  private final Tokenizer tokenizer;
  private final TreeParser treeParser;
  private final Environment environment;
  private RootExecutable root;
  private CommandHistory commandHistory;

  /**
   * constructs an executioner used to call parse and commands
   */
  public Executioner() {
    environment = new Environment(400, 600);
    tokenizer = new Tokenizer("English");
    treeParser = new TreeParser();
    root = null;
  }

  /**
   * Resets the execution environment.
   */
  @Override
  public void reset() {
  }

  /**
   * Executes the next step in the execution process.
   */
  @Override
  public void step() {
    root.execute(environment);
  }

  /**
   * Parses the input command and generates the execution tree.
   *
   * @param commandInput the input record containing the command
   */
  @Override
  public void parseTree(InputRecord commandInput) {
    System.out.println("in exeparse tree");
    List<Token> tokens = tokenizer.tokenize(commandInput.input());
    root = (RootExecutable) treeParser.parseTree(tokens);
    environment.getContextStack().clear();
    environment.getContextStack().add(root);
  }

  /**
   * Runs the next command in the execution tree.
   */
  @Override
  public void runNext() {
    try {
      environment.getContextStack().get(environment.getContextStack().size() - 1)
          .execute(environment);
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  /**
   * Checks if there is a next command in the execution tree.
   *
   * @return {@code true} if there is a next command, {@code false} otherwise
   */
  @Override
  public boolean hasNext() {
    return root.hasNext() || environment.getContextStack().size() > 1;
  }

  /**
   * Retrieves the turtle model.
   *
   * @return the turtle model
   */
  @Override
  public TurtleModelApi getTurtleModel() {
    return environment.getTurtleMap().get(1.0);
  }

  /**
   * Retrieves a map of turtle models.
   *
   * @return an unmodifiable map of turtle models
   */
  @Override
  public Map<Double, TurtleModelApi> getTurtleModels() {
    environment.syncTurtleActivation(); //This is TERRIBLE practice!
    return Collections.unmodifiableMap(environment.getTurtleMap());
  }

  /**
   * Retrieves the active turtles.
   *
   * @return a list of active turtle IDs
   */
  @Override
  public List<Double> getActiveTurtles() {
    return environment.getActiveTurtleKeys();
  }

  /**
   * Retrieves the command history.
   *
   * @return the command history
   */
  @Override
  public CommandHistory getHistory() {
    return treeParser.getHistory();
  }

  /**
   * Retrieves the XML parser.
   *
   * @return the XML parser
   */
  @Override
  public CommandXmlParser getXmlParser() {
    return new CommandXmlParser();
  }

  /**
   * Saves the executed commands to a file.
   *
   * @param fileName   the name of the file to save
   * @param folderPath the path of the folder where the file will be saved
   */
  @Override
  public void saveFile(String fileName, String folderPath) {
    treeParser.getHistory().saveFile(fileName, folderPath);
  }

  /**
   * Retrieves the variable map.
   *
   * @return the variable map
   */

  @Override
  public Map<String, Double> getVariableMap() {
    return environment.getVarMap();
  }

}
