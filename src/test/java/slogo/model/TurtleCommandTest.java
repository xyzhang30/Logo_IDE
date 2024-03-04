package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.command.executables.turtlecommand.Back;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.turtlecommand.Forward;
import slogo.model.command.executables.turtlecommand.Heading;
import slogo.model.command.executables.turtlecommand.Home;
import slogo.model.command.executables.turtlecommand.Left;
import slogo.model.command.executables.turtlecommand.PenDownQuery;
import slogo.model.command.executables.turtlecommand.Right;
import slogo.model.command.executables.turtlecommand.SetHeading;
import slogo.model.command.executables.turtlecommand.Setxy;
import slogo.model.command.executables.turtlecommand.ShowingQuery;
import slogo.model.command.executables.turtlecommand.Towards;
import slogo.model.command.executables.turtlecommand.Xcor;
import slogo.model.command.executables.turtlecommand.Ycor;
import slogo.model.environment.Environment;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class TurtleCommandTest {
  private EnvironmentApi env;
  private TurtleModel turt;
  private List<Executable> params;

  @BeforeEach
  void setUp() {
    env = new Environment(100,100);
    turt = env.getTurtle();
    params = new ArrayList<>();
  }

  @Test
  void testForwardToRight() {
    turt.setDirection(0); //facing right

    params.add(new ConstantExecutable(50)); //move 50 to the right

    System.out.println(params.get(0).execute(env));
    //straight forward
    Forward forward = new Forward(params);
    forward.execute(env);
    assertEquals(50, (short)turt.getPosX());
    assertEquals(0, (short)turt.getPosY()); //should get form (0,0) to (50,0)
  }

  @Test
  void testForwardToTop(){
    turt.setDirection(90); //facing top

    params.add(new ConstantExecutable(50)); //move 50 to the right facing right

    //straight forward
    Forward forward = new Forward(params);
    forward.execute(env);
    assertEquals(0, (short)turt.getPosX());
    assertEquals(50, (short)turt.getPosY()); //should get form (0,0) to (50,0)
  }

  @Test
  void testBack(){
    turt.setDirection(90); //facing top

    params.add(new ConstantExecutable(40)); //move 40 down facing up

    //straight forward
    Back back = new Back(params);
    back.execute(env);
    assertEquals(0, (short)turt.getPosX());
    assertEquals(-40, (short)turt.getPosY());
  }

  @Test
  void testLeft(){
    turt.setDirection(45);

    params.add(new ConstantExecutable(45)); //turn 45 degrees counterclockwise

    Left left = new Left(params);
    left.execute(env);
    assertEquals(90, turt.getDegreesDirection());
  }

  @Test
  void testRight(){
    turt.setDirection(45);

    params.add(new ConstantExecutable(45)); //turn 45 degrees clockwise

    Right right = new Right(params);
    right.execute(env);
    assertEquals(0, turt.getDegreesDirection());
  }

  @Test
  void testSetHeading(){
    turt.setDirection(10);

    params.add(new ConstantExecutable(-10)); //set heading to -10

    SetHeading setHeading = new SetHeading(params);
    double degreesTurned = setHeading.execute(env);
    assertEquals(20, degreesTurned);
    assertEquals(-10, turt.getDegreesDirection());
  }

  @Test
  void testTowards(){
    turt.setDirection(45);
    turt.setPosX(3);
    turt.setPosY(2);

    params.add(new ConstantExecutable(2));
    params.add(new ConstantExecutable(1));

    Towards towards = new Towards(params);
    double degreesTurned = towards.execute(env);
    assertEquals(180, degreesTurned);
    assertEquals(225, turt.getDegreesDirection());
  }

  @Test
  void testTowardsSamePoint(){
    turt.setDirection(45);
    turt.setPosX(3);
    turt.setPosY(2);

    params.add(new ConstantExecutable(3));
    params.add(new ConstantExecutable(2));

    Towards towards = new Towards(params);

    double degreesTurned = towards.execute(env);
    assertEquals(0, degreesTurned);
    assertEquals(45, turt.getDegreesDirection());
  }

  @Test
  void testSetxy(){
    params.add(new ConstantExecutable(0));
    params.add(new ConstantExecutable(1));

    Setxy setxy = new Setxy(params);
    double distMoved = setxy.execute(env);
    assertEquals(1, distMoved);
    assertEquals(0, turt.getPosX());
    assertEquals(1, turt.getPosY());
  }

  @Test
  void TestHome(){
    turt.setPosX(4);
    turt.setPosY(-3);

    Home home = new Home(params);

    double distMoved = home.execute(env);
    assertEquals(0, turt.getPosX());
    assertEquals(0, turt.getPosY());
    assertEquals(5, distMoved);
  }

  @Test
  void TestXcorQuery(){
    turt.setPosX(50);
    Xcor xcor = new Xcor(params);
    assertEquals(50, xcor.execute(env));
  }

  @Test
  void TestYcorQuery(){
    turt.setPosY(5);
    Ycor ycor = new Ycor(params);
    assertEquals(5, ycor.execute(env));
  }

  @Test
  void TestHeadingQuery(){
    turt.setDirection(90);
    Heading heading = new Heading(params);
    assertEquals(90, heading.execute(env));
  }

  @Test
  void TestPenDownQuery(){
    turt.setPenDown(false);
    PenDownQuery penDownQuery = new PenDownQuery(params);
    assertEquals(0, penDownQuery.execute(env));
  }

  @Test
  void TestShowingQuery(){
    turt.setVisible(true);
    ShowingQuery showingQuery = new ShowingQuery(params);
    assertEquals(1, showingQuery.execute(env));
  }


}
