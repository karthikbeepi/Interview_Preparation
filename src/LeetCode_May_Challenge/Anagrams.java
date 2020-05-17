package LeetCode_May_Challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        if(s.length()<p.length())
            return list;
        HashMap<Character, Integer> pMap = getMap(p);
        HashMap<Character, Integer> tempMap = getMap(s.substring(0, p.length()));
        if(tempMap.equals(pMap))
                list.add(0);
        for(int i=1; i<s.length()-p.length()+1; i++) {
            int val = tempMap.get(s.charAt(i-1));
            val--;
            if(val==0) {
                tempMap.remove(s.charAt(i-1));
            } else {
                tempMap.put(s.charAt(i-1), val);
            }
            val = tempMap.getOrDefault(s.charAt(i+p.length()-1), 0);
            val++;
            tempMap.put(s.charAt(i+p.length()-1), val);
            if(tempMap.equals(pMap))
                list.add(i);
        }
        return list;
    }

    // Get hashmap for the string character counts
    private HashMap<Character, Integer> getMap(String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()) {
            int val = map.getOrDefault(c, 0);
            val++;
            map.put(c, val);
        }
		return map;
	}

	public static void main(String[] args) {
        Anagrams ob = new Anagrams();
        List<Integer> l = ob.findAnagrams("cbaebabacd", "abc");
        for(int i: l) {
            System.out.print(i);
        }
        System.out.println();
        l = ob.findAnagrams("abab", "ab");
        for(int i: l) {
            System.out.print(i);
        }
        System.out.println();
    }

}