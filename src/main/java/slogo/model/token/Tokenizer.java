package slogo.model.token;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import slogo.example.RegexMatching;
import slogo.model.api.InvalidCommandException;
import slogo.model.api.InvalidConstantException;
import slogo.model.api.InvalidVariableException;
import slogo.model.api.UnterminatedListException;

public class Tokenizer implements TokenizerApi{
  private static final String LANGUAGE_RESOURCE_PATH =
      RegexMatching.class.getPackageName() + ".languages.";
  private List<Entry<String, Pattern>> myTokens = new ArrayList<>();

  public Tokenizer(String language){
    setLanguage(language);
  }

  @Override
  public List<Token> tokenize(String lineInput) throws IllegalArgumentException, InvalidConstantException, InvalidVariableException {
    List<Token> tokens = new ArrayList<>();
    for (String symbol : lineInput.split(" ")) {
      System.out.println(symbol);
      tokens.add(new Token(getTokenType(symbol), symbol));
    }
    return tokens;
  }

  private String getTokenType(String text) throws IllegalArgumentException, InvalidConstantException, InvalidVariableException {
    System.out.println(text);
    System.out.println(myTokens);
    for (Entry<String, Pattern> e : myTokens) {
      if (text != null && e.getValue().matcher(text.trim()).matches()) {
        return e.getKey();
      }
    }
    throw new IllegalArgumentException(String.format("Invalid command given: %s", text));
  }

  public void setLanguage(String language) {
    // language specific matches are more specific, so add first to ensure they are checked first
    myTokens = getPatterns(language);
    // general checks, added last
    myTokens.addAll(getPatterns("Syntax"));
  }

  private List<Entry<String, Pattern>> getPatterns(String language) {
    List<Entry<String, Pattern>> tokens = new ArrayList<>();
    ResourceBundle resources = ResourceBundle.getBundle(LANGUAGE_RESOURCE_PATH + language);
    for (String key : Collections.list(resources.getKeys())) {
      tokens.add(new SimpleEntry<>(key,
          // THIS IS THE OTHER IMPORTANT LINE
          Pattern.compile(resources.getString(key), Pattern.CASE_INSENSITIVE)));
    }
    return tokens;
  }
}
