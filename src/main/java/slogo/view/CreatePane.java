package slogo.view;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public abstract class CreatePane {


  protected final int height;
  protected final int width;

  protected Pane root;

  public CreatePane(int height, int width, String cssClassName) {
      this.height = height;
      this.width = width;
      root = new Pane();
      // this.root.getStyleClass().add(cssClassName);
  }

  protected Pane getRoot() {
    return root;
  }

  public abstract void create();


}
