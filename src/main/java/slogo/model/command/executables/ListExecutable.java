package slogo.model.command.executables;

import java.util.List;

public class ListExecutable implements Executable {

  private final List<Executable> myList;
  private int currentIndex;

  public ListExecutable(List<Executable> tlist) {
    myList = tlist;
    currentIndex = 0;
  }

  public List<Executable> getList() {
    return myList;
  }

  /**
   * Returns execution of the Executable at the current list index
   *
   * @return 0  Nothing, this is just a wrapped list
   */
  @Override
  public double execute() {
    return myList.get(currentIndex).execute();
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
  public void executeAll() {
    myList.forEach(Executable::execute);
  }
}
