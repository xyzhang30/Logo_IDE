# Use Cases

### User Types three lines of code and clicks run
  * Each line is passed to the commandParser
  * commandParser interprets each line and adds it to history structure
```java
class commandParser extends Parser {
  private List<commandLine> commands;
  public void interpretText(String s){
    for (String i : s.split("\n")){
      try{
        //interpret command into commandLine
      }
      except{
        //handle exception
      }
      commands.addCommand(i);
    }
  }
  public void addCommand(){
    commands.push_back(i);
  }
}
```

### User clicks on the help screen
  * Help button is bound to event handler for helpscreen.
  * Alternatively, bind the dialogue to a mouseOver event popup dialogue.
```java
public void createHelpButton(EventHandler<ActionEvent> e){
  helpButton.setOnActionEvent(e);
}
```

### Program Starts Running
  * When run is clicked, controller begins the run sequence
  * commandParser is ordered to execute commands from top
```java
class commandParser extends Parser {
  private List<commandLine> commands;
  private commandLine currentCommand;
  public void executeStep(){
    currentCommand.execute();
    currentCommand = nextCommand();
  }
}
```

### A for loop is run
  * The command is given to the command parser
  * The commandParser recognizes that this is a multiple line command and creates a forLoop object of
  the MultipleLineAbstractClass which implements the Command Interface
  * This class will then execute the lines within the for loop until it is finished
```java
public class ForLoop extends MultipleLine {
  private List<String> lines;
  int start;
  int end;
  int increment;
  
  public ForLoop (List<String> lines, int start, int end, int increment) {
    this.lines = lines;
    this.start = start;
    this.end = end;
    this.increment = increment;
  }
  
  @Override
  public void execute() {
    for (int i = start; i<=end; i = i + increment) {
      for (int j = 0; j<lines.size(); j++) {
        // create singleLine Command
        // other option would be for this class to simply have a pointer at the end of the for
        // loop and the end and then move point back to the start if the condition is still true
    }
  }
  
}

```
### The simulation speed is increased 
* The Controller will understand the simulation speed increase button has been pressed
* It will then change the updateSpeed 
* This will change how often the controller calls view.update();
```java
public void handleSpeedUpSimulationButtonPress() {
    try {
      simulationSpeed = simulationSpeed + SPEED_ADJUSTMENT;
    } catch (Exception e) {
      View.showError(e.getMessage());
    }
  }
public void update(double elapsedTime) {
  lastUpdateTime += elapsedTime;
  if (!isPaused) {
    if (lastUpdateTime >= 1.0 / simulationSpeed) {
      view.update();
      lastUpdateTime = 0;
    }
  }
}
```
### User accessed command history view
  * View History Button is clicked
  * Controller understands a button has been clicked
  * Tells view to switch scene
  * Controller gives the view a list of all previous commands

```java
public void handleHistoryView() {
  try {
  view.setHistoryScene(HistoryRecord);
  } catch (Exception e) {
    View.showError(e.getMessage());
  }
}
```

### File loaded to Slogo
```java
//Controller
private void onLoadNewFileClicked(){
  try {
    animationRunning = false;
    File dataFile = chooseFile();
    if (dataFile == null) {
      return;
    }
    String codeText = readFile(dataFile);
    commandParser.parseInput(codeText);
    setSimulation();
  } catch (InvalidFileFormatException e) {
    showMessage(AlertType.ERROR, e.getMessage());
  }
}
```

### User clicks to step through animation one at a time
```java
public class Controller {
  private CommandParser commandParser;
  private SceneManager sceneManager;
  
  private void onStepClicked(){
    step();
  }
  
  private void step() {
    commandParser.executeCurrentLine(); 
    commandParser.setCurrentLine(commandParser.getCurrentLine()+1);
    sceneManager.runTurtle();
    sceneManager.pauseAnimation();
  }
}

```

### User clicks run while the animation is still playing (will show error message)
```java
public void toggleRun() {
  if (animationRunning) { //button is click when animation is running (the button should be pause at this moment)
    runPauseButon.setText("Run"); //button changed to run and animation is paused
    animation.pause();
  } else { //vice versa
    runPauseButon.setText("Pause");
    animation.start();
  }
}
```

### Turtle Moves Out of Bounds:
  * Description: When the user commands the turtle to move, the system should prevent the turtle from moving beyond the defined bounds of the canvas. 
  * Steps:
    1. User issues a command to move the turtle. 
    2. The system calculates the new position of the turtle after the move. 
    3. If the new position exceeds the boundaries of the canvas, the system prevents the turtle from moving further. 
    4. Example: User commands the turtle to move forward by 100 pixels when the canvas size is 500x500, and the turtle is currently positioned at (490, 490). 
    5. Expected Outcome: Turtle moves forward by 10 pixels to reach the boundary (500, 500) but stops further as it cannot move out of bounds.
  * Java:
