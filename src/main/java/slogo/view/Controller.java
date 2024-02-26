package slogo.view;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import slogo.model.turtle.TurtleModel;

public class Controller extends Application {

  // how much to adjust updates per second
  public static final int SPEED_ADJUSTMENT = 1;

  private IDEWindow i1;

  private Stage stage;

  private TurtleModel model;


  public Controller(TurtleModel model) {
    stage = new Stage();
    i1 = new IDEWindow(stage);
    this.model = model;
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    i1.start(model);
  }


  public void run() {
    //System.out.println(i1.getText());
    System.out.println(i1.getText());
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
}
