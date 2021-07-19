import bootcamp.data.Reader;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.data.Writer;
import bootcamp.process.HistogramCalculator;
import bootcamp.process.HistogramProcessor;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WordHistogramTest {


    @Test
    // this test is to read a file and then put it into a list.
    public void ShouldReadFromFile() {
        String inputString = "my name is wayne";
        Reader reader = new Reader(new ByteArrayInputStream(inputString.getBytes()));
        Result<List<String>> result = reader.getWords();
        List<String> list = result.getValue().get();
        List<String> val = List.of("my", "name", "is", "wayne");
        assertEquals(list, val);
    }

    @Test
    //this should return Status.Success if the files has been successfully written.
    public void ShouldWriteToFiles() {
        ByteArrayOutputStream array = new ByteArrayOutputStream(10);
        Writer writer = new Writer(array);
        Map<String, Integer> map = new HashMap<>();
        map.put("wayne", 5);
        map.put("tan", 2);
        Result<?> result = writer.writeHistogram(map);
        assertEquals(Status.SUCCESS, result.getStatus());
    }

    @Test
    public void ShouldCountTheRepetitionOfWords() {
        List<String> list = List.of("wayne", "tan", "wayne", "tan", "wayne", "tan", "girl", "boy", "boy");
        HistogramCalculator calc = new HistogramCalculator();
        Map<String, Integer> map = calc.calculate(list);
        Map<String, Integer> results = new HashMap<>();
        results.put("wayne", 3);
        results.put("tan", 3);
        results.put("boy", 2);
        results.put("girl",1);
        assertEquals(results, map);
    }


    @Test
    public void ShouldReturnSuccessForProcessor() throws IOException {
        String inputString = "hello world hello";
        Reader reader = new Reader(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream array = new ByteArrayOutputStream(10);
        Writer writer = new Writer(array);
        HistogramProcessor processor = new HistogramProcessor();
        processor.process(reader,writer);
        String results = array.toString();
        assertEquals("world : 1\nhello : 2\n", results);


    }


}
