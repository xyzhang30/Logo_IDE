package slogo.view;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import slogo.model.api.ParserApi;
import slogo.model.turtle.TurtleModel;
import slogo.model.xmlparser.CommandXmlParser;

public class Controller  {

  // how much to adjust updates per second
  public static final int SPEED_ADJUSTMENT = 1;

  protected final IDEWindow i1;

  private final TurtleModel model;

  private Stage stage;

  // private final TurtleModel model;

  ParserApi parser = new TreeParser();


  public Controller(Stage stage, TurtleModel model) {
    this.model = model;
    i1 = new IDEWindow(stage, this);
  }

  public void start() throws Exception {
    i1.start(model);
  }

  public void run() {
    //System.out.println(i1.getText());

    String command = i1.getText();
    parser.parseTree(command);
    i1.updateTurtle();
  }

  public void step() {
    int direction = (int) (Math.random()*360.0);
    model.setDirection(direction);
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
