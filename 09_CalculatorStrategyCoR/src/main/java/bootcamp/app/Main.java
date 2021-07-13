package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please Enter the first number");
//        BigDecimal x = scanner.nextBigDecimal();
//        System.out.println("Please Enter the second number");
//        BigDecimal y = scanner.nextBigDecimal();
//        System.out.println("Please Enter an Operator (+ - * /)");
//        String operator = scanner.next();

//
//        Params params = new Params(x, y, operator);


        BigDecimal x = new BigDecimal(10);
        BigDecimal y = new BigDecimal(5);
        String operator = "/";

        Params params = new Params(x,y,operator);

        Calculator cal = new Calculator();
        Result results = cal.calculate(params);
        System.out.println(results.toString());


//
//
//
//        System.out.println("*******************************");
//        System.out.println(cal.calculate(params).getValue());


    }
}

