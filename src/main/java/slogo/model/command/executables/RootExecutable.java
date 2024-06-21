package slogo.model.command.executables;

import java.util.List;
import slogo.model.environment.EnvironmentApi;

/**
 * This class represents the root executable in the command tree.
 */
public class RootExecutable implements Executable {

  private final List<Executable> tree;
  private int currIdx;

  /**
   * Constructs a new {@code RootExecutable} with the specified command tree.
   *
   * @param tree the list of executables representing the command tree
   */
  public RootExecutable(List<Executable> tree) {
    this.tree = tree;
    currIdx = 0;
  }

  /**
   * Checks if there are more executables to be executed in the command tree.
   *
   * @return {@code true} if there are more executables, {@code false} otherwise
   */
  public boolean hasNext() {
    System.out.println("TRee:"+tree);
    return currIdx < tree.size();
  }

  /**
   * Executes the next executable in the command tree and advances the current index.
   *
   * @param env the environment in which the command is executed
   * @return the result of executing the next executable
   */
  @Override
  public double execute(EnvironmentApi env) {
    double output = tree.get(currIdx).execute(env);
    currIdx++;
    return output;
  }
}
