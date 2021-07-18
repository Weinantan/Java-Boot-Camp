package bootcamp.data;

import bootcamp.io.HistogramWriter;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class WritingClass extends HistogramWriter {
    public WritingClass(OutputStream outStream) {
        super(outStream);
    }

    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram) {
        OutputStreamWriter osw = new OutputStreamWriter(getOutStream(), StandardCharsets.UTF_8);

    }
}
