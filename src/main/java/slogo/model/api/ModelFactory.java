package slogo.model.api;

import slogo.model.command.Executioner;

public abstract class ModelFactory {
  public ExecutionerApi createExecutioner(){
    return new Executioner();
  }

}
