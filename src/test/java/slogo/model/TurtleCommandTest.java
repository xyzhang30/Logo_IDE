package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.command.executables.turtleCommand.Back;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.turtleCommand.Forward;
import slogo.model.command.executables.turtleCommand.Home;
import slogo.model.command.executables.turtleCommand.Left;
import slogo.model.command.executables.turtleCommand.Right;
import slogo.model.command.executables.turtleCommand.SetHeading;
import slogo.model.command.executables.turtleCommand.Setxy;
import slogo.model.command.executables.turtleCommand.Towards;
import slogo.model.turtle.TurtleModel;

public class TurtleCommandTest {
  private TurtleModel turt;
  private List<Executable> params;

  @BeforeEach
  void setUp() {
    turt = new TurtleModel();
    params = new ArrayList<>();
  }

  @Test
  void testForwardToRight() {
    turt.setDirection(0); //facing right

    params.add(new ConstantExecutable(50)); //move 50 to the right

    //straight forward
    Forward forward = new Forward(params, turt);
    forward.execute();
    assertEquals(50, (short)turt.getPosX());
    assertEquals(0, (short)turt.getPosY()); //should get form (0,0) to (50,0)
  }

  @Test
  void testForwardToTop(){
    turt.setDirection(90); //facing top

    params.add(new ConstantExecutable(50)); //move 50 to the right facing right

    //straight forward
    Forward forward = new Forward(params, turt);
    forward.execute();
    assertEquals(0, (short)turt.getPosX());
    assertEquals(50, (short)turt.getPosY()); //should get form (0,0) to (50,0)
  }

  @Test
  void testBack(){
    turt.setDirection(90); //facing top

    params.add(new ConstantExecutable(40)); //move 40 down facing up

    //straight forward
    Back back = new Back(params, turt);
    back.execute();
    assertEquals(0, (short)turt.getPosX());
    assertEquals(-40, (short)turt.getPosY());
  }

  @Test
  void testLeft(){
    turt.setDirection(45);

    params.add(new ConstantExecutable(45)); //turn 45 degrees counterclockwise

    Left left = new Left(params, turt);
    left.execute();
    assertEquals(90, turt.getDegreesDirection());
  }

  @Test
  void testRight(){
    turt.setDirection(45);

    params.add(new ConstantExecutable(45)); //turn 45 degrees clockwise

    Right right = new Right(params, turt);
    right.execute();
    assertEquals(0, turt.getDegreesDirection());
  }

  @Test
  void testSetHeading(){
    turt.setDirection(10);

    params.add(new ConstantExecutable(-10)); //set heading to -10

    SetHeading setHeading = new SetHeading(params, turt);
    double degreesTurned = setHeading.execute();
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

    Towards towards = new Towards(params, turt);
    double degreesTurned = towards.execute();
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

    Towards towards = new Towards(params, turt);

    double degreesTurned = towards.execute();
    assertEquals(0, degreesTurned);
    assertEquals(45, turt.getDegreesDirection());
  }

  @Test
  void testSetxy(){
    params.add(new ConstantExecutable(0));
    params.add(new ConstantExecutable(1));

    Setxy setxy = new Setxy(params,turt);
    double distMoved = setxy.execute();
    assertEquals(1, distMoved);
    assertEquals(0, turt.getPosX());
    assertEquals(1, turt.getPosY());
  }

  @Test
  void TestHome(){
    turt.setPosX(4);
    turt.setPosY(-3);

    Home home = new Home(params, turt);

    double distMoved = home.execute();
    assertEquals(0, turt.getPosX());
    assertEquals(0, turt.getPosY());
    assertEquals(5, distMoved);
  }

}
