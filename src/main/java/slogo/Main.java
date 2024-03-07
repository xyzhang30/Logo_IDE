package slogo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slogo.model.api.ModelFactory;
import slogo.model.command.Executioner;
import slogo.view.Controller;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

  private Stage primaryStage;
  private String language;
  private String selectedTheme = "default.css";

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    primaryStage.setTitle("SLogo Splash Screen");

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
    colorThemeComboBox.getItems().addAll("dark.css",
        "duke.css",
        "default.css");
    colorThemeComboBox.setPromptText("Select Color Theme");
    colorThemeComboBox.setOnAction(event -> selectedTheme = colorThemeComboBox.getValue()); // Store the selected theme

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
    root.getChildren().addAll(programNameLabel, menuBar, colorThemeComboBox, newSessionButton, loadSessionButton);

    Scene scene = new Scene(root, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void loadSession() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Session File");
    File selectedFile = fileChooser.showOpenDialog(primaryStage);
    if (selectedFile != null) {
      System.out.println("Loading session from file: " + selectedFile.getAbsolutePath());
    } else {
      System.out.println("No session file selected.");
    }
  }

  private void startNewSession() throws Exception {
    // Call the method to start the main application functionality
    ModelFactory modelFactory = new ModelFactory();
    if (language == null){
      language = "english";
    }
    Controller controller = new Controller(primaryStage, modelFactory.createExecutioner(), language);
    controller.start();
    controller.changeStylesheet(selectedTheme); // Change stylesheet based on selected theme

  }

  private void switchToSpanish() throws IOException {
    System.out.println("Switching to Spanish...");
    language = "spanish";
  }

  private void switchToFrench() throws IOException {
    System.out.println("Switching to French...");
    language = "french";
  }

  private void switchToEnglish() throws IOException {
    System.out.println("Switching to English...");
    language = "english";
  }

  public static void main(String[] args) {
    launch(args);
  }
}
