package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class Repeat implements Executable {

  private int repeats;
//  private List<Executable> commands;
  private ListExecutable list;

  public Repeat(int timesToRepeat, ListExecutable commandListObject){
    this.repeats = timesToRepeat;
    this.list = commandListObject;
  }

  @Override
  public double execute(EnvironmentApi env) {
    list.executeAll(env);
    return list.getList().size() * repeats;
  }
}
