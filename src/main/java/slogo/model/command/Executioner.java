package slogo.model.command;

import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.RootExecutable;
import slogo.model.parser.TreeParser;
import slogo.model.turtle.TurtleModel;

public class Executioner implements ExecutionerApi {

  private RootExecutable root;
  private TreeParser treeParser;
  private TurtleModel turtleModel;


  public Executioner() {
    turtleModel = new TurtleModel();
    treeParser = new TreeParser();
    root = null;
  }

  @Override
  public void reset() {

  }

  @Override
  public void step() {
    root.execute();
  }

  @Override
  public void parseTree(InputRecord commandInput) {
    root = (RootExecutable)treeParser.parseTree(commandInput);
  }

  @Override
  public void runNext() {

  }

  @Override
  public boolean hasNext() {
    return root.hasNext();
  }

  @Override
  public TurtleModelApi getTurtleModel(){
    return turtleModel;
  }
}
