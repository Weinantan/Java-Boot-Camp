package bootcamp.data;

import bootcamp.io.WordReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReadingWords extends WordReader {
    public ReadingWords(InputStream inStream) {
        super(inStream);
    }

    @Override
    public Result<List<String>> getWords() throws IOException {
        List<String> list = new ArrayList<>();

        InputStreamReader isr = new InputStreamReader(inStream, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line;

        line = br.readLine();
        while (line != null){
            String[] str = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            Collections.addAll(list, str);
            line=br.readLine();
        }
//        String[] str =line.split(" ");
//        list = Arrays.asList(str);

//        int content = inStream.read();
//        while(content != -1){
//            list.add((String) content);
//        }

       return new Result<>(Optional.of(list));



    }
}
