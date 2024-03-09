package slogo.view;

import javafx.scene.Node;

/**
 * The {@code TextInput} interface defines methods for retrieving and manipulating text input from
 * an implementing class. Classes that implement this interface are expected to provide a way to
 * access, clear, and manage textual input.
 */
public interface TextInput {

  /**
   * Gets the text input from the implementing class.
   *
   * @return The text input.
   */
  String getTextInput();

  /**
   * Gets the root node associated with the implementing class.
   *
   * @return The root node.
   */
  Node getRoot();

  /**
   * Clears the text input in the implementing class, if applicable.
   */
  void clearText();
}


