package slogo.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.web.HTMLEditorSkin.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.command.CommandHistory;

public class CommandHistoryTest {

  CommandHistory commandHistory;

  @BeforeEach
  void setup(){
    commandHistory = new CommandHistory();
    List<String> input = new ArrayList<>();
    input.add("test");
    input.add("02");
    commandHistory.setStrings(input);
  }

  @Test
  void testSaveFile(){
    commandHistory.saveCurrent();
    commandHistory.saveCurrent();
    String fileName = "testingSave";
    String folderPath = "data/examples";
    commandHistory.saveFile(fileName, folderPath);

    File file = new File(folderPath + "/" + fileName);
    Assertions.assertTrue(file.exists(), "File should exist");

    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line + "\n");
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    Assertions.assertEquals("test\n02", content.toString().strip());

    file.delete();
  }

}
