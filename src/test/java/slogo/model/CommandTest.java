package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.Forward;
import slogo.model.turtle.TurtleModel;

public class CommandTest {
  private TurtleModel turt;

  @BeforeEach
  void setUp() {
    turt = new TurtleModel();
  }

  @Test
  void testForwardToRight() {
    turt.setDirection(90); //facing right

    List<Executable> params = new ArrayList<>();
    params.add(new ConstantExecutable(50)); //move 50 to the right

    //straight forward
    Forward forward = new Forward(params, turt);
    forward.internalLogicExecution();
    assertEquals(0, (short)turt.getPosX());
    assertEquals(50, (short)turt.getPoxY()); //should get form (0,0) to (50,0)
  }


//  @Test
//  void testForwardToTop(){
//    turt.setDirection(90); //facing top
//
//    List<Executable> params = new ArrayList<>();
//    params.add(new ConstantExecutable(50)); //move 50 to the right
//
//    //straight forward
//    Forward forward = new Forward(params, turt);
//    forward.internalLogicExecution();
//    assertEquals(0, turt.getPosX());
//    assertEquals(50, turt.getPoxY()); //should get form (0,0) to (50,0)
//  }
}
