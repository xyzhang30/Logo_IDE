package slogo.model.token;

import java.util.List;
import slogo.model.api.InvalidCommandException;

/**
 * Internal API for Tokenizer. Turns Strings into Tokens. For use by Parser.
 */
public interface TokenizerApi {

  /**
   * Converts an input string into a list of tokens for the parser.
   *
   * @param lineInput the input received as a complete string
   * @return List  a list of Token records containing every token in the input
   * @throws InvalidCommandException When an invalid token is encountered
   */
  List<Token> tokenize(String lineInput) throws InvalidCommandException;

  /**
   * Sets the tokenizer interpretation language.
   *
   * @param language String of the language name. i.e. "English"
   */
  void setLanguage(String language);
}
