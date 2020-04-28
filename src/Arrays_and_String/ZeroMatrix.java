package Arrays_and_String;

import java.util.ArrayList;

public class ZeroMatrix {
	
	class Coordinate {
		int x, y;
		public Coordinate(int i, int j) {
			x = i;
			y = j;
		}
	}

	public static void main(String[] args) {

		ZeroMatrix obj = new ZeroMatrix();
		int[][] mat = {
				{1, 0, 3, 1, 5},
				{4, 5, 0, 7, 8},
				{7, 8, 9, 1, 2}
		};
		obj.makeZero(mat);
		
	}
	
	public void makeZero(int[][] arr) {
		ArrayList<Coordinate> zeroCoordinates = new ArrayList<ZeroMatrix.Coordinate>();
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[i].length; j++)
			{
				if(arr[i][j]==0)
				{
					zeroCoordinates.add(new Coordinate(i, j));
				}
			}
		}
		for(Coordinate c: zeroCoordinates) {
			for(int i=0; i<arr[c.x].length; i++)
				arr[c.x][i] = 0;
			for(int i=0; i<arr.length; i++)
				arr[i][c.y] = 0;
		}
		
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[i].length; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
	}

}
