package slogo.model.command.executables.turtlecommand;

import java.util.List;
import slogo.model.command.executables.Executable;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class Towards extends TurtleExecutable {

  private Executable targetX;
  private Executable targetY;

  public Towards(List<Executable> parameterExecutables) {
    super(parameterExecutables);
    targetX = parameterExecutables.get(0);
    targetY = parameterExecutables.get(1);
  }

  @Override
  public double execute(EnvironmentApi env) {
    double facingPosX = targetX.execute(env);
    double facingPosY = targetY.execute(env);

    if (facingPosX == env.getTurtle().getPosX() && facingPosY == env.getTurtle().getPosY()) {
      return 0;
    }

    double originalDirection = env.getTurtle().getDegreesDirection();

    double lengthX = facingPosX - env.getTurtle().getPosX();
    double lengthY = facingPosY - env.getTurtle().getPosY();

    double degreesOffSet = 0; //first quadrant (default value)
    if (lengthX < 0 && lengthY >= 0) { //second quadrant
      degreesOffSet = 90;
    } else if (lengthX < 0 && lengthY < 0) { //third
      degreesOffSet = 180;
    } else if (lengthX >= 0 && lengthY < 0) { //fourth
      degreesOffSet = 270;
    }

    double angleRadian = Math.atan(Math.abs(lengthX) / Math.abs(lengthY));
    env.getTurtle().setDirection(Math.toDegrees(angleRadian) + degreesOffSet);

    return Math.abs(originalDirection - env.getTurtle().getDegreesDirection());
  }
}
