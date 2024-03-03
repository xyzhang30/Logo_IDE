package slogo.model.command.executables;

import java.util.List;
import slogo.model.command.executables.Executable;

public class RootExecutable implements Executable {

  private List<Executable> tree;
  private int currIdx;
  private int nextIdx;

  public RootExecutable(List<Executable> tree){
    this.tree = tree;
    currIdx = 0;
    nextIdx = 1;
  }

  public boolean hasNext(){
    return tree.get(nextIdx) != null;
  }

  @Override
  public double execute() {
    return 0;
  }
}
