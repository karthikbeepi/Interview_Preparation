package LeetCode_May_Challenge;

public class CountSquare {
    
    public int countSquares(int[][] matrix) {
        int noOfSquares = 0;
        int minSide = (matrix.length<matrix[0].length) ? matrix.length: matrix[0].length;
        for(int i=1; i<=minSide; i++) 
            noOfSquares += countSquareSide(matrix, i);
        return noOfSquares;
    }
    
    private int countSquareSide(int[][] matrix, int sideLength) {
        int noOfSquares = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m-sideLength+1; i++) {
            for(int j=0; j<n-sideLength+1; j++) {
                if(isAllOnes(i, j, sideLength, matrix))
                    noOfSquares++;
            }
        }
        return noOfSquares;
    }

    private boolean isAllOnes(int x, int y, int sideLength, int[][] matrix) {

        if(x+sideLength >matrix.length && y+sideLength>matrix[0].length)
            return false;

        for(int i=x; i<x+sideLength; i++) {
            for(int j=y; j<y+sideLength; j++){
                if(matrix[i][j]!=1)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CountSquare ob = new CountSquare();
        System.out.println(ob.countSquares(new int[][] {
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
        }));
    }

}