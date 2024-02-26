package slogo.view;

import java.util.ResourceBundle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public abstract class CreatePane {


  protected final int height;
  protected final int width;

  protected ResourceBundle myResources;

  public static final String DEFAULT_RESOURCE_PACKAGE = "View.";
  public static final String DEFAULT_RESOURCE_FOLDER = "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");

  protected final String cssClassName;

  protected String language;

  protected Pane root;

  public CreatePane(int height, int width, String cssClassName, String language) {
      this.height = height;
      this.width = width;
      root = new Pane();
      this.cssClassName = cssClassName;
      this.language = language;
      myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
      this.root.getStyleClass().add(cssClassName);
  }

  protected Pane getRoot() {
    return root;
  }

  public abstract void create();


}
