package slogo.model.command.executables;

/**
 * Executable class for a constant.
 */
public class ConstantExecutable implements Executable {

  private final double myValue;
  /**
   * Constructor for Constant Executables.
   * @param value  The value of this Constant
   */
  public ConstantExecutable(double value) {
    myValue = value;
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
