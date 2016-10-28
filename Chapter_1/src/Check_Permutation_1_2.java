import java.util.Scanner;

class StringHelper{
	
	public boolean arePermutations(String s1, String s2) {
		if(s1.length() != s2.length()){
			return false;
		}
		
		int[] s1Counts = new int[256];
		
		for(char c : s1.toCharArray()){
			s1Counts[c]++;
		}
		
		for(char c : s2.toCharArray()){
			s1Counts[c]--;
			if(s1Counts[c] < 0){
				return false;
			}
		}
		
		return true;
	}
}

public class Check_Permutation_1_2 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		System.out.print("Please enter first String: ");		
		String userString1 = sc.nextLine();
		
		System.out.print("Please enter second String: ");
		String userString2 = sc.nextLine();
		
		StringHelper myStringHelper = new StringHelper();
		
		if(myStringHelper.arePermutations(userString1, userString2)){
			System.out.println("Strings are permutations!");
		}else{
			System.out.println("Strings are NOT permutations!");
		}
	}

}
