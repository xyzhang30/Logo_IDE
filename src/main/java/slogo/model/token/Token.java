package slogo.model.token;

/**
 * The {@code Token} class represents a token parsed from input text. Each token has a type and a
 * corresponding value.
 */
public record Token(String type, String value) {

}
