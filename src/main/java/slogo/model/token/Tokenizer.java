package slogo.model.token;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import slogo.model.api.InvalidVariableException;

/**
 * The Tokenizer class is responsible for tokenizing input text into individual tokens based on
 * predefined patterns. It supports tokenization for different languages and syntax rules.
 */
public class Tokenizer implements TokenizerApi {

  private static final String LANGUAGE_RESOURCE_PATH = "slogo.example.languages.";
  private List<Entry<String, Pattern>> myTokens = new ArrayList<>();

  /**
   * Constructs a Tokenizer with the specified language.
   *
   * @param language the language for tokenization
   */
  public Tokenizer(String language) {
    setLanguage(language);
  }

  /**
   * Tokenizes the input line into a list of tokens.
   *
   * @param lineInput the input line to be tokenized
   * @return a list of tokens
   * @throws IllegalArgumentException if an invalid argument is provided
   * @throws InvalidVariableException if an invalid variable is encountered
   */
  @Override
  public List<Token> tokenize(String lineInput)
      throws IllegalArgumentException, InvalidVariableException {
    List<Token> tokens = new ArrayList<>();
    for (String line : lineInput.split("\n")) {
      for (String symbol : line.split("\\s+")) {
        if (!symbol.isEmpty()){
          String type = getTokenType(symbol);
          if (type.equals("Comment")) {
            tokens.add(new Token(type, line.substring(line.indexOf(symbol))));
            break;
          }
          tokens.add(new Token(type, symbol));
        }
      }
    }
    return tokens;
  }

  /**
   * Determines the type of a given text symbol.
   *
   * @param text the text symbol
   * @return the type of the symbol
   * @throws IllegalArgumentException if an invalid argument is provided
   * @throws InvalidVariableException if an invalid variable is encountered
   */
  private String getTokenType(String text)
      throws IllegalArgumentException, InvalidVariableException {
    for (Entry<String, Pattern> e : myTokens) {
      if (text != null && e.getValue().matcher(text.trim()).matches()) {
        return e.getKey();
      }
    }
    return "Error";
  }


  /**
   * Sets the language for tokenization.
   *
   * @param language the language for tokenization
   */
  public void setLanguage(String language) {
    // language specific matches are more specific, so add first to ensure they are checked first
    myTokens = getPatterns(language);
    // general checks, added last
    myTokens.addAll(getPatterns("Syntax"));
  }


  /**
   * Retrieves token patterns from resource bundles based on the specified language.
   *
   * @param language the language for tokenization
   * @return a list of token patterns
   */
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
