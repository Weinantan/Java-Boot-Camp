package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Multiplier extends ElementFactory implements ProcessingElement {


    public Multiplier(String operator, ElementFactory nextFactory) {
        super(operator, nextFactory);
    }

    public Multiplier(String operator) {
        super(operator);
    }

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.multiply(y);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return this;
    }
}
