package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class CoRFactory extends ElementFactory {
    public CoRFactory(String operator, CoRFactory nextFactory) {
        super(operator,nextFactory);
    }

    public CoRFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        switch(this.getOperator()){
            case "+":
                return new Adder();
            case "-":
                return new Subtractor();
            case "*":
                return new Multiplier();
            case "/":
                return new Divider();
            default:
                return null;
        }
    }
}
