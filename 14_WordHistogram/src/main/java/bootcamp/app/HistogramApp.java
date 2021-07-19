package bootcamp.app;

import bootcamp.data.Reader;
import bootcamp.data.Result;
import bootcamp.data.Writer;
import bootcamp.process.HistogramProcessor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HistogramApp {
    public static void main(final String[] args) {


        try (FileInputStream in = new FileInputStream("D:\\JavaProjects\\JavaBootcamp-master\\14_WordHistogram\\src\\main\\java\\bootcamp\\app\\input.txt");
             FileOutputStream out = new FileOutputStream("D:\\JavaProjects\\JavaBootcamp-master\\14_WordHistogram\\src\\main\\java\\bootcamp\\app\\output.txt")){
            HistogramProcessor processor = new HistogramProcessor();
            Result<?> result = processor.process(new Reader(in), new Writer(out));
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }

