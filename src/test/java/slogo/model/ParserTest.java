package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.api.InputRecord;
import slogo.model.api.ParserApi;
import slogo.model.command.Executioner;
import slogo.model.parser.TreeParser;

public class ParserTest {
  private ParserApi myParser;
  @BeforeEach
  void setup(){
    myParser = new TreeParser();
  }

  @Test
  void testSimple(){
    try {
      String s = new String(Files.readAllBytes(Path.of("data/examples/simple/square.slogo")));
      myParser.parseTree(new InputRecord(s));
      System.out.println();
    } catch (Exception e) {
      System.out.println("ERROR: Unable to read input file " + e.getMessage());
    }
  }

  @Test
  void testTwoSingleLineCommandInput(){
    String test = "fd 50\nleft 90";
    InputRecord inputRecord = new InputRecord(test);
    Executioner executioner = new Executioner();
    executioner.parseTree(inputRecord);
    executioner.runNext();
    assertEquals(50, executioner.getTurtleModel().getAttributes().xpos());
    executioner.runNext();
    assertEquals(90, executioner.getTurtleModel().getAttributes().direction());
  }

}
