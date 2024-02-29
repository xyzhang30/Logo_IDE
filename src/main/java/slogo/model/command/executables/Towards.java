package slogo.model.command.executables;

import java.util.List;
import slogo.model.turtle.TurtleModel;

public class Towards extends CommandExecutable {

  private double facingPosX;
  private double facingPosY;

  public Towards(List<Executable> parameterExecutables, TurtleModel turtle) {
    super(parameterExecutables, turtle);
    facingPosX = getParameterData().get(0);
    facingPosY = getParameterData().get(1);
  }

  @Override
  public double internalLogicExecution() {
    double originalDirection = getTurtle().getDegreesDirection();

    double lengthX = facingPosX - getTurtle().getPosX();
    double lengthY = facingPosY - getTurtle().getPoxY();

    double degreesOffSet = 0; //first quadrant (default value)
    if (lengthX < 0 && lengthY >= 0){ //second quadrant
      degreesOffSet = 90;
    } else if (lengthX < 0 && lengthY < 0){ //third
      degreesOffSet = 180;
    } else if (lengthX >= 0 && lengthY < 0){ //fourth
      degreesOffSet = 270;
    }

    double angleRadian = Math.atan(Math.abs(lengthX) / Math.abs(lengthY));
    getTurtle().setDirection(Math.toDegrees(angleRadian) + degreesOffSet);

    return Math.abs(originalDirection - getTurtle().getDegreesDirection());
  }
}
