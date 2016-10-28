import java.util.Scanner;

class OneAwayHelper{
	
	public boolean areStringsOneAway(String s1, String s2) {
		if(s1.length() == s2.length()){
			return checkForEdit(s1, s2);	//Strings are of equal length. Hence, can only be replacements if One Away.
		}else if(Math.abs(s1.length() - s2.length()) == 1){	//Strings are of unequal length. Hence, can only be one edit One Away if the difference between their lengths is 1.
			if(s1.length() > s2.length()){
				return checkForEdit(s1, s2);
			}else{
				return checkForEdit(s2, s1);
			}
		}
		return false;
	}
	
	private boolean checkForEdit(String s1, String s2) {
		
		int maxEditAway = 1;//Maximum edits allowed.
		
		int maxReplacements = 1;	//Maximum number of replacements allowed.
		
		int currentReplacements = 0;	//There are no replacements encountered initially.
		
		for(int i = 0, j = 0 ; i < s2.length() && j < s1.length() ; ){	//i points in the smaller string s2 and j points in the larger string s1.
			if(s2.charAt(i) != s1.charAt(j)){
				currentReplacements++;
				if(currentReplacements > maxReplacements){
					return false;
				}
				
				j++;
				if(j - i > maxEditAway){	//If edits become greater than allowed edits, the answer is no.
					return false;
				}
			}else{
				i++;
				j++;
			}
		}
		return true;
	}
}

public class OneAway_1_5 {
	
	static private Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		System.out.print("Please enter 1st string: ");
		String userString1 = sc.nextLine();
		
		System.out.print("Please enter 2nd string: ");
		String userString2 = sc.nextLine();
		
		OneAwayHelper oneAwayHelper = new OneAwayHelper();
		
		if(oneAwayHelper.areStringsOneAway(userString1, userString2)){
			System.out.println("Strings are ONE AWAY!");
		}else{
			System.out.println("Strings are NOT ONE AWAY!");
		}
	}

}
