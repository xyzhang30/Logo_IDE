package slogo.view;

import java.io.File;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.ModelFactory;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.CommandHistory;

/**
 * Controller class that manages the interaction between the graphical user interface (GUI)
 * and the underlying model and execution logic.
 */
public class Controller  {

  // how much to adjust updates per second
  public static final int SPEED_ADJUSTMENT = 1;

  private final IDEWindow i1;

  private final TurtleModelApi model;

  private Stage stage;

  // private final TurtleModel model;

  private final ExecutionerApi executioner;

  private State state;

  private String language;

  private boolean stepping;
  private CommandHistory cmdHistory;
  private CommandHistoryPane cmdHistoryPane;
  private UserDefPane userPane;


  /**
   * Constructs a Controller with the specified stage, executioner, and language.
   *
   * @param stage      the primary stage for the application.
   * @param executioner the executioner responsible for interpreting and executing commands.
   * @param language   the initial language setting.
   */
  public Controller(Stage stage, ExecutionerApi executioner, String language) {
    stepping = false;
    this.executioner = executioner;
    state = State.STOPPED;
    this.model = this.executioner.getTurtleModel();
    this.language = language;
    i1 = new IDEWindow(stage, this, language);
    cmdHistory = new CommandHistory();
  }

  /**
   * Starts the application.
   *
   * @throws Exception if an exception occurs during the application start.
   */
  public void start() throws Exception {
    i1.start(model);
  }

  /**
   * Runs the specified command(s).
   */
  public void run() {
    setUpRun();
    cmdHistory = executioner.getHistory();
//    cmdHistory.saveCurrent();
    feedHistory(executioner.getHistory().getCommands());
    feedVariables();
  }

  /**
   * Shows a message dialog with the specified type and message.
   *
   * @param type    the type of the alert.
   * @param message the message to be displayed.
   */
  public void showMessage(AlertType type, String message) {
    Alert alert = new Alert(type, message);
    alert.initOwner(stage);
    alert.showAndWait();
  }

  /**
   * Initiates a single step of command execution.
   */
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

  /**
   * Pauses or resumes the execution of commands.
   */
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

  /**
   * Displays the help window.
   */
  public void help() {
    HelpWindow helpWindow = new HelpWindow();
    helpWindow.show(); // Display the help window
  }

  /**
   * Feeds the command history to the CommandHistoryPane.
   *
   * @param commands the string representation of the command history.
   */
  public void feedHistory(String commands) {
//    cmdHistoryPane = new CommandHistoryPane(200, 50, language);
    i1.getHistoryPane().addCommand(commands);
  }

  /**
   * Feeds the variables to the UserDefPane for display.
   */
  public void feedVariables() {
    userPane = new UserDefPane(200, 50, language);
    userPane.updateDisplay();
  }

  /**
   * Increases the execution speed.
   */
  public void speedUp() {
    System.out.println(i1.getSpeed());
    i1.setSpeed(i1.getSpeed()+SPEED_ADJUSTMENT);
  }

  /**
   * Decreases the execution speed.
   */
  public void slowDown() {
    if (i1.getSpeed()>SPEED_ADJUSTMENT) {
      i1.setSpeed(i1.getSpeed()-SPEED_ADJUSTMENT);
    }
  }

  /**
   * Gets the current execution speed.
   *
   * @return the current execution speed.
   */
  public int getSpeed() {
    return i1.getSpeed();
  }

  /**
   * Changes the color of the lines.
   *
   * @param value the new color value.
   */
  public void changeColor(Color value) {
    i1.updateColor(value);
  }

  /**
   * Changes the stylesheet for the IDEWindow.
   *
   * @param stylesheet the name of the new stylesheet.
   */
  public void changeStylesheet(String stylesheet) {
    i1.setStylesheet(stylesheet);
  }

  /**
   * Changes the background color of the IDEWindow.
   *
   * @param value the new background color value.
   */
  public void changeBackgroundColor(Color value) {
    i1.updateBackground(value);
  }

  /**
   * Processes the selected PNG file and updates the IDEWindow.
   *
   * @param selectedFile the selected PNG file.
   */
  public void processSelectedPNGFile(File selectedFile) {
    i1.updateImage(selectedFile);
  }

  /**
   * Gets the instance of the IDEWindow associated with this controller.
   *
   * @return the IDEWindow instance.
   */
  public IDEWindow getIDEWindow() { return i1;
  }

  /**
   * Gets the text content from the IDEWindow.
   *
   * @return the text content.
   */
  public String getText() {
    return i1.getText();
  }

  /**
   * Clears the text content of the IDEWindow.
   */
  public void clearText() {
    i1.clearText();
  }

  /**
   * Initiates the execution of the next command or step.
   */
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

  /**
   * Creates a new instance of the application with a new Controller.
   *
   * @throws Exception if an exception occurs during the creation of the new instance.
   */
  public void newInstance() throws Exception {
    ModelFactory modelFactory = new ModelFactory();
    Controller c2 = new Controller(new Stage(), modelFactory.createExecutioner(), language);
    c2.start();
  }

  /**
   * Gets the current state of the application (e.g., RUNNING, PAUSED, STOPPED).
   *
   * @return the current state of the application.
   */
  public State getState() {
    return state;
  }

  /**
   * Gets the TurtleModelApi associated with the Controller.
   *
   * @return the TurtleModelApi instance.
   */
  public TurtleModelApi getModel() {
    return model;
  }
}


