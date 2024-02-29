package slogo.view;

import javafx.stage.Stage;
import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.ParserApi;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.executables.Executable;
import slogo.model.parser.TreeParser;
import slogo.model.turtle.TurtleModel;

public class Controller  {

  // how much to adjust updates per second
  public static final int SPEED_ADJUSTMENT = 1;

  private final IDEWindow i1;

  private final TurtleModelApi model;

  private Stage stage;

  // private final TurtleModel model;

  ParserApi parser = new TreeParser();


  public Controller(Stage stage, TurtleModel model) {
    this.model = model;
    i1 = new IDEWindow(stage, this);
  }

  public void update(double elapsedTime) {
    i1.updateTurtle();
  }

  public void start() throws Exception {
//    i1.start(model);
  }

  public void run() {
    //System.out.println(i1.getText());

    // String command = i1.getText();

    // Executable ex = parser.parseTree(new InputRecord(command));
    // i1.updateTurtle();
//    i1.resume();
  }

  public void step() {
//    i1.pause();
  }

  public void pause() {
//    model.setDirection((int) (Math.random()*360.0));
//    model.setPosX((int) (Math.random()*400.0));
//    model.setPosY((int) (Math.random()*400.0));
//    i1.updateTurtle();
  }

  public void help() {
    //
    // i1.clearLine();
  }

  public void feedHistory() {

  }
  public void feedVariables() {

  }

  public void speedUp() {
    System.out.println(i1.getSpeed());
    i1.setSpeed(i1.getSpeed()+1);
  }

  public void slowDown() {
    if (i1.getSpeed()>1) {
      i1.setSpeed(i1.getSpeed()-1);
    }
  }

  public int getSpeed() {
    return i1.getSpeed();
  }
}
