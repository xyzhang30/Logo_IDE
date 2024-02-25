package slogo.model.token;

import java.util.List;
import slogo.model.api.InvalidCommandException;
import slogo.model.api.InvalidConstantException;
import slogo.model.api.InvalidVariableException;
import slogo.model.api.UnterminatedListException;

/**
 * Internal API for Tokenizer. Turns Strings into Tokens. For use by Parser.
 */
public interface Tokenizer {

  List<Token> tokenize(String lineInput) throws InvalidCommandException, InvalidConstantException, InvalidVariableException, UnterminatedListException;
}
