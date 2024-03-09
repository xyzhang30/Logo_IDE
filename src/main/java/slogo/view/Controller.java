package slogo.view;

import java.io.File;
import java.util.Map;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slogo.model.api.ExecutionerApi;
import slogo.model.api.InputRecord;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.CommandHistory;

/**
 * Controller class that manages the interaction between the graphical user interface (GUI) and the
 * underlying model and execution logic.
 */
public class Controller {

  // how much to adjust updates per second
  public static final int SPEED_ADJUSTMENT = 1;

  public static final int KEY_MOVE_AMOUNT = 50;
  private static Controller instance;
  private final IDEWindow ide;
  private final Map<Double, TurtleModelApi> model;

  // private final TurtleModel model;
  private final ExecutionerApi executioner;
  private Stage stage;
  private State state;
  private final String language;
  private boolean stepping;
  private CommandHistory cmdHistory;
  private CommandHistoryPane cmdHistoryPane;
  private UserDefPane userPane;
  private final HelpWindow helpWindow;


  /**
   * Constructs a Controller with the specified stage, executioner, and language.
   *
   * @param stage       the primary stage for the application.
   * @param executioner the executioner responsible for interpreting and executing commands.
   * @param language    the initial language setting.
   */
  public Controller(Stage stage, ExecutionerApi executioner, String language) {
    stepping = false;
    this.executioner = executioner;
    state = State.STOPPED;
    model = this.executioner.getTurtleModels();
    this.language = language;
    ide = new IDEWindow(stage, this, language);
    cmdHistory = new CommandHistory();
    instance = this;
    helpWindow = new HelpWindow(language);
  }

  /**
   * Retrieves the singleton instance of the Controller class.
   *
   * @return the singleton instance of the Controller class.
   */
  public static Controller getInstance() {
    return instance;
  }

  /**
   * Starts the application.
   */
  public void start() {
    ide.start(model);
  }

  /**
   * Runs the specified command(s).
   */
  public void run() {
    setUpRun();
    updateHistory();
  }

  private void updateHistory() {
    cmdHistory = executioner.getHistory();
    feedHistory(executioner.getHistory().getCommands());
    feedVariables();
  }


  /**
   * Shows a message dialog with the specified type and message.
   *
   * @param message the message to be displayed.
   */
  public void showMessage(String message) {
    ide.showError(message);
  }

  /**
   * Initiates a single step of command execution.
   */
  public void step() {
    stepping = true;
    setUpRun();
    updateHistory();
  }

  private void setUpRun() {
    String command = ide.getText();
    setUpRunInternal(command);
  }


  /**
   * Runs the specified command from command history and updates the history.
   *
   * @param command the command to be executed.
   */
  public void runCmdHist(String command) {
    setUpRunInternal(command);
    updateHistory();
  }

  /**
   * Executes the specified command for help purposes and updates the history.
   *
   * @param command the command for which help is requested.
   */
  public void runHelp(String command) {
    //String command = helpWindow.getTextArea();
    System.out.println("in run help " + command);
    setUpRunInternal(command);
    updateHistory();
  }


