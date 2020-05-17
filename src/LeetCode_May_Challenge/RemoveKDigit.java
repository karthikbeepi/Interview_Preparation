package LeetCode_May_Challenge;

public class RemoveKDigit {
    public String removeKdigits(String num, int k) {
        
        if(num.length() == k)
            return "0";

        String minString = num;
        while(k>0) {
            long minVal = Long.MAX_VALUE;
            String temp;
            long tempNumVal;
            for(int i=0; i<minString.length()-1; i++) {
                temp = minString.substring(0, i) + minString.substring(i+1);
                tempNumVal = Long.parseLong(temp);
                if(minVal>tempNumVal) {
                    minVal = tempNumVal;
                }
            }
            temp = minString.substring(0, minString.length()-1);
            tempNumVal = Long.parseLong(temp);
            if(minVal>tempNumVal)
                minVal = tempNumVal;
            minString = String.valueOf(minVal);
            k--;
        }
        return minString;
    }

    public static void main(String[] args) {
        RemoveKDigit ob = new RemoveKDigit();
        System.out.println(ob.removeKdigits("1433219", 3));
        System.out.println(ob.removeKdigits("14", 2));
        System.out.println(ob.removeKdigits("10200", 1));
        System.out.println(ob.removeKdigits("112", 1));
    }
}