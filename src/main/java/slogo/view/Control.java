package slogo.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface Control {
  /**
   * Control interface defines methods for adding buttons and creating buttons with event handlers.
   */


  void addButtons();

  void makeButton (String property, EventHandler<ActionEvent> handler);
}
