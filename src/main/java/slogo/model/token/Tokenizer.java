package slogo.model.token;

import java.util.List;

/**
 * Internal API for Tokenizer. Turns Strings into Tokens. For use by Parser.
 */
public interface Tokenizer {

  List<Token> tokenize(String lineInput);
}
