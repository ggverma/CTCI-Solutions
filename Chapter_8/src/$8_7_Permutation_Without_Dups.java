import java.util.ArrayList;
import java.util.Scanner;

class PWDHelper{
	public ArrayList<String> getPermutations(String string){
		if(string == null) return null;
		
		ArrayList<String> permutations = new ArrayList<>();
		
		if(string.length() == 0){
			permutations.add("");
			return permutations;
		}
		
		char first = string.charAt(0);
		String rem = string.substring(1);
		ArrayList<String> words = getPermutations(rem);
		for(String word : words){
			for(int j = 0 ; j <= word.length() ; j++){
				permutations.add(insertCharAt(word, first, j));
			}
		}
		
		return permutations;
	}
	
	private String insertCharAt(String word, char c, int i){
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
}

public class $8_7_Permutation_Without_Dups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the unique string: ");
		String string = sc.nextLine();
		System.out.println("Permutations: " + new PWDHelper().getPermutations(string));
	}

}

