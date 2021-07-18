package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.util.Map;
import java.util.Optional;

public class MapFactory extends bootcamp.process.element.ElementFactory {

    public MapFactory(Map<String, ProcessingElement> elementMap) {
        super(elementMap);
    }



    @Override
    public Optional<ProcessingElement> create(String operator) {
        if (operator.equals("+")) {
           return Optional.ofNullable(elementMap.put("+",new Adder()));
        } else if (operator.equals("-")) {
            return Optional.ofNullable(elementMap.put("-",new Subtractor()));
        } else if (operator.equals("*")) {
            return Optional.ofNullable(elementMap.put("*",new Multiplier()));
        } else if (operator.equals("/")) {
            return Optional.ofNullable(elementMap.put("/",new Divider()));
        } else {
            return Optional.empty();
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
}
