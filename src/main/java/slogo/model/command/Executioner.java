package slogo.model.command;

import slogo.model.api.ExecutionerApi;
import slogo.model.command.executables.Executable;

public class Executioner implements ExecutionerApi {
  private Executable root;
  public Executioner(Executable root){
    this.root = root;
  }
}
