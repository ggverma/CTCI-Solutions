class RotateMatrixHelper{
	public int[][] rotateMatrix(int[][] theMatrix, int numberOfRows){
		for(int layer = 0 ; layer < numberOfRows / 2 ; layer++){
			int first = layer;
			int last = numberOfRows - 1 - layer;
			
			for(int i = first ; i < last ; i++){
				int offset = i - first;
				
				int top = theMatrix[first][i];
				
				theMatrix[first][i] = theMatrix[last - offset][first];
				
				theMatrix[last - offset][first] = theMatrix[last][last - offset];
				
				theMatrix[last][last - offset] = theMatrix[i][last];
				
				theMatrix[i][last] = top;
			}
		}
		return theMatrix;
	}
}

public class RotateMatrix_1_7 {
	
	static int[][] createMatrix(int numberOfRows, int numberOfColumns){
		int[][] myMatrix = new int[numberOfRows][numberOfColumns];
		
		for(int i = 0 ; i < numberOfRows ; i++){
			for(int j = 0 ; j < numberOfColumns ; j++){
				myMatrix[i][j] = i + j;
			}
		}
		
		return myMatrix;
	}
	
	static void printPrettyMatrix(int[][] theMatrix, int numRows, int numCols){
		for(int i = 0 ; i < numRows ; i++){
			for(int j = 0 ; j < numCols ; j++){
				System.out.print(theMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int numberOfRows = 5;
		int numberOfColumns = numberOfRows;
		
		int[][] my2DMatrix = createMatrix(numberOfRows, numberOfColumns);
		
		RotateMatrixHelper rotateMH = new RotateMatrixHelper();
		
		System.out.println("Before Rotating::");
		printPrettyMatrix(my2DMatrix, numberOfRows, numberOfColumns);
		
		my2DMatrix = rotateMH.rotateMatrix(my2DMatrix, numberOfRows);
		
		System.out.println("After Rotating::");
		printPrettyMatrix(my2DMatrix, numberOfRows, numberOfColumns);
	}
}
