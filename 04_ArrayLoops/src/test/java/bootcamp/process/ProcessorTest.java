package bootcamp.process;

import bootcamp.data.Processor;
import bootcamp.data.Summary;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessorTest {

    @Test
    public void shouldGetSummaryWithCorrectValuesWhenProcessingValidArray() {
        double [] arr = {1.0,2.0,3.0,4.0,5.0};
        Processor process = new Processor(arr);
        Summary s = process.process();
        assertEquals(new Summary(1.0,5.0,15.0,5.0,3.0),s);
    }


    @Test
    public void shouldGetDefaultSummaryWhenProcessingEmptyArray() {
        double [] arr = {};
        Processor process = new Processor(arr);
        Summary s = process.process();

        assertEquals(new Summary(Double.NaN,Double.NaN,0,0,Double.NaN),s);



    }

    @Test
    public void shouldReturnValueAtGivenArrayIndex() {
        double [] arr = {2.0,4.0,5.0,8.0,10.0,6.0};
        Processor process = new Processor(arr);
        assertEquals(2,process.getValue(1),0);


    }

    @Test
    public void shouldGetExceptionFromGetValueWhenIndexTooLarge() {
        double [] arr = {2.0,4.0,5.0,8.0,10.0,6.0};
        Processor process = new Processor(arr);
//        process.getValue(25);
        double value = process.getValue(25);
        assertEquals(Double.NaN,value,0);
    }
}
