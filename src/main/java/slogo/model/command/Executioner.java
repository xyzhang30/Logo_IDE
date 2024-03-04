package slogo.model.command;

import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.executables.RootExecutable;
import slogo.model.environment.Environment;
import slogo.model.environment.EnvironmentApi;
import slogo.model.parser.TreeParser;

public class Executioner implements ExecutionerApi {

  private RootExecutable root;
  private TreeParser treeParser;
  private EnvironmentApi environment;


  public Executioner() {
    environment = new Environment(0,0);
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
    root = (RootExecutable)treeParser.parseTree(commandInput);
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
    return environment.getTurtle();
  }
}
