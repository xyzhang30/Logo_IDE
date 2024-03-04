package slogo.model.command.executables.structures;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.environment.EnvironmentApi;

public class Repeat implements Executable {

  private int repeats;
  private List<Executable> commands;

  public Repeat(int timesToRepeat, ListExecutable commandListObject){
    this.repeats = timesToRepeat;
    this.commands = commandListObject.getList();
  }

  //TODO:
  @Override
  public double execute(EnvironmentApi env) {
//    for (Executable e : commands){
//      e.execute();
//    }
    return 0;
  }
}
