package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

public class ElementFactory extends bootcamp.process.element.ElementFactory {
    public ElementFactory(bootcamp.process.element.ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    public ElementFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        if ()
    }
}
