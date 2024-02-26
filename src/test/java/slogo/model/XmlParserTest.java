package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.xmlparser.CommandXmlParser;

public class XmlParserTest {

  private CommandXmlParser commandXmlParser;

  @BeforeEach
  void setup(){
    commandXmlParser = new CommandXmlParser();
  }

  @Test
  void TestParseCommandName() throws FileNotFoundException {
    commandXmlParser.readXml("Forward");
    assertEquals("forward", commandXmlParser.getCommandName());
  }

  @Test
  void TestEmptyTagXmlFile() {
    assertThrows(FileNotFoundException.class, () -> {
      commandXmlParser.readXml("TestEmptyTag");
    });
  }

  @Test
  void TestParseExpectedParameterNumber() throws FileNotFoundException {
    commandXmlParser.readXml("Forward");
    assertEquals(1,commandXmlParser.getNumParamsExpected());
  }

  @Test
  void TestParseReturnValueType() throws FileNotFoundException {
    commandXmlParser.readXml("Forward");
    assertEquals("Double", commandXmlParser.getReturnValueType());
  }
}
