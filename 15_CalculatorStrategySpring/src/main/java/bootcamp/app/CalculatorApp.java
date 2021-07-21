package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the first number");
        BigDecimal x = scanner.nextBigDecimal();
        System.out.println("Please Enter the second number");
        BigDecimal y = scanner.nextBigDecimal();
        System.out.println("Please Enter an Operator (+ - * /)");
        String operator = scanner.next();

//        BigDecimal x = new BigDecimal(10);
//        BigDecimal y = new BigDecimal(5);
//        String operator = "*";
        Params param = new Params(x,y,operator);
        ApplicationContext context = new AnnotationConfigApplicationContext(ElementFactory.class);

        context.getBean("calculator");
        Calculator cal = (Calculator) context.getBean("calculator");
        System.out.println("cal.calculate(param) = " + cal.calculate(param));

    }
}
