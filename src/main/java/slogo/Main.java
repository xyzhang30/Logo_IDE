package slogo;

import javafx.application.Application;
import javafx.stage.Stage;
import slogo.model.turtle.TurtleModel;
import slogo.view.Controller;
import slogo.view.IDEWindow;

public class Main extends Application {

  Controller c1;
  @Override
  public void start(Stage primaryStage) throws Exception {
    TurtleModel model = new TurtleModel();
    c1 = new Controller(primaryStage, model);
    c1.start();

  }
}
