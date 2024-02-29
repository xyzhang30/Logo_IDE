package slogo.view;

import java.util.ResourceBundle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public abstract class CreatePane {


  protected final int height;
  protected final int width;

  private ResourceBundle myResources;

  public static final String DEFAULT_RESOURCE_PACKAGE = "View.";
  public static final String DEFAULT_RESOURCE_FOLDER = "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");

  private String language;

  private Pane root;

  public CreatePane(int height, int width, String language) {
      this.height = height;
      this.width = width;
      root = new Pane();
      this.language = language;
      myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
  }

  public Pane getRoot() {
    return root;
  }

  public void setRoot(Pane root) {
    this.root = root;
  }

  public abstract void create();


  public ResourceBundle getMyResources() {
    return myResources;
  }

  public void setMyResources(ResourceBundle myResources) {
    this.myResources = myResources;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }
}
