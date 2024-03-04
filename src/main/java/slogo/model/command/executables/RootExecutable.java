package slogo.model.command.executables;

import java.util.List;
import slogo.model.environment.Environment;
import slogo.model.environment.EnvironmentApi;

public class RootExecutable implements Executable {

  private List<Executable> tree;
  private int currIdx;

  public RootExecutable(List<Executable> tree){
    this.tree = tree;
    currIdx = 0;
  }

  public boolean hasNext(){
    return tree.get(currIdx) != null;
  }

  @Override
  public double execute(EnvironmentApi env) {
    runNext();
    currIdx ++;
    return 0;
  }

  private void runNext(){
    tree.get(currIdx).execute(new Environment(100,200));// THIS IS NOT A CORRECT USE!S
  }

}
