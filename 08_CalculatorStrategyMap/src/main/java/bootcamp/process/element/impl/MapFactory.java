package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class MapFactory extends ElementFactory {

    @Override
    public Optional<ProcessingElement> create(String operator) {
        switch(operator){
            case "+" : {
              return Optional.ofNullable(elementMap.get("Adder"));
            }
            case "-" : {
                return Optional.ofNullable(elementMap.get("Subtractor"));
            }
            case "*" : {
                return Optional.ofNullable(elementMap.get("Multiplier"));
            }
            case "/" : {
                return Optional.ofNullable(elementMap.get("Divider"));
            }
            default:
                return Optional.empty();
        }
    }

    }

//    @Override
//    public Optional<ProcessingElement> create(String operator) {
//        if (operator.equals("+")) {
//            elementMap.put("+",new Adder());
//            return Optional.of(new Adder());
//        } else if (operator.equals("-")) {
//            return Optional.of(new Subtractor());
//        } else if (operator.equals("*")) {
//            return Optional.of(new Multiplier());
//        } else if (operator.equals("/")) {
//            return Optional.of(new Divider());
//        } else {
//            return Optional.empty();
//        }
//    }

