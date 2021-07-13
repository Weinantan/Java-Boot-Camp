import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactory;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldAddTwoParams() throws Exception {
        Params params = new Params(new BigDecimal(3),new BigDecimal(2),"+");
        ElementFactory factory = new ElementFactory();
        var x = factory.create(params.getOperator()).get().process(params.getX(),params.getY());
        Calculator cal = new Calculator(factory);
        Optional result = cal.calculate(params).getValue();
        assertEquals(new Result(Status.SUCCESS,"", Optional.of(new BigDecimal(5))).getValue(),result);

    }

    @Test
    public void ShouldMinusTwoParams() throws Exception{
        Params params = new Params(new BigDecimal(3),new BigDecimal(2),"-");
        ElementFactory factory = new ElementFactory();
        var x = factory.create(params.getOperator()).get().process(params.getX(),params.getY());
        Calculator cal = new Calculator(factory);
        Optional result = cal.calculate(params).getValue();

        assertEquals(new Result(Status.SUCCESS,"", Optional.of(new BigDecimal(1))).getValue(),result);

    }

    @Test
    public void ShouldMultiplyTwoParams() throws Exception{
        Params params = new Params(new BigDecimal(3),new BigDecimal(2),"*");
        ElementFactory factory = new ElementFactory();
        var x = factory.create(params.getOperator()).get().process(params.getX(),params.getY());
        Calculator cal = new Calculator(factory);
        Optional result = cal.calculate(params).getValue();

        assertEquals(new Result(Status.SUCCESS,"", Optional.of(new BigDecimal(6))).getValue(),result);
    }

    @Test
    public void ShouldDivideTwoParams() throws Exception{
        Params params = new Params(new BigDecimal(4),new BigDecimal(2),"/");
        ElementFactory factory = new ElementFactory();
        var x = factory.create(params.getOperator()).get().process(params.getX(),params.getY());
        Calculator cal = new Calculator(factory);
        Optional result = cal.calculate(params).getValue();

        assertEquals(new Result(Status.SUCCESS,"", Optional.of(new BigDecimal(2))).getValue(),result);
    }

    @Test(expected = ArithmeticException.class)
    public void CannotDivideZero() throws Exception{
        Params params = new Params(new BigDecimal(4),new BigDecimal(0),"/");
        ElementFactory factory = new ElementFactory();
        var x = factory.create(params.getOperator()).get().process(params.getX(),params.getY());
        Calculator cal = new Calculator(factory);
        Optional result = cal.calculate(params).getValue();
    }

    @Test (expected = Exception.class)
    public void InvalidOperator() throws Exception{
        Params params = new Params(new BigDecimal(4),new BigDecimal(0),"hwa");
        ElementFactory factory = new ElementFactory();
        var x = factory.create(params.getOperator()).get().process(params.getX(),params.getY());
        Calculator cal = new Calculator(factory);
        Optional result = cal.calculate(params).getValue();


    }










}
