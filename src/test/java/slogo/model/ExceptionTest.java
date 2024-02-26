package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import slogo.model.token.Tokenizer;


public class ExceptionTest {

  @Test
  void TestInvalidCommandException(){
    Tokenizer tokenizer = new Tokenizer("English");
    assertEquals("fwd",tokenizer.tokenize("fwd 5").get(0).value());
    assertThrows(IllegalArgumentException.class, () -> {
      tokenizer.tokenize("fwd f0");
    });
  }

}
