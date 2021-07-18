package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Divider  extends ElementFactory implements ProcessingElement {

    public Divider(String operator, ElementFactory nextFactory) {
        super(operator, nextFactory);
    }

    public Divider(String operator) {
        super(operator);
    }

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        if (y.equals(0)){
            throw new ArithmeticException();
        }else{
            return x.divide(y);
        }
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return this ;
    }
}

