package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ProcessingElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;


// TODO this is a Component
@Component
public class Calculator {

    private final ProcessingElement adder;
    private final ProcessingElement subtractor;
    private final ProcessingElement multiplier;
    private final ProcessingElement divider;

    @Autowired
    public Calculator(@Qualifier("adder") ProcessingElement adder, @Qualifier("subtractor") ProcessingElement subtractor, @Qualifier("multiplier") ProcessingElement multiplier, @Qualifier("divider") ProcessingElement divider) {
        this.adder = adder;
        this.subtractor = subtractor;
        this.multiplier = multiplier;
        this.divider = divider;
    }

    public Result calculate(final Params params) {
        //We are just assuming that the returned numbers are the correct answers. What if it returned null? or returned NaN
        //need to think of a way to improve this.
        switch (params.getOperator()) {
            case "+":
            case "-" :
            case "*":
            case "/":
                return new Result(Status.SUCCESS, "", Optional.of(adder.apply(params.getX(), params.getY())));
            default:
                return new Result(Status.INVALID_OPERATION,"Please Enter + - * /", Optional.empty());
        }
    }

}

