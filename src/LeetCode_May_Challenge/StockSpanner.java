package LeetCode_May_Challenge;

import java.util.ArrayList;

public class StockSpanner {
    ArrayList<Integer> elements;
    ArrayList<Integer> span;
    public StockSpanner() {
        elements = new ArrayList<>();
        span = new ArrayList<>();
    }
    
    public int next(int price) {
        if(elements.size()==0) {
            elements.add(price);
            span.add(1);
            return 1;
        } else {
            elements.add(price);
            int counter = 1;
            int i = elements.size()-1;
            while((i-counter)>=0 && elements.get(i) >= elements.get(i-counter)) {
                    counter+= span.get(i-counter);
                }
            span.add(counter);
            return counter;
        }
    }

    public static void main(String[] args) {
        StockSpanner ob = new StockSpanner();
        System.out.println(ob.next(100));
        System.out.println(ob.next(80));
        System.out.println(ob.next(60));
        System.out.println(ob.next(70));
        System.out.println(ob.next(60));
        System.out.println(ob.next(75));
        System.out.println(ob.next(85));
    }

}