package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.mathcommand.AndCommand;
import slogo.model.command.executables.mathcommand.DifferenceCommand;
import slogo.model.command.executables.mathcommand.EqualCommand;
import slogo.model.command.executables.mathcommand.GreaterCommand;
import slogo.model.command.executables.mathcommand.LessCommand;
import slogo.model.command.executables.mathcommand.MinusCommand;
import slogo.model.command.executables.mathcommand.OrCommand;
import slogo.model.command.executables.mathcommand.ProductCommand;
import slogo.model.command.executables.mathcommand.QuotientCommand;
import slogo.model.command.executables.mathcommand.RandomCommand;
import slogo.model.command.executables.mathcommand.SumCommand;

public class MathCommandTest {

  private List<Executable> params;

  @BeforeEach
  void setup(){
    params = new ArrayList<>();
  }

  @Test
  void TestSum(){
    params.add(new ConstantExecutable(50));
    params.add(new ConstantExecutable(10));
    SumCommand sumCommand = new SumCommand(params);
    assertEquals(50+10, sumCommand.execute());
  }

  @Test
  void TestDifference(){
    params.add(new ConstantExecutable(50));
    params.add(new ConstantExecutable(10));
    DifferenceCommand differenceCommand = new DifferenceCommand(params);
    assertEquals(50-10, differenceCommand.execute());
  }

  @Test
  void TestProduct(){
    params.add(new ConstantExecutable(50));
    params.add(new ConstantExecutable(10));
    ProductCommand productCommand = new ProductCommand(params);
    assertEquals(50*10, productCommand.execute());
  }

  @Test
  void TestQuotient(){
    params.add(new ConstantExecutable(50));
    params.add(new ConstantExecutable(10));
    QuotientCommand quotientCommand = new QuotientCommand(params);
    assertEquals(50/10, quotientCommand.execute());
  }

  @Test
  void TestRandom(){
    params.add(new ConstantExecutable(50));
    RandomCommand randomCommand = new RandomCommand(params);
    assertTrue(randomCommand.execute()>0);
    assertTrue(randomCommand.execute()<50);
  }

  @Test
  void TestMinus(){
    params.add(new ConstantExecutable(50));
    MinusCommand minusCommand = new MinusCommand(params);
    assertEquals(-50, minusCommand.execute());
  }

  @Test
  void TestAnd(){
    params.add(new ConstantExecutable(1));
    params.add(new ConstantExecutable(2));
    AndCommand andCommand = new AndCommand(params);
    assertEquals(1, andCommand.execute());
  }

  @Test
  void TestEqualSameNumber(){
    params.add(new ConstantExecutable(2));
    params.add(new ConstantExecutable(2));
    EqualCommand equalCommand = new EqualCommand(params);
    assertEquals(1, equalCommand.execute());
  }

  @Test
  void TestEqualErrorTolerance(){
    params.add(new ConstantExecutable(2.00001));
    params.add(new ConstantExecutable(2));
    EqualCommand equalCommand = new EqualCommand(params);
    assertEquals(1, equalCommand.execute());
  }

  @Test
  void TestNotEqual(){
    params.add(new ConstantExecutable(2));
    params.add(new ConstantExecutable(2.01));
    EqualCommand equalCommand = new EqualCommand(params);
    assertEquals(0, equalCommand.execute());
  }

  @Test
  void TestGreater(){
    params.add(new ConstantExecutable(2));
    params.add(new ConstantExecutable(2));
    GreaterCommand greaterCommand = new GreaterCommand(params);
    assertEquals(0, greaterCommand.execute());
  }

  @Test
  void TestLess(){
    params.add(new ConstantExecutable(1));
    params.add(new ConstantExecutable(2));
    LessCommand lessCommand = new LessCommand(params);
    assertEquals(1, lessCommand.execute());
  }

  @Test
  void TestOr(){
    params.add(new ConstantExecutable(1));
    params.add(new ConstantExecutable(0));
    OrCommand orCommand = new OrCommand(params);
    assertEquals(1, orCommand.execute());
  }

}
