package slogo.view;

import java.io.File;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.ParserApi;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.Executioner;
import slogo.model.command.executables.Executable;
import slogo.model.parser.TreeParser;
import slogo.model.turtle.TurtleModel;

public class Controller  {

  // how much to adjust updates per second
  public static final int SPEED_ADJUSTMENT = 1;

  private final IDEWindow i1;

  private final TurtleModelApi model;

  private Stage stage;

  // private final TurtleModel model;

  private final ExecutionerApi executioner;
  private ParserApi parser = new TreeParser();

  private State state;


  public Controller(Stage stage, Executioner executioner, String language) {
    this.executioner = executioner;
    state = State.STOPPED;
    this.model = this.executioner.getTurtleModel();
    i1 = new IDEWindow(stage, this, language);

  }

  public void update(double elapsedTime) {
    i1.updateTurtle();
  }

  public void start() throws Exception {
    i1.start(model);
  }

  public void run() {
    // System.out.println(i1.getText());
    try {
      if (state == State.STOPPED) {
        boolean end = false;
        String command = i1.getText();
        executioner.parseTree(new InputRecord(command));
        state = State.RUNNING;
        while (executioner.hasNext()) {
          if (i1.prevComplete()) {
            executioner.runNext();
            i1.updateTurtle();
          } else {
            continue;
          }
        }
      }
      state = State.STOPPED;
    }
    catch (RuntimeException e) {
//      i1.showError(e.getMessage());
      showMessage(AlertType.ERROR, e.getMessage());
    }
  }

  public void showMessage(AlertType type, String message) {
    Alert alert = new Alert(type, message);
    alert.initOwner(stage);
    alert.showAndWait();
  }

  public void step() {
    String command = i1.getText();
    try {
      if (state == State.STOPPED) {
        executioner.parseTree(new InputRecord(command));
        state = State.RUNNING;
        if (executioner.hasNext()) {
          executioner.runNext();
          i1.updateTurtle();
        }
      }
      while (!i1.prevComplete()) {
        // hold here while running
      }
      state = State.STOPPED;
    }
    catch (RuntimeException e) {
//      i1.showError(e.getMessage());
      showMessage(AlertType.ERROR, e.getMessage());
    }

    // ex.runNext();
  }

  public void pause() {
    if (state != State.STOPPED) {
      if (state == State.PAUSED) {
        state = State.RUNNING;
      } else {
        state = State.PAUSED;
      }
      i1.pause();
    }
  }

  public void help() {
    HelpWindow helpWindow = new HelpWindow();
    helpWindow.show(); // Display the help window
  }
  public void feedHistory() {

  }
  public void feedVariables() {

  }

  public void speedUp() {
    System.out.println(i1.getSpeed());
    i1.setSpeed(i1.getSpeed()+1);
  }

  public void slowDown() {
    if (i1.getSpeed()>1) {
      i1.setSpeed(i1.getSpeed()-1);
    }
  }

  public int getSpeed() {
    return i1.getSpeed();
  }

  public void changeColor(Color value) {
    i1.updateColor(value);
  }

  public void changeStylesheet(String stylesheet) {
    i1.setStylesheet(stylesheet);
  }

  public void changeBackgroundColor(Color value) {
    i1.updateBackground(value);
  }

  public void processSelectedPNGFile(File selectedFile) {
    i1.updateImage(selectedFile);
  }
}

