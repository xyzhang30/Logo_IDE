package slogo.view;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextArea;

public class TextInputPane extends CreatePane implements TextInput {

  private final TextArea ta1 = new TextArea();

  private String text = "";

  public TextInputPane(int height, int width, String language) {
    super(height, width, language);
    setRoot(new Pane());
    create();
  }

  @Override
  public void create() {
    ta1.setPrefSize(getWidth(), getHeight());
    ta1.setId("TextInput");
    getRoot().getChildren().add(ta1);
    ta1.setPromptText("Code Here");
  }

  public String getTextInput() {
    // Set preferred size
    //System.out.println("Initial text content: " + textEditorContent);
    return ta1.getText();
  }
  public TextArea getTextArea() {
    return ta1;
  }
}
