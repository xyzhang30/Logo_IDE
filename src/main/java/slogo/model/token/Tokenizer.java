package slogo.model.token;

import java.util.List;
import slogo.model.api.InvalidCommandException;

/**
 * Internal API for Tokenizer. Turns Strings into Tokens. For use by Parser.
 */
public interface Tokenizer {

  List<Token> tokenize(String lineInput) throws InvalidCommandException;
}
