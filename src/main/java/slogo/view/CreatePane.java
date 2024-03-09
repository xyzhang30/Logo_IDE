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
   * Constructor.
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
   * Gets the root.
   *
   * @return the root/pane
   */
  public Pane getRoot() {
    return root;
  }

  /**
   * Sets the root.
   *
   * @param root = updates root to new pane
   */
  public void setRoot(Pane root) {
    this.root = root;
  }

  /**
   * Adds necessary.
   */
  public abstract void create();

  /**
   * Simple getter.
   *
   * @return myResourceBundle
   */
  public ResourceBundle getMyResources() {
    return myResources;
  }

  /**
   * Simple setter.
   *
   * @param myResources = new ResourceBundle
   */
  public void setMyResources(ResourceBundle myResources) {
    this.myResources = myResources;
  }

  /**
   * gets language of the ide.
   *
   * @return language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * <<<<<<< HEAD sets new language ======= sets new language. >>>>>>>
   * e814b9c08fa88e0eaa187f7bc81026c74f301ada
   *
   * @param language = update new language
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * <<<<<<< HEAD gets the height of the pane ======= gets the height of the pane. >>>>>>>
   * e814b9c08fa88e0eaa187f7bc81026c74f301ada
   *
   * @return height of pane
   */
  public int getHeight() {
    return height;
  }

  /**
   * <<<<<<< HEAD get the width of the pane ======= get the width of the pane. >>>>>>>
   * e814b9c08fa88e0eaa187f7bc81026c74f301ada
   *
   * @return width of pane
   */
  public int getWidth() {
    return width;
  }
}
