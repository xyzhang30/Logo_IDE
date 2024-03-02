package slogo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.assertj.core.internal.Diff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.command.executables.ConstantExecutable;
import slogo.model.command.executables.Executable;
import slogo.model.command.executables.mathCommand.DifferenceCommand;
import slogo.model.command.executables.mathCommand.MinusCommand;
import slogo.model.command.executables.mathCommand.ProductCommand;
import slogo.model.command.executables.mathCommand.QuotientCommand;
import slogo.model.command.executables.mathCommand.RandomCommand;
import slogo.model.command.executables.mathCommand.SumCommand;

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

}
