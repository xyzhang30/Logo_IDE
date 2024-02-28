package slogo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import slogo.model.turtle.TurtleModel;
import slogo.view.Controller;

public class Main extends Application {

  Controller c1;

  public static final int FRAMES_PER_SECOND = 60;
  public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;

  private void step(double elapsedTime) {
    // c1.update(elapsedTime);

  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    TurtleModel model = new TurtleModel();
    c1 = new Controller(primaryStage, model);
    c1.start();
    Timeline animation = new Timeline();
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.getKeyFrames()
        .add(new KeyFrame(Duration.seconds(SECOND_DELAY), e -> step(SECOND_DELAY)));
    animation.play();

  }


}
