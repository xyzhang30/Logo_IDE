package slogo.model.api;

/**
 * External API for the Turtle Model.
 */
public interface TurtleModelApi {

  /**
   * Returns the Turtle's attributes, packed into a record.
   */
  TurtleRecord getAttributes();
}
