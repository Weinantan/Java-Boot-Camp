package bootcamp.process.element;

import java.util.Map;
import java.util.Optional;

public abstract class ElementFactory {
    protected final Map<String, ProcessingElement> elementMap ;

    public ElementFactory(Map<String, ProcessingElement> elementMap) {
        this.elementMap = elementMap;
    }

    public abstract Optional<ProcessingElement> create(final String operator);

}
