package LeetCode_May_Challenge;

import java.util.ArrayList;
import java.util.HashMap;

public class TruthfulJudge {
    
    public int findJudge(int N, int[][] trust) {

        if(N==1)
            return 1;

        HashMap<Integer, ArrayList<Integer>> judgeConfidence = new HashMap<>();
        ArrayList<Integer> notJudge = new ArrayList<>();
        for(int i=0; i<trust.length; i++) {
            ArrayList<Integer> givenJudge = judgeConfidence.getOrDefault(trust[i][1], new ArrayList<>());
            givenJudge.add(trust[i][0]);
            notJudge.add(trust[i][0]);
            judgeConfidence.put(trust[i][1], givenJudge);
        }   
        for(int i: judgeConfidence.keySet()){
            ArrayList<Integer> givenJudge = judgeConfidence.get(i);
            if(givenJudge.size() == N-1 && !notJudge.contains(i))
                return i;
        }
        return -1;
    }
}