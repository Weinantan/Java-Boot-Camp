package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.MapFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please Enter the first number");
//        BigDecimal x = scanner.nextBigDecimal();
//        System.out.println("Please Enter the second number");
//        BigDecimal y = scanner.nextBigDecimal();
//        System.out.println("Please Enter an Operator (+ - * /)");
//        String operator = scanner.next();


        BigDecimal x = new BigDecimal(10);

        BigDecimal y = new BigDecimal(5);
        String operator = "*";

        Params params = new Params(x, y, operator);
        Map<String, ProcessingElement> elementMap = new HashMap<>();
        MapFactory factory = new MapFactory(elementMap);

        factory.create(operator);
        Calculator cal = new Calculator(factory);

        Result result = cal.calculate(params);
        System.out.println("*******************************");
        System.out.println(result.toString());

    }
}
