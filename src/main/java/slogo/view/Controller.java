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
import slogo.model.command.CommandHistory;
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

  private String language;

  private boolean stepping;
  private CommandHistory cmdHistory;
  private CommandHistoryPane cmdHistoryPane;
  private UserDefPane userPane;

  //private String language;



  public Controller(Stage stage, Executioner executioner, String language) {
    stepping = false;
    this.executioner = executioner;
    state = State.STOPPED;
    this.model = this.executioner.getTurtleModel();
    this.language = language;
    i1 = new IDEWindow(stage, this, language);
    cmdHistory = new CommandHistory();
  }

  public void update(double elapsedTime) {
    i1.updateTurtle();
  }

  public void start() throws Exception {
    i1.start(model);
  }

  public void run() {
    setUpRun();
    cmdHistory = executioner.getHistory();
//    cmdHistory.saveCurrent();
    feedHistory(executioner.getHistory().getCommands());
    feedVariables();
  }

  public void showMessage(AlertType type, String message) {
    Alert alert = new Alert(type, message);
    alert.initOwner(stage);
    alert.showAndWait();
  }

  public void step() {
    stepping = true;
    setUpRun();
  }

  private void setUpRun() {
    String command = i1.getText();
    try {
      if (state == State.STOPPED) {
        if (command != null && !command.equals("")) {
          System.out.println("calling parse tree");
          executioner.parseTree(new InputRecord(command));
        }
        runFirst();
      }
    } catch (RuntimeException e) {
      state = State.STOPPED;
      e.printStackTrace();
      showMessage(AlertType.ERROR, e.getMessage());
    }
    clearText();
  }

  public void pause() {
    System.out.println(state.toString());
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
  public void feedHistory(String commands) {
//    cmdHistoryPane = new CommandHistoryPane(200, 50, language);
    i1.getHistoryPane().addCommand(commands);
  }
  public void feedVariables() {
    userPane = new UserDefPane(200, 50, language);
    userPane.updateDisplay();
  }

  public void speedUp() {
    System.out.println(i1.getSpeed());
    i1.setSpeed(i1.getSpeed()+SPEED_ADJUSTMENT);
  }

  public void slowDown() {
    if (i1.getSpeed()>SPEED_ADJUSTMENT) {
      i1.setSpeed(i1.getSpeed()-SPEED_ADJUSTMENT);
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

  public IDEWindow getIDEWindow() { return i1;
  }

  public String getText() {
    return i1.getText();
  }

  public void clearText() {
    i1.clearText();
  }

  public void runNext() {
    if (!stepping) {
      runFirst();
    }
    else {
      state = State.STOPPED;
      stepping = false;
    }
  }
  private void runFirst() {
    if (executioner.hasNext()) {
      state = State.RUNNING;
      executioner.runNext();
      i1.updateTurtle();
    } else {
      state = State.STOPPED;
    }
  }

  public void newInstance() throws Exception {
    Controller c2 = new Controller(new Stage(), new Executioner(), language);
    c2.start();
  }

  public State getState() {
    return state;
  }

  public TurtleModelApi getModel() {
    return model;
  }
}


