package slogo.model.command;

import slogo.model.api.Executable;

/**
 * Executable class for a constant.
 */
public class ConstantExecutable implements Executable {

  private static double myValue;

  public ConstantExecutable(double d) {
    myValue = d;
  }

  /**
   * Constants return their values when executed.
   *
   * @return double  the constant value
   */
  @Override
  public double execute() {
    return myValue;
  }
}
