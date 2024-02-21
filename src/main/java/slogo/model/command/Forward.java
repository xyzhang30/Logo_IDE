package slogo.model.command;

import slogo.model.turtle.TurtleModel;

public class Forward extends SingleLineCommand{

  private int distance;

  public Forward(int distance, TurtleModel turtle){
    super(turtle);
    this.distance = distance;
  }

  @Override
  public double execute() {
    double distX = distance * Math.cos(getTurtle().getDirection());
    double distY = distance * Math.sin(getTurtle().getDirection());

    getTurtle().setPosX(getTurtle().getPosX()+distX);
    getTurtle().setPosY(getTurtle().getPoxY()+distY);

    return 0;
  }

}
