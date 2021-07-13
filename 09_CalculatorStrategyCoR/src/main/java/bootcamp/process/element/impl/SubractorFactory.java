package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class SubractorFactory extends ElementFactory {

    public SubractorFactory(String operator) {
        super(operator);
    }

    public SubractorFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Subtractor();
    }
}
