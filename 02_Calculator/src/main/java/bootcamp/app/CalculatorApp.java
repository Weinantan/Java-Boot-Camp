package bootcamp.app;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * TODO: The application should be able to handle 3 arguments (first number, second number, operation).
 * The application should write the results to the standard output.
 */
public class CalculatorApp {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the first Number");
        BigDecimal x = scanner.nextBigDecimal();

        System.out.println("Please Enter the Second Number");
        BigDecimal y = scanner.nextBigDecimal();

        System.out.println("Please Enter a Operation");
        String operator = scanner.next();

        System.out.println("The first Number is " + x + " " + "The second number is " + y + " The operation is " + operator);

        Params params = new Params(x,y,operator);
        Calculator cal = new Calculator();
        System.out.println(cal.calculate(params));
    }
}
