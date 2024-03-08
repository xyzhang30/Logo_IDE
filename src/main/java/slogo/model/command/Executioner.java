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

public class Executioner implements ExecutionerApi {

  private RootExecutable root;
  private final Tokenizer tokenizer;
  private final TreeParser treeParser;
  private final Environment environment;
  private CommandHistory commandHistory;


  public Executioner() {
    environment = new Environment(400,600);
    tokenizer = new Tokenizer("English");
    treeParser = new TreeParser();
    root = null;
  }

  @Override
  public void reset() {

  }

  @Override
  public void step() {
    root.execute(environment);
  }

  @Override
  public void parseTree(InputRecord commandInput) {
    System.out.println("in exeparse tree");
    List<Token> tokens = tokenizer.tokenize(commandInput.input());
    root = (RootExecutable)treeParser.parseTree(tokens);
  }

  @Override
  public void runNext() {
    try{
      root.execute(environment);
    } catch (Exception e){
      throw new RuntimeException();
    }
  }

  @Override
  public boolean hasNext() {
    System.out.println("root: "+root);
    return root.hasNext();
  }

  @Override
  public TurtleModelApi getTurtleModel(){
    return environment.getTurtleMap().get(1.0);
  }

  @Override
  public Map<Double, TurtleModelApi> getTurtleModels() {
    environment.syncTurtleActivation(); //This is TERRIBLE practice!
    return Collections.unmodifiableMap(environment.getTurtleMap());
  }

  @Override
  public List<Double> getActiveTurtles() {
    return environment.getActiveTurtleKeys();
  }

  @Override
  public CommandHistory getHistory() {
    return treeParser.getHistory();
  }

  @Override
  public CommandXmlParser getXmlParser(){
    return new CommandXmlParser();
  }

  @Override
  public void saveFile(String fileName, String folderPath){
    treeParser.getHistory().saveFile(fileName, folderPath);
  }


//  @Override
//  public Map<String, Double> getVariableMap() {
//    return environment.getVarMap();
//  }
//
//  @Override
//  public Map<String, Executable> getFunctionMap() {
//    return environment.getFuncMap();
//  }
}
