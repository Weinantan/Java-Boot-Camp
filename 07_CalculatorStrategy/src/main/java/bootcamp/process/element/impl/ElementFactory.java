package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class ElementFactory implements bootcamp.process.element.ElementFactory {

    @Override
    public Optional<ProcessingElement> create(String operator) {
        Optional<ProcessingElement> optional = Optional.empty();
        if (operator.equals("+")){
            optional = Optional.of(new Adder());
        }else if (operator.equals("-")){
            optional = Optional.of(new Subtractor());
        }else if (operator.equals("*")){
            optional = Optional.of(new Multiplier());
        }else if (operator.equals("/")){
            optional = Optional.of(new Divider());
        }else {
            optional = Optional.empty();
        }
        return optional;

    }
}
