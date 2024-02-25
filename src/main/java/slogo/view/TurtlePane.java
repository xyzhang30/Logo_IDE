package slogo.view;

import java.io.FileNotFoundException;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class TurtlePane extends CreatePane {

  TurtleView turtle;

  ImageView turtleImage;

  public TurtlePane(int height, int width, String cssClassName) throws FileNotFoundException {
    super(height, width, cssClassName);
    turtle = new TurtleView();
    root = new StackPane();
    turtleImage = new ImageView(turtle.getImage());
    turtleImage.setLayoutY(0);
    turtleImage.setLayoutX(0);
    turtleImage.setFitWidth(50);
    turtleImage.setFitHeight(50);
    turtleImage.setRotate(90);
    create();

  }

  @Override
  public void create() {
    root.getChildren().add(turtleImage);
  }
  public void update() {
    // turtleImage.setLayoutX(turtle.getxPosition());
    // turtleImage.setLayoutY(turtle.getyPosition());
  }
}
