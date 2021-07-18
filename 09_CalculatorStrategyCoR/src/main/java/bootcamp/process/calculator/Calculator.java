package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.Adder;
import bootcamp.process.element.impl.Divider;
import bootcamp.process.element.impl.Multiplier;
import bootcamp.process.element.impl.Subtractor;

import java.math.BigDecimal;
import java.util.Optional;

public class Calculator {
    private final ElementFactory factory ;


    public Calculator() {
        factory = new Adder("+",new Subtractor("-",
                new Multiplier("*",new Divider("/"))));
    }


    //TODO Constructor to create ElementFactory Chain of Responsibility.

    public Result calculate(final Params params) {
        Result results = null;
        BigDecimal answer = factory.getProcessingElement(params.getOperator()).get().process(params.getX(),params.getY());

        try{
            results = new Result(Status.SUCCESS,"",Optional.of(answer));
        }catch (ArithmeticException e ){
            results = new Result(Status.ARITHMETIC_ERROR,"Can not divide 0",Optional.empty());
        }catch (Exception e){
            results = new Result(Status.INVALID_OPERATION,"Please Enter + - * /", Optional.empty());
        }
        return results;
    }


}
