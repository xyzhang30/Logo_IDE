package slogo.model.command.executables;

import java.util.List;
import slogo.model.command.executables.Executable;

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
  public double execute() {
    runNext();
    currIdx ++;
    return 0;
  }

  private void runNext(){
    tree.get(currIdx).execute();
  }

}
