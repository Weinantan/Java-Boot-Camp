package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.element.ProcessingElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


// TODO this is a Component
@Component
public class Calculator {

    @Qualifier("adder")
    private final ProcessingElement adder;
    @Qualifier("subtractor")
    private final ProcessingElement subtractor ;
    @Qualifier("multiplier")
    private final ProcessingElement multiplier ;
    @Qualifier("divider")
    private final ProcessingElement divider ;

    @Autowired
    public Calculator(Adder adder,Subtractor subtractor, Multiplier multiplier, Divider divider )
//            /* TODO Use qualifier to get adder by name */ ProcessingElement adder,
//            /* TODO Use qualifier to get subtractor by name */ ProcessingElement subtractor,
//            /* TODO Use qualifier to get multiplier by name */ ProcessingElement multiplier,
//            /* TODO Use qualifier to get divider by name */ ProcessingElement divider
    {
        this.adder = adder;
        this.subtractor = subtractor;
        this.multiplier = multiplier;
        this.divider = divider;
    }


    public Result calculate(final Params params) {
        // TODO select the processing element using the operator and process the operands.
        return null;
    }
}
