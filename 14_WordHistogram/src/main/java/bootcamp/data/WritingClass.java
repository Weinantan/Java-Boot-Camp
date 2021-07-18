package bootcamp.data;

import bootcamp.io.HistogramWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;

public class WritingClass extends HistogramWriter {
    public WritingClass(OutputStream outStream) {
        super(outStream);
    }

    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram) {
        OutputStreamWriter osr = new OutputStreamWriter(getOutStream(), StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osr);

        for (Map.Entry<String,Integer> map : histogram.entrySet()){
            try {
                bw.write( map.getKey() + " " + map.getValue());
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new Result<>(Optional.empty());

    }
}
