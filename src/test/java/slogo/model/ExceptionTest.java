package slogo.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import slogo.model.api.InvalidCommandException;
import slogo.model.token.Tokenizer;


public class ExceptionTest {

  @Test
  void TestInvalidCommandException(){
    Tokenizer tokenizer = new Tokenizer("English");
    assertThrows(IllegalArgumentException.class, () -> {
      tokenizer.tokenize("fwd f0");
    });
  }

}
