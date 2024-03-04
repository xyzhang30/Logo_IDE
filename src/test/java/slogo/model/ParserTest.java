package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.api.InputRecord;
import slogo.model.api.ParserApi;
import slogo.model.command.executables.RootExecutable;
import slogo.model.environment.Environment;
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

}
