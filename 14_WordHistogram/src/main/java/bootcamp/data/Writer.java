package bootcamp.data;

import bootcamp.io.HistogramWriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Writer extends HistogramWriter {
    public Writer(OutputStream outStream) {
        super(outStream);
    }

    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(super.getOutStream()))) {
            for (Map.Entry<String, Integer> entry : histogram.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new Result<>(Status.IO_EXCEPTION, "Writing error");
        }

        return new Result<>();
    }
}
