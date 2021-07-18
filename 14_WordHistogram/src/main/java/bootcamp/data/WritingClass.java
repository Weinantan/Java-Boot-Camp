package bootcamp.data;

import bootcamp.io.HistogramWriter;

import java.io.BufferedWriter;
import java.io.IOException;
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
        OutputStreamWriter osr = new OutputStreamWriter(getOutStream(), StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osr);

        for (Map.Entry<String,Integer> map : histogram.entrySet()){
            try {
                bw.write( map.getKey() + " " + map.getValue());
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
                return new Result<>(Status.IO_EXCEPTION,"Writing error");
            }
        }

        return new Result<>();

    }
}
