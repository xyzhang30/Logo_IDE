package slogo.view;

import javafx.scene.Node;

/**
 * The TextInput interface defines a method for retrieving text input from an implementing class.
 * Classes that implement this interface are expected to provide a way to access textual input.
 */
public interface TextInput {

  /**
   * Gets the text input from the implementing class.
   *
   * @return the text input.
   */
  String getTextInput();

  Node getRoot();

  void clearText();
}

