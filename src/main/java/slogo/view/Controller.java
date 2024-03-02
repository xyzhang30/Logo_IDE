package slogo.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import slogo.model.api.ParserApi;
import slogo.model.parser.TreeParser;
import slogo.model.turtle.TurtleModel;
import javafx.scene.layout.BorderPane;

public class Controller  {

  // how much to adjust updates per second
  public static final int SPEED_ADJUSTMENT = 1;

  private final IDEWindow i1;

  private final TurtleModel model;

  private Stage stage;

  // private final TurtleModel model;

  ParserApi parser = new TreeParser();


  public Controller(Stage stage, TurtleModel model) {
    this.model = model;
    i1 = new IDEWindow(stage, this);
  }

  public void update(double elapsedTime) {
    i1.updateTurtle();
  }

  public void start() throws Exception {
      i1.start(model);
  }

  public void run() {
    // System.out.println(i1.getText());

    // String command = i1.getText();

    // Executable ex = parser.parseTree(new InputRecord(command));
    // i1.updateTurtle();

  }

  public void step() {

  }

  public void pause() {

  }

  public void help() {
    Stage helpStage = new Stage(); // Create a new Stage object
    BorderPane root = new BorderPane(); // Create a layout for the new scene

    // Create content for the new scene
    VBox helpPane = new VBox(); // Vertical box to contain help documentation and exit button

    // Help Documentation
    Label titleLabel = new Label("SLogo Command List");

    // Turtle Commands
    Label turtleCommandsLabel = new Label("Turtle Commands:");
    Label forwardLabel = new Label("FORWARD - Moves turtle forward by specified pixels.");
    Label backLabel = new Label("BACK - Moves turtle backward by specified pixels.");
    Label leftLabel = new Label("LEFT - Turns turtle counterclockwise by specified degrees.");
    Label rightLabel = new Label("RIGHT - Turns turtle clockwise by specified degrees.");
    Label setHeadingLabel = new Label("SETHEADING - Turns turtle to an absolute heading.");
    Label towardsLabel = new Label("TOWARDS - Turns turtle to face the specified point.");
    Label setXYLabel = new Label("SETXY - Moves turtle to an absolute screen position.");
    Label penDownLabel = new Label("PENDOWN - Puts pen down to leave a trail.");
    Label penUpLabel = new Label("PENUP - Puts pen up to stop leaving a trail.");
    Label showTurtleLabel = new Label("SHOWTURTLE - Makes turtle visible.");
    Label hideTurtleLabel = new Label("HIDETURTLE - Makes turtle invisible.");
    Label homeLabel = new Label("HOME - Moves turtle to the center of the screen.");
    Label clearScreenLabel = new Label(
        "CLEARSCREEN - Erases turtle's trails and sends it to home position.");

    // Turtle Queries
    Label turtleQueriesLabel = new Label("Turtle Queries:");
    Label xCorLabel = new Label(
        "XCOR - Returns the turtle's X coordinate from the center of the screen.");
    Label yCorLabel = new Label(
        "YCOR - Returns the turtle's Y coordinate from the center of the screen.");
    Label headingLabel = new Label("HEADING - Returns the turtle's heading in degrees.");
    Label penDownPLabel = new Label("PENDOWN? - Returns 1 if turtle's pen is down, 0 if it is up.");
    Label showingPLabel = new Label(
        "SHOWING? - Returns 1 if turtle is showing, 0 if it is hiding.");

    // Math Operations
    Label mathOperationsLabel = new Label("Math Operations:");
    Label sumLabel = new Label("SUM - Returns sum of the values of two expressions.");
    Label differenceLabel = new Label(
        "DIFFERENCE - Returns difference of the values of two expressions.");
    Label productLabel = new Label("PRODUCT - Returns product of the values of two expressions.");
    Label quotientLabel = new Label(
        "QUOTIENT - Returns quotient of the values of two expressions.");
    Label minusLabel = new Label("MINUS - Returns negative of the value of the expression.");
    Label randomLabel = new Label(
        "RANDOM - Returns random non-negative number strictly less than max.");

    // Boolean Operations
    Label booleanOperationsLabel = new Label("Boolean Operations:");
    Label equalLabel = new Label(
        "EQUAL? - Returns 1 if the values of two expressions are equal, otherwise 0.");
    Label lessLabel = new Label(
        "LESS? - Returns 1 if the value of first expression is strictly less than the value of second expression, otherwise 0.");
    Label greaterLabel = new Label(
        "GREATER? - Returns 1 if the value of first expression is strictly greater than the value of second expression, otherwise 0.");
    Label andLabel = new Label("AND - Returns 1 if both tests are non-zero, otherwise 0.");
    Label orLabel = new Label("OR - Returns 1 if either test is non-zero, otherwise 0.");
    Label notLabel = new Label("NOT - Returns 1 if the test is 0 and 0 if the test is non-zero.");

    // Add all labels to the help pane
    helpPane.getChildren().addAll(
        titleLabel,
        turtleCommandsLabel, forwardLabel, backLabel, leftLabel, rightLabel, setHeadingLabel,
        towardsLabel, setXYLabel,
        penDownLabel, penUpLabel, showTurtleLabel, hideTurtleLabel, homeLabel, clearScreenLabel,
        turtleQueriesLabel, xCorLabel, yCorLabel, headingLabel, penDownPLabel, showingPLabel,
        mathOperationsLabel, sumLabel, differenceLabel, productLabel, quotientLabel, minusLabel,
        randomLabel,
        booleanOperationsLabel, equalLabel, lessLabel, greaterLabel, andLabel, orLabel, notLabel
    );

    // Exit Button
    Button exitButton = new Button("Exit");
    exitButton.setOnAction(
        event -> helpStage.close()); // Close the stage when the button is clicked
    helpPane.getChildren().add(exitButton); // Add the exit button to the help pane

    root.setCenter(helpPane);

    Scene scene = new Scene(root, 600,
        800); // Create a scene with the layout and desired dimensions
    helpStage.setScene(scene); // Set the scene to the new stage

    helpStage.show(); // Display the new stage
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
}
