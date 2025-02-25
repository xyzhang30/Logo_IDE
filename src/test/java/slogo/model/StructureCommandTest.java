package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.ListExecutable;
import slogo.model.command.executables.VariableExecutable;
import slogo.model.command.executables.structures.DoTimes;
import slogo.model.command.executables.structures.ForCommand;
import slogo.model.command.executables.structures.IfCommand;
import slogo.model.command.executables.structures.IfElse;
import slogo.model.command.executables.structures.Repeat;
import slogo.model.command.executables.turtlecommand.Back;
import slogo.model.command.executables.turtlecommand.Forward;
import slogo.model.command.executables.userdefined.Make;
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

  @Test
  void testRepeatEmptyCommandList(){
    ListExecutable myList = new ListExecutable(new ArrayList<>());
    params.add(new ConstantExecutable(5));
    params.add(myList);
    Repeat repeat = new Repeat(params);
    double returnValue = repeat.execute(env);
    assertEquals(0, returnValue);
    assertEquals(0,env.getTurtleMap().get(1.0).getPosX());
  }

  @Test
  void testDoTimes(){
    ListExecutable commandList = new ListExecutable(List.of(new Forward(List.of(new ConstantExecutable(50)))));
    VariableExecutable var = new VariableExecutable("var");
    assertNull(env.getVarMap().get(var.getSignature()));
    ListExecutable varConstList = new ListExecutable(List.of(var, new ConstantExecutable(5)));
    params.add(varConstList);
    params.add(commandList);
    DoTimes doTimes = new DoTimes(params);
    double returnValue = doTimes.execute(env);
    assertEquals(50, returnValue);
    assertEquals(5,env.getVarMap().get(var.getSignature()));
    assertEquals(50*5,env.getTurtleMap().get(1.0).getPosX());
  }

  @Test
  void testDoTimesEmptyCommandList(){
    ListExecutable commandList = new ListExecutable(new ArrayList<>());
    VariableExecutable var = new VariableExecutable("var");
    assertNull(env.getVarMap().get(var.getSignature()));
    ListExecutable varConstList = new ListExecutable(List.of(var, new ConstantExecutable(5)));
    params.add(varConstList);
    params.add(commandList);
    DoTimes doTimes = new DoTimes(params);
    double returnValue = doTimes.execute(env);
    assertEquals(0, returnValue);
    assertEquals(5,env.getVarMap().get(var.getSignature()));
    assertEquals(0,env.getTurtleMap().get(1.0).getPosX());
  }

  @Test
  void TestFor(){
    ListExecutable commandList = new ListExecutable(List.of(new Forward(List.of(new ConstantExecutable(50)))));
    VariableExecutable var = new VariableExecutable("var");
    assertNull(env.getVarMap().get(var.getSignature()));
    ListExecutable varConstList = new ListExecutable(List.of(var, new ConstantExecutable(1), new ConstantExecutable(10), new ConstantExecutable(2)));
    params.add(varConstList);
    params.add(commandList);
    ForCommand forCommand = new ForCommand(params);
    forCommand.execute(env);
    assertEquals(9,env.getVarMap().get(var.getSignature()));
    assertEquals(50*5,env.getTurtleMap().get(1.0).getPosX());
  }

  @Test
  void TestForVariableAlreadyExists(){
    VariableExecutable var = new VariableExecutable("var");
    List<Executable> makeVarParam = new ArrayList<>(List.of(var, new ConstantExecutable(5)));
    Make make = new Make(makeVarParam);
    make.execute(env);
    ListExecutable commandList = new ListExecutable(List.of(new Forward(List.of(new ConstantExecutable(50)))));
    assertEquals(5, env.getVarMap().get(var.getSignature()));
    ListExecutable varConstList = new ListExecutable(List.of(var, new ConstantExecutable(1), new ConstantExecutable(10), new ConstantExecutable(2)));
    params.add(varConstList);
    params.add(commandList);
    ForCommand forCommand = new ForCommand(params);
    forCommand.execute(env);
    assertEquals(9,env.getVarMap().get(var.getSignature()));
    assertEquals(50*5,env.getTurtleMap().get(1.0).getPosX());
  }

  @Test
  void TestIfFalse(){
    ConstantExecutable constant = new ConstantExecutable(0);
    ListExecutable commandList = new ListExecutable(List.of(new Forward(List.of(new ConstantExecutable(50)))));
    params.add(constant);
    params.add(commandList);
    IfCommand ifCommand = new IfCommand(params);
    Double returnValue = ifCommand.execute(env);
    assertEquals(0,env.getTurtleMap().get(1.0).getPosX());
    assertEquals(0, returnValue);
  }

  @Test
  void TestIfTrue(){
    ConstantExecutable constant = new ConstantExecutable(2);
    ListExecutable commandList = new ListExecutable(List.of(new Forward(List.of(new ConstantExecutable(50)))));
    params.add(constant);
    params.add(commandList);
    IfCommand ifCommand = new IfCommand(params);
    Double returnValue = ifCommand.execute(env);
    assertEquals(50,env.getTurtleMap().get(1.0).getPosX());
    assertEquals(50, returnValue);
  }

  @Test
  void TestIfElseFalse(){
    ConstantExecutable constant = new ConstantExecutable(0);
    ListExecutable trueCommands = new ListExecutable(List.of(new Forward(List.of(new ConstantExecutable(50)))));
    ListExecutable falseCommands = new ListExecutable(List.of(new Back(List.of(new ConstantExecutable(50)))));
    params.add(constant);
    params.add(trueCommands);
    params.add(falseCommands);
    IfElse ifElse = new IfElse(params);
    Double returnValue = ifElse.execute(env);
    assertEquals(-50,env.getTurtleMap().get(1.0).getPosX());
    assertEquals(50, returnValue);
  }

  @Test
  void TestIfElseTrue(){
    ConstantExecutable constant = new ConstantExecutable(1);
    ListExecutable trueCommands = new ListExecutable(List.of(new Forward(List.of(new ConstantExecutable(50)))));
    ListExecutable falseCommands = new ListExecutable(List.of(new Back(List.of(new ConstantExecutable(50)))));
    params.add(constant);
    params.add(trueCommands);
    params.add(falseCommands);
    IfElse ifElse = new IfElse(params);
    Double returnValue = ifElse.execute(env);
    assertEquals(50,env.getTurtleMap().get(1.0).getPosX());
    assertEquals(50, returnValue);
  }


}
