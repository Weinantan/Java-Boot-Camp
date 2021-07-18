package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;

import bootcamp.process.element.impl.CoRFactory;

import java.math.BigDecimal;
import java.util.Optional;

public class Calculator {
    private final CoRFactory factory ;


    public Calculator() {
        factory = new CoRFactory("+",new CoRFactory("-",
                new CoRFactory("*",new CoRFactory("/"))));
    }
    //TODO Constructor to create ElementFactory Chain of Responsibility.

    public Result calculate(final Params params) {
        Result results;
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
