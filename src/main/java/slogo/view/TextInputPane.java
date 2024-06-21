package slogo.view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 * Class that represents a pane for inputting and displaying text. Extends CreatePane for basic pane
 * configuration.
 */
public class TextInputPane extends CreatePane implements TextInput {

  private final TextArea codeInputArea = new TextArea();

  /**
   * Constructs a TextInputPane with specified dimensions and language.
   *
   * @param height   the height of the pane.
   * @param width    the width of the pane.
   * @param language the language setting for the pane.
   */
  public TextInputPane(int height, int width, String language) {
    super(height, width, language);
    setRoot(new Pane());
    create();
  }

  /**
   * Adds necessary components to the pane, including a TextArea for text input.
   */
  @Override
  public void create() {
    codeInputArea.setPrefSize(getWidth(), getHeight());
    codeInputArea.setId("TextInput");
    getRoot().getChildren().add(codeInputArea);
  }

  /**
   * Gets the text content from the TextArea.
   *
   * @return the text content of the TextInputPane.
   */
  public String getTextInput() {
    return codeInputArea.getText();
  }

  /**
   * Clears the text content of the TextArea.
   */
  public void clearText() {
    codeInputArea.clear();
  }

  /**
   * Gets the TextArea component for additional customization or access.
   *
   * @return the TextArea component used for text input.
   */
//  public TextArea getTextArea() {
//    return codeInputArea;
//  }

  public void setTextContent(String code){
    codeInputArea.setText(code);
  }

}
