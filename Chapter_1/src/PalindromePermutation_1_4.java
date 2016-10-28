import java.util.HashSet;
import java.util.Scanner;

class PalindromeHelper{
	public boolean isStringPalindrome(String userString) {
		
		HashSet<Character> myHashSet = new HashSet<>();
		
		for(char c : userString.toCharArray()){
			if(c != ' '){
				if(myHashSet.contains(c)){
					myHashSet.remove(c);
				}else{
					myHashSet.add(c);
				}
			}
		}
		
		if(myHashSet.size() > 1){
			return false;
		}
		
		return true;
	}
}

public class PalindromePermutation_1_4 {
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		String userString = sc.nextLine();
		
		PalindromeHelper palindromeHelper = new PalindromeHelper();
		
		if(palindromeHelper.isStringPalindrome(userString)){
			System.out.println("The string is a Palindrome Permutation");
		}else{
			System.out.println("The string is NOT a Palindrome Permutation");
		}
	}

}
