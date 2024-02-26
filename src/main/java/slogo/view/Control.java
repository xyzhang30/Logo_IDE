package slogo.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface Control {

  void addButtons();

  void makeButton (String property, EventHandler<ActionEvent> handler);
}
