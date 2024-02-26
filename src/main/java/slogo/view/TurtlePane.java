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
    turtleImage.setFitWidth(50);
    turtleImage.setFitHeight(50);
    update();
    create();
  }

  private void updateDirection() {
    turtleImage.setRotate(model.getAttributes().direction());
  }

  private void updateXCoordinate(){
    turtleImage.setLayoutX(model.getAttributes().xpos());
  }

  private void updateYCoordinate(){
    turtleImage.setLayoutX(model.getAttributes().ypos());
  }

  private void isVisible(){

  }

  @Override
  public void create() {
    root.getChildren().add(turtleImage);
  }
  public void update() {
    updateDirection();
    updateXCoordinate();
    updateYCoordinate();
  }
}