```java
public class TurtleModel {
  private int x;
  private int y;
  private final int canvasWidth;
  private final int canvasHeight;

  public TurtleModel(int canvasWidth, int canvasHeight) {
    this.canvasWidth = canvasWidth;
    this.canvasHeight = canvasHeight;
    this.x = canvasWidth / 2; // Starting at the center
    this.y = canvasHeight / 2;
  }

  public void moveForward(int distance) {
    int newX = this.x + distance;
    int newY = this.y;

    // Check if new position is within bounds
    if (newX >= 0 && newX <= canvasWidth) {
      this.x = newX;
    } else {
      // Stop turtle at boundary
      System.out.println("Turtle stopped at the boundary.");
    }
  }
}
 ```

### User Changes from Light Mode to Dark Mode:
  * Description: The user has the option to switch between light and dark modes for the Integrated Development Environment (IDE). 
    * Steps:
    1. User interacts with a UI control (button or menu) to change the mode. 
    2. The system updates the appearance of the IDE according to the selected mode. 
    3. Example: User clicks on a "Dark Mode" button in the settings menu. 
    4. Expected Outcome: The IDE interface switches its color scheme to dark mode, updating the background, text, and other elements accordingly.
```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SceneManager extends Application {
  @Override
  public void start(Stage primaryStage) {
    Button switchButton = new Button("Switch Theme");
    switchButton.setOnAction(e -> switchTheme(primaryStage));

    StackPane root = new StackPane();
    root.getChildren().add(switchButton);

    Scene scene = new Scene(root, 300, 250);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void switchTheme(Stage stage) {
    Scene scene = stage.getScene();
    if (scene.getStylesheets().contains("light_mode.css")) {
      scene.getStylesheets().remove("light_mode.css");
      scene.getStylesheets().add("dark_mode.css");
    } else {
      scene.getStylesheets().remove("dark_mode.css");
      scene.getStylesheets().add("light_mode.css");
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
```

### User Runs When There Is No Code:
  * Description: If the user attempts to run the program without providing any code, the system should handle this scenario gracefully. 
    * Steps:
    1. User clicks on the "Run" button or issues a command to execute the code. 
    2. The system checks if there is any code available for execution. 
    3. If no code is present, the system does nothing or provides a notification to the user. 
    4. Example: User clicks on the "Run" button without typing any commands in the code editor. 
    5. Expected Outcome: The system may display a message like "No code to execute" or simply ignore the run command without any action.
  * Java:
```java
public class Controller {
  public static void executeCode(String code) {
    if (code.isEmpty()) {
      // Display a message or take no action if code is empty
      System.out.println("No code to execute");
    } else {
      // Execute the code
      System.out.println("Executing code: " + code);
    }
  }
}

 ```

### Error 1: invalid "keyword"
  * An a command that doesn't correspond to a valid keyword throws an exception in CommandParser
```java
public void readCommand() {
  try {
    // call model to grab command
    command = commandsList.get(token);
  }
  catch(InvalidKeywordException e){
    showError(e.getMessage());
    throw new InvalidKeywordException(e,e.getMessage());
  }
}
```

### Error 2: invalid syntax (line spacing incorrect)
  * Within CommandParser
```java
public void readCommand() {
  try {
  // call model to generate command
  }
  catch(InvalidLineSpacingException e) {
    showError(e.getMessage());
    throw new InvalidLineSpacingException(e, e.getMessage());
  }

}


```
### Error 3: invalid number of parameters (single-line command)
```java
//inside the specific command class
public class CommandName extends singleLineCommand {
  private int numParamsExpected = 2; //2 just for example
  public double execute(){ //inherited from the commandLineInternal 
    try {
      //command logic here
    } catch (IndexOutOfBoundsException e) {
      String errorMessage = "Command" + commandName + "only takes in" + numParamsExpected + "parameter(s)";
      throw new InvalidParameterNumberException(errorMessage, e);
    }
  }
}

//in views (probably controller, when calling the model to execute the command)
private void readCommand(String commandInput){ //parameter might be changed after we go over reflection in class
  try {
    //call the model with the command input
  } catch (InvalidParameterNumberException e){
    showMessage(AlertType.ERROR, e.getMessage());
  }
}
```


### Error 4: Invalid Syntax (Mismatched Parentheses):
  * Description: If the user enters a command with mismatched parentheses, the system should detect this syntax error and provide feedback to the user.
  * Steps:
    1. User enters a command containing parentheses.
    2. The system parses the command and checks for matching parentheses.
    3. If mismatched parentheses are detected, the system displays an error message indicating the invalid syntax.
    4. Example: User enters the command "repeat 5 [ forward 50 ])" where there is an extra closing parenthesis.
    5. Expected Outcome: System displays an error message like "Error 4: Invalid Syntax - Mismatched Parentheses."
  * Java:
```java
public class XMLParser {
  int countOpen = 0;
  int countClose = 0;
        for (char c : command.toCharArray()) {
    if (c == '(') {
      countOpen++;
    } else if (c == ')') {
      countClose++;
      if (countClose > countOpen) {
        return false; // Mismatched parentheses detected
      }
    }
  }
        return countOpen == countClose; // True if parentheses match, false otherwise
}
 ```

[//]: # (Kevin: err 1, 1st 3)
[//]: # (Spencer: err 2, 2nd 3)
[//]: # (Alisha: err 3, 3rd 3)
[//]: # (Doga: error 4, last 3)