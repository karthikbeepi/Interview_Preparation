package Arrays_and_String;

public class RotateMatrix {

	public static void main(String[] args) {

		RotateMatrix obj = new RotateMatrix();
		int[][] mat = {
				{1, 2, 3, 4, 5},
				{4, 5, 6, 7, 8},
				{7, 8, 9, 1, 2}
		};
		obj.rotate(mat);
		
	}

	private void rotate(int[][] mat) {
		
		int col = mat[0].length;
		int row = mat.length; 
		for(int i=col-1; i>=0; i--) {
			for(int j=0; j<row; j++)
				System.out.print(mat[j][i]+" ");
			System.out.println();
		}
	}

}
