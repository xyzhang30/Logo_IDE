package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import slogo.model.api.InputRecord;
import slogo.model.command.Executioner;
import slogo.model.command.executables.ErrorExecutable;
import slogo.model.token.Tokenizer;


public class ExceptionTest {

  @Test
  void TestIllegalArgumentException(){
      String test = "fwd 50";
      InputRecord inputRecord = new InputRecord(test);
      Executioner executioner = new Executioner();
      executioner.parseTree(inputRecord);
      executioner.runNext();
      assertEquals(2*50, executioner.getTurtleModel().getAttributes().xpos());
  }

}
