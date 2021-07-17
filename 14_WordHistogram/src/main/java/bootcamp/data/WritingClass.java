package bootcamp.data;

import bootcamp.io.HistogramWriter;

import java.io.OutputStream;
import java.util.Map;

public class WritingClass extends HistogramWriter {
    public WritingClass(OutputStream outStream) {
        super(outStream);
    }

    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram) {
        return null;
    }
}
