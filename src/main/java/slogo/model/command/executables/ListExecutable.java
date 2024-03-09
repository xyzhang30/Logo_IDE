package slogo.model.command.executables;

import java.util.List;
import slogo.model.environment.EnvironmentApi;

/**
 * Executable class for Lists of Executables
 */
public class ListExecutable implements Executable {

  private ListExecutable oldContext;
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
   * Sets context to this list and returns execution of the Executable at the current list index.
   * Increments the list index by 1 until the list has been completed, at which context is restored.
   *
   * @return double  the value returned by the executable called at the current index.
   */
  @Override
  public double execute(EnvironmentApi env) {
    if (currentIndex == 0){
      env.getContextStack().add(this);
    }
    for (Executable e : env.getContextStack()){
      System.out.print(e.getClass().getSimpleName()+"  ");
    }
    System.out.println();
    double output = myList.get(currentIndex).execute(env);
    nextIndex();
    if (currentIndex >= myList.size()){
      resetIndex();
      env.getContextStack().remove(this);
    }
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
}
