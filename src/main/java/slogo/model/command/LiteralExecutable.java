package slogo.model.command;

/**
 * Executable class for a literal. Literals are constants.
 */
public class LiteralExecutable implements Executable {
  private static double myValue;

  public LiteralExecutable(double d){
    myValue = d;
  }

  /**
   * Literals return their stored values when executed.
   * @return double  stored value represented by the literal.
   */
  @Override
  public double execute() {
    return myValue;
  }
}
