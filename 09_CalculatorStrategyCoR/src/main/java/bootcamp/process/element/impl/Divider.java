package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Divider  implements ProcessingElement {

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        if (y.equals(0)){
            throw new ArithmeticException();
        }else{
            return x.divide(y);
        }
    }

}

