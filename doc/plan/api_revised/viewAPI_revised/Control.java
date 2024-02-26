package slogo.view;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;


public class ControlPane extends CreatePane implements Control {



  private final Controller controller;

  public ControlPane(int height, int width, String cssClassName, Controller controller, String language) {

  }

  @Override
  public void create() {
    addButtons();
  }

  public void addButtons() {}
  //button handler in controller and then pass in map of the button handlers into controlpane

  public void makeButton (String property, EventHandler<ActionEvent> handler) {  }
}
