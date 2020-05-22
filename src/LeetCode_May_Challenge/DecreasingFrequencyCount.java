package LeetCode_May_Challenge;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DecreasingFrequencyCount {
    
    public String frequencySort(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char c: s.toCharArray()) {
            int val = charMap.getOrDefault(c, 0);
            val++;
            charMap.put(c, val);    
        }

        // Create a list from elements of HashMap 
        List<Map.Entry<Character, Integer> > list = 
               new LinkedList<Map.Entry<Character, Integer> >(charMap.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() { 
            public int compare(Map.Entry<Character, Integer> o1,  
                               Map.Entry<Character, Integer> o2) 
            { 
                return -(o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> aa : list) { 
            for(int i=0; i<aa.getValue(); i++)
                sb.append(aa.getKey());
        } 
        return sb.toString(); 
    }

    public static void main(String[] args) {
        DecreasingFrequencyCount ob = new DecreasingFrequencyCount();
        System.out.println(ob.frequencySort("tree"));
        System.out.println(ob.frequencySort("hello"));
    }

}