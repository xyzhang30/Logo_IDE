package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.command.executables.structures.Repeat;
import slogo.model.command.executables.turtlecommand.Forward;
import slogo.model.environment.Environment;
import slogo.model.environment.EnvironmentApi;
import slogo.model.turtle.TurtleModel;

public class StructureCommandTest {
  private EnvironmentApi env;
  private List<Executable> params;
  @BeforeEach
  void setUp() {
    env = new Environment(100,100);
    params = new ArrayList<>();
  }

  @Test
  void testRepeat(){
    ListExecutable myList = new ListExecutable(List.of(new Forward(List.of(new ConstantExecutable(50)))));
    params.add(new ConstantExecutable(5));
    params.add(myList);
    Repeat repeat = new Repeat(params);
    repeat.execute(env);
    assertEquals(50*5,env.getTurtleMap().get(1.0).getPosX());
  }
}
