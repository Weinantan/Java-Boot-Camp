package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Subtractor  implements ProcessingElement {
    public Subtractor() {
    }

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
       return x.subtract(y);
    }
}
