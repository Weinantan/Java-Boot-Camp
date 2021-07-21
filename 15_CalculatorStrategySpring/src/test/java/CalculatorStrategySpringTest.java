import bootcamp.data.Params;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CalculatorStrategySpringTest {
    private static ApplicationContext context;
    private static Calculator cal;
    @BeforeClass
    public static void SetUp() {
        context = new AnnotationConfigApplicationContext(ElementFactory.class);
        cal = (Calculator) context.getBean("calculator");
    }

    @Test
    public void ShouldAddTwoNumber() {
        BigDecimal x= new BigDecimal(10);
        BigDecimal y = new BigDecimal(5);
        String operator = "+";
        Params param = new Params(x,y,operator);
        assertEquals(cal.calculate(param).getValue(), Optional.of(new BigDecimal(15)));
    }

    @Test
    public void ShouldMinusTwoNumber() {
        BigDecimal x= new BigDecimal(10);
        BigDecimal y = new BigDecimal(5);
        String operator = "-";
        Params param = new Params(x,y,operator);
        assertEquals(cal.calculate(param).getValue(), Optional.of(new BigDecimal(5)));
    }

    @Test
    public void ShouldTimesTwoNumber() {
        BigDecimal x= new BigDecimal(10);
        BigDecimal y = new BigDecimal(5);
        String operator = "*";
        Params param = new Params(x,y,operator);
        assertEquals(cal.calculate(param).getValue(), Optional.of(new BigDecimal(50)));
    }

    @Test
    public void ShouldDivideTwoNumber() {
        BigDecimal x= new BigDecimal(10);
        BigDecimal y = new BigDecimal(5);
        String operator = "/";
        Params param = new Params(x,y,operator);
        assertEquals(cal.calculate(param).getValue(), Optional.of(new BigDecimal(2)));
    }

    @Test
    public void ShouldNotDivide0() {
        BigDecimal x= new BigDecimal(10);
        BigDecimal y = new BigDecimal(0);
        String operator = "/";
        Params param = new Params(x,y,operator);
//        assertEquals(cal.calculate(param).getValue(), Optional.empty());
        assertEquals(cal.calculate(param).getStatus(), Status.ARITHMETIC_ERROR);
    }

    @Test
    public void ShouldAskUserToInputCorrectOperator() {
        BigDecimal x= new BigDecimal(10);
        BigDecimal y = new BigDecimal(5);
        String operator = "gfd";
        Params param = new Params(x,y,operator);
//        assertEquals(cal.calculate(param).getValue(), Optional.empty());
        assertEquals("Please Enter + - * /",cal.calculate(param).getStatusMessage());
    }



}
