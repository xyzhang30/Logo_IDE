package slogo.model.command;

import slogo.model.turtle.TurtleModel;

public class Runner {

  public static void main(String[] args) {
    TurtleModel turt = new TurtleModel();
    turt.setDirection(135);
    Forward forward = new Forward(50, turt);
    forward.execute();
    System.out.println("new x : " + turt.getPosX());
    System.out.println("new y: " + turt.getPoxY());
  }

}
