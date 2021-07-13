package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;

import java.util.Optional;

public class Calculator {
    private final ElementFactory factory ;

    public Calculator(ElementFactory factory) {
        this.factory = factory;
    }

    //TODO Constructor that instantiates and initialises factory.

    public Result calculate(final Params params) {
        //FIXME using the factory and implementations of ProcessingElement


        Result results = null;
        try{
            results = new Result(Status.SUCCESS,"",Optional.ofNullable(factory.create(params.getOperator()).get().process(params.getX(),params.getY())));
        }catch (ArithmeticException e ){
            results = new Result(Status.ARITHMETIC_ERROR,"Can not divide 0",Optional.empty());
        }catch (Exception e){
            results = new Result(Status.INVALID_OPERATION,"Please Enter + - * /", Optional.empty());
        }
        return results;

    }


//    public Result calculate(final Params params){
//        Result result;
//
//        try {
////            var x = factory.create(params.getOperator()).get().process(params.getX(),params.getY());
//            result = new Result(Status.SUCCESS,"", Optional.of(factory.create(params.getOperator()).get().process(params.getX(),params.getY())));
//        }catch (ArithmeticException e){
//            result = new Result(Status.ARITHMETIC_ERROR,"Can not divide 0",Optional.empty());
//        }catch(Exception e){
//            result = new Result(Status.INVALID_OPERATION,"Please Enter + - * /", Optional.empty());
//        }
//
//
//        return result;
//    }


}
