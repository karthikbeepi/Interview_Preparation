package LeetCode_May_Challenge;

public class CheckStraightLine {
    
    public boolean checkStraightLine(int[][] coordinates) {
        float initialSlope;
        if((coordinates[1][1]-coordinates[0][1])==0)
            initialSlope = Float.MAX_VALUE;
        else
            initialSlope = (coordinates[1][0] - coordinates[0][0])/(coordinates[1][1]-coordinates[0][1]);

        boolean flag = true;

        for(int i=1; i<coordinates.length-1; i++){
            float curSlope;
            if((coordinates[i+1][1]-coordinates[i][1])==0)
                curSlope = Float.MAX_VALUE;
            else 
                curSlope = (coordinates[i+1][0] - coordinates[i][0])/(coordinates[i+1][1]-coordinates[i][1]);
            if(curSlope != initialSlope) {
                flag = false;
                break;
            }
        }
        return flag;

    }

    public static void main(String[] args) {
        CheckStraightLine ob = new CheckStraightLine();
        System.out.println(ob.checkStraightLine(new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
    }

}