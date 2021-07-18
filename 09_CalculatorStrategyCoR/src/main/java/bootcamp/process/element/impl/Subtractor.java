package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Subtractor  extends ElementFactory implements ProcessingElement {

    public Subtractor(String operator, ElementFactory nextFactory) {
        super(operator, nextFactory);
    }

    public Subtractor(String operator) {
        super(operator);
    }

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
       return x.subtract(y);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return this;
    }
}
