package slogo.model.command;

import slogo.model.turtle.TurtleModel;

public abstract class SingleLineCommand implements CommandLineAPI {

  private TurtleModel turtle;

  public SingleLineCommand(TurtleModel turtle) {
    this.turtle = turtle;
  }

  public TurtleModel getTurtle() {
    return turtle;
  }
}
