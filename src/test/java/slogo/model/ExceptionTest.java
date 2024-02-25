package slogo.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import slogo.model.api.InvalidCommandException;


public class ExceptionTest {

  @Test
  void TestInvalidCommandException(){
    assertThrows(InvalidCommandException.class, () -> {
    });
  }

}
