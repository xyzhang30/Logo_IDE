package slogo.model.command;

/**
 * Token class for a literal. Literals are constants.
 */
public class LiteralToken implements Token{
  private static double myValue;

  public LiteralToken(double d){
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
