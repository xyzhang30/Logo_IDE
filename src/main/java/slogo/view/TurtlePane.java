package slogo.view;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import slogo.model.turtle.TurtleModel;

public class TurtlePane extends CreatePane {



  ImageView turtleImage;
  private TurtleModel model;

  public TurtlePane(int height, int width, String cssClassName) throws FileNotFoundException {
    super(height, width, cssClassName);
    root = new StackPane();
    turtleImage = new ImageView(new Image(new File("src/main/resources/view/turtle1.png").toURI().toString()));;
    turtleImage.setLayoutY(0);
    turtleImage.setLayoutX(0);
    turtleImage.setFitWidth(50);
    turtleImage.setFitHeight(50);
    updateDirection();
    create();

  }

  private void updateDirection() {
    turtleImage.setRotate(model.getAttributes().direction());
  }

  @Override
  public void create() {
    root.getChildren().add(turtleImage);
  }
  public void update() {
     turtleImage.setLayoutX(turtle.getxPosition());
     turtleImage.setLayoutY(turtle.getyPosition());
  }
}
