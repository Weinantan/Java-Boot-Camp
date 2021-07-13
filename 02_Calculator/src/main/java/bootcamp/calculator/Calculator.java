package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public BigDecimal calculate(final Params params) {
        BigDecimal results ;
        var x = params.getX();
        var y = params.getY();
        var operator = params.getOperator();

        if (operator.equals("+")){
            results = x.add(y);
        }else if (operator.equals("-")){
            results =  x.subtract(y);
        }else if (operator.equals("x")){
            results =  x.multiply(y);
        }else if (operator.equals("/")) {
            results = x.divide(y, RoundingMode.DOWN);
        }else {
            throw new IllegalArgumentException();
        }

//        BigDecimal b1 = new BigDecimal(String.valueOf(results));
//        MathContext m = new MathContext(1);
//        BigDecimal b2 = b1.round(m);

        return results;

    }
}
