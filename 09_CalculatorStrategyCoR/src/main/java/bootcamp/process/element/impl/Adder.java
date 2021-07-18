package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Adder extends ElementFactory implements ProcessingElement{


    public Adder(String operator, ElementFactory nextFactory) {
        super(operator, nextFactory);
    }

    public Adder(String operator) {
        super(operator);
    }

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.add(y);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return this;
    }
}
