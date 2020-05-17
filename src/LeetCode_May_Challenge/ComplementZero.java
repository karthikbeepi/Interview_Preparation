package LeetCode_May_Challenge;

public class ComplementZero {
    
    public int findComplement(int num) {
        int i=0;
        if(num==1)
            return 0;
        String s = Integer.toBinaryString(num);
        for(char c: s.toCharArray())
            if(c=='1')
                i++;
        if(i==s.length())
            return 0;
        return i;
    }

    public static void main(String[] args) {
        ComplementZero ob = new ComplementZero();
        System.out.println(ob.findComplement(4));
    }

}