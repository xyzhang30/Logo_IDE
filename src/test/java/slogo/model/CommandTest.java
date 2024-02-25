package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.turtle.TurtleModel;

public class CommandTest {
  private TurtleModel turt;

  @BeforeEach
  void setUp() {
    turt = new TurtleModel();
    turt.setDirection(0);
  }

  @Test
  void testForward () {

//    //straight forward
//    Forward forward = new Forward(50, turt);
//    forward.execute();
//    assertEquals(50, turt.getPosX());
//    assertEquals(0, turt.getPoxY());
//
//    //reset turtle
//    turt.reset();
//    assertEquals(0, turt.getPosX());
//    assertEquals(0, turt.getPoxY());
//
//    //straight up --> doesn't work
//    turt.setDirection(90);
//    forward.execute();
//    assertEquals(0, turt.getPosX());
//    assertEquals(50, turt.getPoxY());

//    assertEquals((short)35.35533905932737, (short)turt.getPosX());
//    assertEquals((short)-35.35533905932738, (short)turt.getPoxY());
  }

}
