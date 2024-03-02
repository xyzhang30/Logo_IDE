package slogo.view;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import slogo.model.api.ParserApi;
import slogo.model.parser.TreeParser;
import slogo.model.turtle.TurtleModel;

public class Controller  {

  // how much to adjust updates per second
  public static final int SPEED_ADJUSTMENT = 1;

  private final IDEWindow i1;

  private final TurtleModel model;

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
      i1.start(model);
  }

  public void run() {
    // System.out.println(i1.getText());

    // String command = i1.getText();

    // Executable ex = parser.parseTree(new InputRecord(command));
    // i1.updateTurtle();

  }

  public void step() {

  }

  public void pause() {

  }

  public void help() {

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

  public void changeColor(Color value) {
    i1.updateColor(value);
  }

  public void changeStylesheet(String stylesheet) {
    i1.setStylesheet(stylesheet);
  }
}
