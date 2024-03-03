package slogo.view;

import java.io.File;
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


  public Controller(Stage stage, Executioner executioner, String language, TurtleModel t1) {
    this.executioner = executioner;
    model = t1;
    // this.model = this.executioner.getModel();
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
    boolean end = false;
    String command = i1.getText();
    executioner.parseTree(new InputRecord(command));
    while (executioner.hasNext()) {
      if (i1.prevComplete()) {
        executioner.runNext();
      }
    }



//    executioner.parseTree(new InputRecord(command));
//    executioner.runNext(TurtleModelApi);
//
    // i1.updateTurtle();

  }

  public void step() {
    String command = i1.getText();
    Executable ex = parser.parseTree(new InputRecord(command));
    // ex.runNext();
  }

  public void pause() {
    i1.pause();
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