  /**
   * Sets up the internal state to execute the specified command.
   * If the application is in a stopped state, it parses the command, executes it,
   * and clears the text. If an exception occurs during execution, the application is stopped,
   * and an error message is displayed.
   *
   * @param command the command to be executed.
   */
  private void setUpRunInternal(String command) {
    try {
      if (state == State.STOPPED) {
        if (command != null && !command.equals("")) {
          System.out.println("calling parse tree");
          executioner.parseTree(new InputRecord(command));
        }
        runFirst();
        clearText();
      }
    } catch (RuntimeException e) {
      state = State.STOPPED;
      e.printStackTrace();
      showMessage(e.getMessage());
    }
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
      ide.pause();
    }
  }

  /**
   * Displays the help window.
   */
  public void help() {
    HelpWindow helpWindow = new HelpWindow(language);
    helpWindow.show(); // Display the help window
  }

  /**
   * Feeds the command history to the CommandHistoryPane.
   *
   * @param commands the string representation of the command history.
   */
  public void feedHistory(String commands) {
//    cmdHistoryPane = new CommandHistoryPane(200, 50, language);

    ide.getHistoryPane().addCommand(commands);
  }

  /**
   * Feeds the variables to the UserDefPane for display.
   */
  public void feedVariables() {
    userPane = ide.getUserPane();
    System.out.println("feed variables called");
    userPane.updateDisplay();
  }

  /**
   * Increases the execution speed.
   */
  public void speedUp() {
    System.out.println(ide.getSpeed());
    ide.setSpeed(ide.getSpeed() + SPEED_ADJUSTMENT);
  }

  /**
   * Decreases the execution speed.
   */
  public void slowDown() {
    if (ide.getSpeed() > SPEED_ADJUSTMENT) {
      ide.setSpeed(ide.getSpeed() - SPEED_ADJUSTMENT);
    }
  }

  /**
   * Gets the current execution speed.
   *
   * @return the current execution speed.
   */
  public int getSpeed() {
    return ide.getSpeed();
  }

  /**
   * Changes the color of the lines.
   *
   * @param value the new color value.
   */
  public void changeColor(Color value) {
    ide.updateColor(value);
  }

  /**
   * Changes the stylesheet for the IDEWindow.
   *
   * @param stylesheet the name of the new stylesheet.
   */
  public void changeStylesheet(String stylesheet) {
    ide.setStylesheet(stylesheet);
  }

  /**
   * Changes the background color of the IDEWindow.
   *
   * @param value the new background color value.
   */
  public void changeBackgroundColor(Color value) {
    ide.updateBackground(value);
  }

  /**
   * Processes the selected PNG file and updates the IDEWindow.
   *
   * @param selectedFilePath the selected PNG file name.
   */
  public void processNewImage(String selectedFilePath) {
    ide.updateImage(selectedFilePath);
  }

  /**
   * Gets the text content from the IDEWindow.
   *
   * @return the text content.
   */
  public String getText() {
    return ide.getText();
  }

  /**
   * Clears the text content of the IDEWindow.
   */
  public void clearText() {
    ide.clearText();
  }

  /**
   * Initiates the execution of the next command or step.
   */
  public void runNext() {
    if (!stepping) {
      runFirst();
    } else {
      state = State.STOPPED;
      stepping = false;
    }
  }

  private void runFirst() {
    if (executioner.hasNext()) {
      state = State.RUNNING;
      executioner.runNext();
      ide.updateTurtle();
    } else {
      state = State.STOPPED;
    }
  }

  /**
   * Creates a new instance of the application with a new Controller.
   */
  public void newApplication() {
    ModelGenerator modelFactory = new ModelGenerator();
    Controller c2 = new Controller(new Stage(), modelFactory.createExecutioner(), language);
    c2.start();
  }


  /**
   * Displays a file chooser dialog for saving the current state of the program to a file.
   * If a file is selected, it retrieves the file name and path, and passes them to the executioner for saving.
   */
  public void save() {
    FileChooser fileChooser = new FileChooser();

    // Set initial directory if needed
    fileChooser.setInitialDirectory(new File("data/"));

    // Set extension filter to only allow .slogo files
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SLogo files (*.slogo)",
        "*.slogo");
    fileChooser.getExtensionFilters().add(extFilter);

    // Show save file dialog
    Stage stage = new Stage();
    stage.setTitle("Save SLogo File");
    File selectedFile = fileChooser.showSaveDialog(stage);

    // Process the selected file
    if (selectedFile != null) {
      // Pass the file name and path to the executioner for saving
      String fileName = selectedFile.getName();
      String folderPath = selectedFile.getParent();
      System.out.println("filepath: " + folderPath);
      executioner.saveFile(fileName, folderPath);
    }
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
  public Map<Double, TurtleModelApi> getModel() {
    return model;
  }

  /**
   * Moves the turtle forward by a distance of 50 units. This corresponds to the "fd 50" command in
   * the turtle graphics language.
   */
  public void up() {
    setUpRunInternal("fd " + KEY_MOVE_AMOUNT);
  }

  /**
   * Moves the turtle backward by a distance of 50 units. This corresponds to the "fd -50" command
   * in the turtle graphics language.
   */
  public void down() {
    setUpRunInternal("bk " + KEY_MOVE_AMOUNT);
  }

  /**
   * Turns the turtle left by 90 degrees and then moves it forward by a distance of 50 units. This
   * corresponds to the "lt 90\nfd 50" commands in the turtle graphics language.
   */
  public void left() {
    setUpRunInternal("lt 90\nfd " + KEY_MOVE_AMOUNT);
  }

  /**
   * Turns the turtle right by 90 degrees and then moves it forward by a distance of 50 units. This
   * corresponds to the "rt 90\nfd 50" commands in the turtle graphics language.
   */
  public void right() {
    setUpRunInternal("rt 90\nfd " + KEY_MOVE_AMOUNT);
  }

  public IDEWindow getIde() {
    return ide;
  }

  public ExecutionerApi getExecutioner() {
    return executioner;
  }
}
