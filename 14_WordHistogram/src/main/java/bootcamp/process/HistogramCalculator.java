package bootcamp.process;



import java.util.*;

public class HistogramCalculator {
    public Map<String, Integer> calculate(final List<String> words) {
        //TODO implement
        //Set up a map.
        //loop through the list, and count the occurrence.

       Map<String,Integer> map = new HashMap<>();
        for (String s : words){
            Integer x = map.get(s);
            map.put(s,(x == null) ? 1 : x+1);
        }
        return map;
    }
}
