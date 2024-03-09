package slogo.model.command.executables;

import java.util.List;
import slogo.model.environment.EnvironmentApi;

public class RootExecutable implements Executable {

  private final List<Executable> tree;
  private int currIdx;

  public RootExecutable(List<Executable> tree) {
    this.tree = tree;
    currIdx = 0;
  }

  public boolean hasNext() {
    return currIdx < tree.size();
  }

  @Override
  public double execute(EnvironmentApi env) {
    double val = tree.get(currIdx).execute(env);
    currIdx++;
    return val;
  }
}
