package slogo.model.command.executables;

import java.util.List;
import slogo.model.environment.EnvironmentApi;

/**
 * Executable class for Lists of Executables
 */
public class ListExecutable implements Executable {

  private final List<Executable> myList;
  private int currentIndex;

  /**
   * Constructor for List Executable
   *
   * @param inlist The list of Executables to be stored
   */
  public ListExecutable(List<Executable> inlist) {
    myList = inlist;
    currentIndex = 0;
  }

  public List<Executable> getList() {
    return myList;
  }

  /**
   * Returns execution of the Executable at the current list index
   *
   * @return double  the value returned by the executable called at the current index.
   */
  @Override
  public double execute(EnvironmentApi env) {
    double output = myList.get(currentIndex).execute(env);
    currentIndex = (currentIndex+1)%myList.size();
    return output;
  }

  /**
   * Increments current index of list.
   */
  public void nextIndex() {
    currentIndex += 1;
  }

  /**
   * Sets current index of list back to 0.
   */
  public void resetIndex() {
    currentIndex = 0;
  }

  /**
   * Executes all Executables in this list at once.
   */
  public void executeAll(EnvironmentApi env) {
    myList.forEach(e -> e.execute(env));
  }
}
