package view;

public interface ViewInternal {
  /**
   * Returns the scene.
   * @return Group  the internally stored scene
   */
  Group getScene();

  setTheme();

  setLanguage(String language);

  setColor(String color);

  makeButton(int x, int y);

  switchScene();

}