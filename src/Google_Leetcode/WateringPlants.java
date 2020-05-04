package Google_Leetcode;

public class WateringPlants {
    
    public static void main(String[] args) {
        WateringPlants obj = new WateringPlants();
        int n = obj.solution(new int[]{2,4,5,1,2}, 1, 7);
        System.out.println(n);
    }

    private int solution(int[] plants, int capacity1, int capacity2) {
        
        int i= 0, j = plants.length-1;
        int initialCap1 = capacity1;
        int initialCap2 = capacity2;
        int waterRefill = 0;

        while(true) {
            if(allPlantsWatered(plants))
                break;
            if(capacity1>=plants[i])
            {
                capacity1 = capacity1-plants[i];
                plants[i] =0;
                i++;
            } else {
                capacity1 = initialCap1;
                waterRefill++;
            }

            if(allPlantsWatered(plants))
                break;
            if(capacity2>=plants[j]){
                capacity2 = capacity2-plants[j];
                plants[j] = 0;
                j--;
            } else {
                capacity2 = initialCap2;
                waterRefill++;
            }

        }

        return waterRefill;
    }

    private boolean allPlantsWatered(int[] plants) {

        for(int i:plants)
            if(i!=0)
                return false;
        return true;
    }
}