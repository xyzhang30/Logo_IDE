package slogo.view;

import java.util.ResourceBundle;
import javafx.scene.layout.Pane;

/**
 * Simple class to act as parent of pane classes.
 */
public abstract class CreatePane {


  public static final String DEFAULT_RESOURCE_PACKAGE = "View.";
  public static final String DEFAULT_RESOURCE_FOLDER =
      "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");
  private final int height;
  private final int width;
  private ResourceBundle myResources;
  private String language;

  private Pane root;

  /**
   * Constructor
   *
   * @param height   = height of pane
   * @param width    = width of pane
   * @param language = language to be used if necessary
   */
  public CreatePane(int height, int width, String language) {
    this.height = height;
    this.width = width;
    root = new Pane();
    this.language = language;
    System.out.println(DEFAULT_RESOURCE_PACKAGE + language);
    myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
  }

  /**
   * @return the root/pane
   */
  public Pane getRoot() {
    return root;
  }

  /**
   * @param root = updates root to new pane
   */
  public void setRoot(Pane root) {
    this.root = root;
  }

  /**
   * Adds necessary
   */
  public abstract void create();

  /**
   * Simple getter
   *
   * @return myResourceBundle
   */
  public ResourceBundle getMyResources() {
    return myResources;
  }

  /**
   * Simple setter
   *
   * @param myResources = new ResourceBundle
   */
  public void setMyResources(ResourceBundle myResources) {
    this.myResources = myResources;
  }

  /**
   * gets language of the ide
   *
   * @return language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * sets new language
   *
   * @param language = update new language
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * gets the height of the pane
   *
   * @return height of pane
   */
  public int getHeight() {
    return height;
  }

  /**
   * get the width of the pane
   *
   * @return width of pane
   */
  public int getWidth() {
    return width;
  }
}
