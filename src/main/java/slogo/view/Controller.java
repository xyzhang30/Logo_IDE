package slogo.view;

import javafx.stage.Stage;
import slogo.model.api.InputRecord;
import slogo.model.api.ParserApi;
import slogo.model.api.TurtleModelApi;
import slogo.model.parser.TreeParser;

public class Controller  {

  // how much to adjust updates per second
  public static final int SPEED_ADJUSTMENT = 1;

  protected final IDEWindow i1;

  private final TurtleModelApi model;

  private Stage stage;

  // private final TurtleModel model;

  ParserApi parser = new TreeParser();


  public Controller(Stage stage, TurtleModelApi model) {
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
    //System.out.println(i1.getText());

    String command = i1.getText();
    parser.parseTree(new InputRecord(command));
    i1.updateTurtle();
  }

  public void step() {
    i1.updateTurtle();
  }

  public void pause() {
  }

  public void help() {
  }

  public void feedHistory() {

  }
  public void feedVariables() {

  }
}
