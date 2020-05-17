package LeetCode_May_Challenge;

public class Floodfill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int oldColor = image[sr][sc];
        if(newColor==oldColor)
            return image;
        image[sr][sc] = newColor;
        
        if(sr+1<image.length && image[sr+1][sc]==oldColor)
            floodFill(image, sr+1, sc, newColor);
        if(sr-1>=0 && image[sr-1][sc]==oldColor) 
            floodFill(image, sr-1, sc, newColor);
        if(sc+1<image[sr].length && image[sr][sc+1]==oldColor)
            floodFill(image, sr, sc+1, newColor);
        if(sc-1>=0 && image[sr][sc-1]==oldColor)
            floodFill(image, sr, sc-1, newColor);
        return image;
    }

    public static void main(String[] args) {
        Floodfill ob = new Floodfill();
        int[][] p = ob.floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1);
    }
}