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

public class Reader extends WordReader {
    public Reader(InputStream inStream) {
        super(inStream);
    }

    @Override
    public Result<List<String>> getWords()  {
        List<String> list = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(inStream, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line;
        try{
            line = br.readLine();
            while (line != null){
                String[] str = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                Collections.addAll(list, str);
                line=br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
            return new Result<>(Status.IO_EXCEPTION, "Could not read file");
        }

        if (list.size() == 0){
            return new Result<>(Status.FAILED,"File is empty");
        }
       return new Result<>(Optional.of(list));



    }
}
