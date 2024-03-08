package slogo.view;

import java.util.Map;
import slogo.model.api.TurtleModelApi;

/**
 * The {@code TurtlePaneRecord} class represents a record for storing information about the turtle pane,
 * including its height, width, turtle model, language, speed, and associated controller.
 *
 * <p>This class is designed as a record, providing a concise and immutable representation of the turtle pane state.
 * Records are immutable by default, and their instances can be easily created and accessed using constructor-like
 * syntax.</p>
 *
 * @param height      The height of the turtle pane.
 * @param width       The width of the turtle pane.
 * @param model       The map containing turtle models associated with their unique identifiers.
 * @param language    The language used in the turtle pane.
 * @param speed       The speed of turtle movements in the pane.
 * @param controller  The controller associated with the turtle pane.
 */
public record TurtlePaneRecord(int height, int width, Map<Double, TurtleModelApi> model, String language,
                               int speed, Controller controller) {
}



