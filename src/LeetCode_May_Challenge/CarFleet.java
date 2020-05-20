package LeetCode_May_Challenge;

import java.util.ArrayList;

public class CarFleet {

    class Car {
        int position, speed;
        float time;
        Car(int t, int p, int s) {
            time = (t-p)/s*1.0f;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        
        ArrayList<ArrayList<Car>> fleet = new ArrayList<>();

        return fleet.size();

    }

    public static void main(String[] args) {
        CarFleet ob = new CarFleet();
        System.out.println(ob.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[] {2, 4, 1, 1, 3}));
    }

}