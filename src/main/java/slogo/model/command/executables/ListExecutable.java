package slogo.model.command.executables;

import java.util.List;

public class ListExecutable implements Executable {
  private List<Executable> myList;
  public ListExecutable(List<Executable> tlist){
    myList = tlist;
  }
  public List<Executable> getList(){
    return myList;
  }
  /**
   * Should not ever be called!
   * @return 0  Nothing, this is just a wrapped list
   */
  @Override
  public double execute() {
    return 0;
  }
}
