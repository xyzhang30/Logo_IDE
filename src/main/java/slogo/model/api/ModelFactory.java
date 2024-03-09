package slogo.model.api;

import slogo.model.command.Executioner;

public final class ModelFactory {

  public ExecutionerApi createExecutioner() {
    return new Executioner();
  }

}
