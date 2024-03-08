package slogo.view;

import java.util.Map;
import slogo.model.api.TurtleModelApi;


  public record TurtlePaneRecord(int height, int width, Map<Double, TurtleModelApi> model, String language,
      int speed, Controller controller) {

  }


