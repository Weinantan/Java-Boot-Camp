import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TestCalculatorMap {
    Calculator cal = new Calculator();
    @Test
    public void shouldAddTwoParams() {
        Params params = new Params(new BigDecimal(3),new BigDecimal(2),"+");
        Result results = cal.calculate(params);
        assertEquals(results.getValue(),Optional.of(new BigDecimal(5)));
   }

    @Test
    public void shouldSubTwoParams(){
        Params params = new Params(new BigDecimal(3),new BigDecimal(2),"-");
       Result result = cal.calculate(params);
        assertEquals(Optional.of(new BigDecimal(1)),result.getValue());
    }

    @Test
    public void shouldTimesTwoParams(){
        Params params = new Params(new BigDecimal(4),new BigDecimal(2),"*");
       Result result = cal.calculate(params);
        assertEquals(Optional.of(new BigDecimal(8)),result.getValue());
    }

    @Test
    public void shouldDivideTwoParams(){
        Params params = new Params(new BigDecimal(4),new BigDecimal(2),"/");
        Result result = cal.calculate(params);
        assertEquals(result.getValue(),Optional.of(new BigDecimal(2)));
    }

    @Test
    public void ShouldReturnStatusInvalidOperation(){
        Params params = new Params(new BigDecimal(4),new BigDecimal(2),"454");
        Status status = cal.calculate(params).getStatus();
        assertEquals(status,Status.INVALID_OPERATION);
    }

    @Test
    public void ShouldReturnStatusArithmeticError(){
        Params params = new Params(new BigDecimal(4),new BigDecimal(0),"/");
        Status status = cal.calculate(params).getStatus();
        assertEquals(status,Status.ARITHMETIC_ERROR);
    }





}
