package slogo.model.command.executables;

import java.util.List;
import slogo.model.turtle.TurtleModel;

public class Towards extends CommandExecutable {

  private double degrees;

  double facingPosX;
  double facingPosY;

  public Towards(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    facingPosX = getParameterData().get(0);
    facingPosY = getParameterData().get(1);
  }

  @Override
  public double internalLogicExecution() {
    double originalDirection = getTurtle().getDegreesDirection();

    double lengthX = facingPosX - getTurtle().getPosX();
    System.out.println(facingPosX);
    System.out.println(getTurtle().getPosX());
//    System.out.println(lengthX);
    double lengthY = facingPosY - getTurtle().getPoxY();
//    System.out.println(lengthY);
    double lengthHyp = Math.sqrt(Math.pow(lengthX,2)+Math.pow(lengthY,2));
    System.out.println(lengthHyp);

    double angleRadian = Math.cos(lengthX/lengthHyp);
    System.out.println(angleRadian);
    getTurtle().setDirection(Math.toDegrees(angleRadian));
    System.out.println(getTurtle().getDegreesDirection());

    return Math.abs(originalDirection - getTurtle().getDegreesDirection());
  }
}
