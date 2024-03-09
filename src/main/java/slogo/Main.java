package slogo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slogo.view.Controller;
import slogo.view.ModelGenerator;
import slogo.view.ViewParser;

/**
 * Main class where everything starts.
 */
public class Main extends Application {

  private Stage primaryStage;
  private String language;
  private String selectedTheme = "default.css";

  /**
   * Main function call. Redundant and unnecessary.
   *
   * @param args The arguments. Redundant.
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Starts the stage. Built into javafx.
   *
   * @param primaryStage the primary stage for this application, onto which the application scene
   *                     can be set. Applications may create other stages, if needed, but they will
   *                     not be primary stages.
   */
  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    primaryStage.setTitle("SLogo Splash Screen");

    language = "english";

    // Program's name label
    Label programNameLabel = new Label("SLogo");
    programNameLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

    // Language selection dropdown
    Menu languageMenu = new Menu("Select Language");

    MenuItem frenchItem = new MenuItem("French");
    frenchItem.setOnAction(event -> {
      try {
        switchToFrench();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });

    MenuItem englishItem = new MenuItem("English");
    englishItem.setOnAction(event -> {
      try {
        switchToEnglish();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });

    MenuItem spanishItem = new MenuItem("Spanish");
    spanishItem.setOnAction(event -> {
      try {
        switchToSpanish();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });

    languageMenu.getItems().addAll(frenchItem, englishItem, spanishItem);
    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().add(languageMenu);

    // Color theme selection dropdown (dummy data)
    ComboBox<String> colorThemeComboBox = new ComboBox<>();
    try {
      ViewParser v1 = new ViewParser();
      v1.readXml("theme");
      colorThemeComboBox.getItems().addAll(v1.getOptions());
      colorThemeComboBox.setPromptText("Select Color Theme");
      colorThemeComboBox.setOnAction(
          event -> selectedTheme = colorThemeComboBox.getValue()); // Store the selected theme
    } catch (FileNotFoundException f1) {
      // do nothing
    }

    // Button for starting a new session
    Button newSessionButton = new Button("Start New Session");
    newSessionButton.setOnAction(event -> {
      try {
        startNewSession();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });

    Button loadSessionButton = new Button("Load Session");
    loadSessionButton.setOnAction(event -> {
      try {
        loadSession();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });

    // VBox to hold all elements
    VBox root = new VBox(20);
    root.setAlignment(Pos.CENTER);
    root.setPadding(new Insets(20));
    root.getChildren()
        .addAll(programNameLabel, menuBar, colorThemeComboBox, newSessionButton, loadSessionButton);

    Scene scene = new Scene(root, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void loadSession() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialDirectory(new File("data/"));

    fileChooser.setTitle("Open Session File");
    File selectedFile = fileChooser.showOpenDialog(primaryStage);
    if (selectedFile != null) {
      try {
        // Read the content of the selected file
        String fileContent = readFile(selectedFile);

        // Call the controller to run the loaded session
        ModelGenerator modelFactory = new ModelGenerator();
        Controller controller = new Controller(primaryStage, modelFactory.createExecutioner(),
            language);
        controller.start();
        controller.getIde().loadFileContent(fileContent);
      } catch (Exception e) {
        new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
      }
    } else {
      System.out.println("No session file selected.");
    }
  }

  private String readFile(File file) throws IOException {
    StringBuilder contentBuilder = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        contentBuilder.append(line).append("\n");
      }
    }
    return contentBuilder.toString();
  }

  private void startNewSession() throws Exception {
    // Call the method to start the main application functionality
    ModelGenerator modelFactory = new ModelGenerator();
    if (language == null) {
      language = "english";
    }
    Controller controller = new Controller(primaryStage, modelFactory.createExecutioner(),
        language);
    controller.start();
    controller.changeStylesheet(selectedTheme); // Change stylesheet based on selected theme

  }

  private void switchToSpanish() throws IOException {
    language = "spanish";
  }

  private void switchToFrench() throws IOException {
    language = "french";
  }

  private void switchToEnglish() throws IOException {
    language = "english";
  }
}
