package Google_Leetcode;

public class MaxTimePossible {
    
    public String getMaxPossibleTime(String s){

        String timeSplit[] = s.split(":");
        String maxHour = getMaxHour(timeSplit[0]);
        String maxMin = getMaxMin(timeSplit[1]);
        StringBuilder sb = new StringBuilder();
        sb.append(maxHour);
        sb.append(":");
        sb.append(maxMin);
        return sb.toString();
    }

    private String getMaxMin(String string) {
        char tenMin = string.charAt(0);
        char digitMin = string.charAt(1);

        if(digitMin=='?'){
            if(tenMin=='?')
            {
                tenMin = '5';
                digitMin = '9';
            }
            digitMin='9';
        }

        if(tenMin=='?') {
            tenMin = '5';
        }
        StringBuilder sb = new StringBuilder();
        sb.append(tenMin);
        sb.append(digitMin);
        return sb.toString();
    }

    private String getMaxHour(String string) {
        char tenHour = string.charAt(0);
        char digitHour = string.charAt(1);

        if(digitHour=='?'){
            switch(tenHour){
                case '0':
                case '1':
                    digitHour = '9';
                    break;
                case '2':
                    digitHour = '3';
                    break;
                case '?':
                    tenHour = '2';
                    digitHour ='3';
                    break;
            }
        }

        if(tenHour=='?') {
            switch(digitHour){
                case '0':
                case '1':
                case '2':
                case '3':
                    tenHour = '2';
                    break;
                default: 
                    tenHour = '1';
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(tenHour);
        sb.append(digitHour);

        return sb.toString();
    }

    public static void main(String[] args) {
        MaxTimePossible obj = new MaxTimePossible();
        System.out.println(obj.getMaxPossibleTime("?4:5?"));
        System.out.println(obj.getMaxPossibleTime("23:5?"));
        System.out.println(obj.getMaxPossibleTime("2?:22"));
        System.out.println(obj.getMaxPossibleTime("0?:??"));
        System.out.println(obj.getMaxPossibleTime("??:??"));
        System.out.println(obj.getMaxPossibleTime("2?:5?"));
    }

}