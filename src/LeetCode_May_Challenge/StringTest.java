package LeetCode_May_Challenge;

public class StringTest {
    
    public static void main(String[] args) {
        String a = new String("hi");
        String b = "hi";
        String c = new String("hi");
        String d = "hi";
        
        boolean val = (a==b) ? true: false;
        boolean val2 = (a==c) ? true: false;
        boolean val3 = (b==d) ? true: false;
        System.out.println(val+" "+val2+" "+val3);
        System.out.println(a.hashCode()+" "+b.hashCode()+" "+c.hashCode()+" "+d.hashCode());

    }
}