import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



class EightQueensHelper{
	private final int GRID_SIZE = 8;
	
	public ArrayList<Integer[]> getQueenLocations(){
		ArrayList<Integer[]> queenLocations = new ArrayList<>();
		getQueenLocations(0, new Integer[8], queenLocations);
		return queenLocations;
	}
	
	private void getQueenLocations(int row, Integer[] columns, ArrayList<Integer[]> results){
		if(row == GRID_SIZE) results.add(columns.clone());
		else{
			for(int col = 0 ; col < GRID_SIZE ; col++){
				if(checkValid(row, col, columns)){
					columns[row] = col;
					getQueenLocations(row + 1, columns, results);
				}
			}
		}
	}
	
	private boolean checkValid(int row1, int col1, Integer[] columns){
		for(int row2 = 0 ; row2 < row1 ; row2++){
			int col2 = columns[row2];
			if(col1 == col2) return false;
			if(Math.abs(col1 - col2) == row1 - row2) return false;
		}
		return true;
	}
}

public class $8_12_Eight_Queens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer[]> queenLocations = new EightQueensHelper().getQueenLocations();
		for(Integer[] queenLocation : queenLocations){
			System.out.println(Arrays.toString(queenLocation));
		}
	}

}
