package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import slogo.model.command.Forward;
import slogo.model.turtle.TurtleModel;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;
import java.util.concurrent.TimeUnit;
import javafx.animation.Animation;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import util.DukeApplicationTest;

public class CommandTest {

  @Test
  void testForward () {
    TurtleModel turt = new TurtleModel();
    turt.setDirection(315);
    Forward forward = new Forward(50, turt);
    forward.execute();
    assertEquals((short)35.35533905932737, (short)turt.getPosX());
    assertEquals((short)-35.35533905932738, (short)turt.getPoxY());
  }

}
