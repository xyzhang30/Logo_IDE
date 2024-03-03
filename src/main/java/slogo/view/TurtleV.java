package slogo.view;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public interface TurtleV {

  ImageView getTurtleImage();

  void turtleUpdate(double x, double y, double direction, boolean visible);

  Pane getRoot();

  void updateImage(File selectedFile);
}
