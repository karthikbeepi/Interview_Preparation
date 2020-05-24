package LeetCode_May_Challenge;

import java.util.ArrayList;
import java.util.List;

public class Overlapping {

    class Interval {
        int start, end;

        Interval(int i, int j) {
            start = i;
            end = j;
        }
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<Interval> intervalIntersect = new ArrayList<>();
        int i=0, j=0;
        while(i<A.length && j<B.length) {
            int a = A[i][0];
            int b = A[i][1];
            int c = B[j][0];
            int d = B[j][1];
            if(c>b || a>d) {
                if(c>b) {
                    i++;
                    continue;
                } else {
                    j++;
                    continue;
                }
            } else {
                if(a<c) {
                    if(b<d) {
                        intervalIntersect.add(new Interval(c, b));
                        i++;
                        continue;
                    } else {
                        intervalIntersect.add(new Interval(c, d));
                        j++;
                        continue;
                    }
                    
                } else {
                    if(b<d) {
                        intervalIntersect.add(new Interval(a, b));
                        i++;
                        continue;
                    } else {
                        intervalIntersect.add(new Interval(a, d));
                        j++;
                        continue;
                    }
                }
            }
        }

        int[][] intervals = new int[intervalIntersect.size()][2];
        i=0;
        for(Interval k: intervalIntersect) {
            intervals[i][0] = k.start;
            intervals[i][1] = k.end;
            i++;
        }
        return intervals;
        
    }
    public static void main(String[] args) {
        Overlapping ob = new Overlapping();
        int[][] intervalsOverlapped = ob.intervalIntersection(
            new int[][]{
                {0,2},{5,10},{13,23},{24,25}
            }, 
            new int[][]{
                {1,5},{8,12},{15,24},{25,26}
            });
        for(int[] i: intervalsOverlapped){
            System.out.println("["+i[0]+","+i[1]+"]"+" ");
        }
        System.out.println();
    }
}