class ZeroMatrixHelper{
	
	private int[][] nullifyRow(int[][] my2DMatrix, int rowNum, int numberOfColumns){
		
		for(int i = 0 ; i < numberOfColumns ; i++){
			my2DMatrix[rowNum][i] = 0;
		}
		
		return my2DMatrix;
	}
	
	private int[][] nullifyColumn(int[][] my2DMatrix, int colNum, int numberOfRows){
		
		for(int i = 0 ; i < numberOfRows ; i++){
			my2DMatrix[i][colNum] = 0;
		}
		
		return my2DMatrix;
	}
	
	public int[][] formatMatrix(int[][] my2DMatrix, int numberOfRows, int numberOfColumns) {
		boolean firstRowIsZero = false;
		boolean firstColumnIsZero = false;
		
		for(int i = 0 ; i < numberOfRows ; i++){
			if(my2DMatrix[i][0] == 0){
				firstRowIsZero = true;
			}
			my2DMatrix[i][0] = 1;
		}
		for(int i = 0 ; i < numberOfColumns ; i++){
			if(my2DMatrix[0][i] == 0){
				firstColumnIsZero = true;
			}
			my2DMatrix[0][i] = 1;
		}
		
		for(int i = 1 ; i < numberOfRows ; i++){
			for(int j = 1 ; j < numberOfColumns ; j++){
				if(my2DMatrix[i][j] == 0){
					my2DMatrix[0][j] = 0;
					my2DMatrix[i][0] = 0;
				}
			}
		}
		
		for(int i = 0 ; i < numberOfColumns ; i++){
			if(my2DMatrix[0][i] == 0){
				nullifyColumn(my2DMatrix, i, numberOfRows);
			}
		}
		
		for(int i = 0 ; i < numberOfRows ; i++){
			if(my2DMatrix[i][0] == 0){
				nullifyRow(my2DMatrix, i, numberOfColumns);
			}
		}
		
		if(firstColumnIsZero){
			nullifyColumn(my2DMatrix, 0, numberOfRows);
		}
		
		if(firstRowIsZero){
			nullifyRow(my2DMatrix, 0, numberOfColumns);
		}
		
		return my2DMatrix;
	}
}

public class ZeroMatrix_1_8 {
	
	static int[][] create_0_1_Matrix(int numberOfRows, int numberOfColumns){
		int[][] myMatrix = new int[numberOfRows][numberOfColumns];
		
		for(int i = 0 ; i < numberOfRows ; i++){
			for(int j = 0 ; j < numberOfColumns ; j++){
				myMatrix[i][j] = (int)(Math.random() * 100) < 80 ? 1 : 0 ;
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
	
	public static void main(String[] args){
		int numberOfRows = 10;
		int numberOfColumns = 12;
		
		int[][] my2DMatrix = create_0_1_Matrix(numberOfRows, numberOfColumns);
		
		printPrettyMatrix(my2DMatrix, numberOfRows, numberOfColumns);
		System.out.println();System.out.println();
		ZeroMatrixHelper zeroMatrixHelper = new ZeroMatrixHelper();
		
		zeroMatrixHelper.formatMatrix(my2DMatrix, numberOfRows, numberOfColumns);
		
		printPrettyMatrix(my2DMatrix, numberOfRows, numberOfColumns);
		
		
	}
}
