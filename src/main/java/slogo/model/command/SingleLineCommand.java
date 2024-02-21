package slogo.model.command;

import slogo.model.turtle.TurtleModel;

public abstract class SingleLineCommand implements CommandLine {

  private TurtleModel turtle;

  public SingleLineCommand(TurtleModel turtle) {
    this.turtle = turtle;
  }

  public TurtleModel getTurtle() {
    return turtle;
  }
}
