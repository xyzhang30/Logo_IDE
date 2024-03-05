package slogo.model.command;

import java.util.List;
import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.executables.RootExecutable;
import slogo.model.environment.Environment;
import slogo.model.parser.TreeParser;
import slogo.model.token.Token;
import slogo.model.token.Tokenizer;

public class Executioner implements ExecutionerApi {

  private RootExecutable root;
  private final Tokenizer tokenizer;
  private final TreeParser treeParser;
  private final Environment environment;


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
    return root.hasNext();
  }

  @Override
  public TurtleModelApi getTurtleModel(){
    return environment.getTurtleMap().get(1.0);
  }
}
