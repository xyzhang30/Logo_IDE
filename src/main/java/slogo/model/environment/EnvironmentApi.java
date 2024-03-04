package slogo.model.environment;

import java.util.Map;
import slogo.model.command.executables.Executable;
import slogo.model.turtle.TurtleModel;

public interface EnvironmentApi {

  Map<String, Double> getVarMap();

  Map<String, Executable> getFuncMap();

  TurtleModel getTurtle();
  int getWidth();
  int getHeight();
}
