package view;

public interface ViewInternal {
  /**
   * Returns the scene.
   * @return Group  the internally stored scene
   */
  public Group getScene();

  public void setTheme();

  public void setLanguage(String language);

  public void setColor(String color);

  public void makeButton(int x, int y);

  public void switchScene();

  public void runTurtle();

}