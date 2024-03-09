package slogo.model.api;

import slogo.model.command.Executioner;

/**
 * Abstract factory class for creating instances of different components in the SLogo model.
 */

public abstract class ModelFactory {

  /**
   * Creates and returns a new instance of the {@link ExecutionerApi} interface.
   *
   * @return a new instance of the {@link ExecutionerApi} interface
   */
  public ExecutionerApi createExecutioner(){
    return new Executioner();
  }

}
