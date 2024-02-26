package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.turtle.TurtleModel;

public class TurtleModelTest {

  private TurtleModel turt;

  @BeforeEach
  void setup(){
    turt = new TurtleModel();
  }

  @Test
  void getTurtleRecordTest(){
    assertEquals(0, turt.getAttributes().direction());
  }

}
