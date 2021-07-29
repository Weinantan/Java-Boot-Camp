package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.MapFactory;

import java.util.Optional;

public class Calculator {
    private final ElementFactory factory ;

    public Calculator() {
        this.factory = new MapFactory();

    }

    //TODO Constructor that instantiates and initialises factory.

    public Result calculate(final Params params) {
        //FIXME using the factory and implementations of ProcessingElement

        if (factory.create(params.getOperator()).isPresent()) {
            try {
                return new Result(Status.SUCCESS,"",Optional.ofNullable(factory.create(params.getOperator()).get().process(params.getX(),params.getY())));
            } catch (ArithmeticException e) {
                return new Result(Status.ARITHMETIC_ERROR,"Cannot Divide 0",Optional.empty());
            }}
            else{
              return new Result(Status.INVALID_OPERATION,"Please Enter + - * /",Optional.empty());
            }
        }

    }

