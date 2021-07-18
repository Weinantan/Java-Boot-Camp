package bootcamp.process.element;

import java.util.Optional;

public abstract class ElementFactory {
    private final ElementFactory nextFactory ;
    private final String operator ;

    public ElementFactory(String operator,ElementFactory nextFactory) {
        this.nextFactory = nextFactory;
        this.operator = operator;
    }

    public ElementFactory(String operator) {
        this.operator = operator;
        this.nextFactory = null;
    }

    public String getOperator() {
        return operator;
    }


    public  Optional<ProcessingElement> getProcessingElement(final String operator) {
        if (this.operator.equals(operator)){
            return Optional.of(this.getProcessingElement());
        }else if (!this.operator.equals(operator)){
            return this.nextFactory.getProcessingElement(operator);
        }else{
            return Optional.empty();
        }
    }

    public abstract ProcessingElement getProcessingElement();

}
