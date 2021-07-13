package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactory;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the first number");
        BigDecimal x = scanner.nextBigDecimal();
        System.out.println("Please Enter the second number");
        BigDecimal y = scanner.nextBigDecimal();
        System.out.println("Please Enter an Operator (+ - * /)");
        String operator = scanner.next();


        Params params = new Params(x,y,operator);

        ElementFactory factory = new ElementFactory();
        factory.create(operator);
        Calculator cal = new Calculator(factory);

        Result result = cal.calculate(params);
        System.out.println("*******************************");
        System.out.println(result.getStatus() +"\n" +  result.getStatusMessage()  + " " +  "\n"+ "The answer is " +  result.getValue());



    }
}
