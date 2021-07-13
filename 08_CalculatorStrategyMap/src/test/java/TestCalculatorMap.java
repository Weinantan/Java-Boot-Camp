import bootcamp.data.Params;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.ElementFactory;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TestCalculatorMap {

//    @Test
//    public void shouldAddTwoParamsddd() throws Exception {
////        Params params = new Params(new BigDecimal(3),new BigDecimal(2),"+");
////        ElementFactory factory = new ElementFactory();
////        var x = factory.create(params.getOperator()).get().process(params.getX(),params.getY());
////        Calculator cal = new Calculator(factory);
////        Optional result = cal.calculate(params).getValue();
////        assertEquals(new Result(Status.SUCCESS,"", Optional.of(new BigDecimal(5))).getValue(),result);
//   }

    @Test
    public void shouldAddTwoParams(){
        Params params = new Params(new BigDecimal(3),new BigDecimal(2),"+");
        Map<String, ProcessingElement> elementMap = new HashMap<>();
        ElementFactory factory = new ElementFactory(elementMap);
        factory.create(params.getOperator());
        elementMap.get(factory.create(params.getOperator()));
        Calculator cal = new Calculator(factory);

        Optional result = cal.calculate(params).getValue();
        assertEquals(Optional.of(new BigDecimal(5)),result);
    }

    @Test
    public void shouldSubTwoParams(){
        Params params = new Params(new BigDecimal(3),new BigDecimal(2),"-");
        Map<String, ProcessingElement> elementMap = new HashMap<>();
        ElementFactory factory = new ElementFactory(elementMap);
        factory.create(params.getOperator());
        elementMap.get(factory.create(params.getOperator()));
        Calculator cal = new Calculator(factory);

        Optional result = cal.calculate(params).getValue();
        assertEquals(Optional.of(new BigDecimal(1)),result);
    }

    @Test
    public void shouldTimesTwoParams(){
        Params params = new Params(new BigDecimal(4),new BigDecimal(2),"*");
        Map<String, ProcessingElement> elementMap = new HashMap<>();
        ElementFactory factory = new ElementFactory(elementMap);
        factory.create(params.getOperator());
        elementMap.get(factory.create(params.getOperator()));
        Calculator cal = new Calculator(factory);

        Optional result = cal.calculate(params).getValue();
        assertEquals(Optional.of(new BigDecimal(8)),result);
    }

    @Test
    public void shouldDivideTwoParams(){
        Params params = new Params(new BigDecimal(4),new BigDecimal(2),"/");
        Map<String, ProcessingElement> elementMap = new HashMap<>();
        ElementFactory factory = new ElementFactory(elementMap);
        factory.create(params.getOperator());
        elementMap.get(factory.create(params.getOperator()));
        Calculator cal = new Calculator(factory);

        Optional result = cal.calculate(params).getValue();
        assertEquals(Optional.of(new BigDecimal(2)),result);
    }







}
