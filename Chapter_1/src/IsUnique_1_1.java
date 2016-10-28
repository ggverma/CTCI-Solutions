import java.util.HashSet;
import java.util.Scanner;

class StringChecker{
	public boolean isStringUniqueWithAdditionalDS(String userString){
		if(userString.length() > 256){
			return false;
		}
		
		HashSet<Character> stringSet = new HashSet<>();
		for(char c : userString.toCharArray()){
			if(stringSet.contains(c)){
				return false;
			}else{
				stringSet.add(c);
			}
		}
		return true;
	}
	
	public boolean isStringUniqueWithNoAdditionalDS(String userString) {
		if(userString.length() > 256){
			return false;
		}
		
		int i = 1;
		for(char c1 : userString.toCharArray()){
			for(char c2 : userString.substring(i).toCharArray()){
				if(c1 == c2){
					return false;
				}
			}
			i++;
		}
		return true;
	}
	
	public boolean isStringUniqueWithIntergerCheck(String userString) {
		if(userString.length() > 26){
			return false;
		}
		
		int checker = 0;
		
		for(char c : userString.toCharArray()){
			if((checker & (1 << (c - 'a'))) > 0){
				return false;
			}
			checker |= (1 << (c - 'a'));
		}
		
		return true;
	}
}

public class IsUnique_1_1 {
	private static Scanner sc;

	public static void main(String[] args){
		sc = new Scanner(System.in);
		
		System.out.println("Enter your String: ");
		
		String userString  = sc.nextLine();
		
		StringChecker stringChecker = new StringChecker();
		
		System.out.print("Using Additional DS of HashSet: ");
		if(stringChecker.isStringUniqueWithAdditionalDS(userString)){
			System.out.println("The string is Unique!");
		}else{
			System.out.println("The string contains duplicates!");
		}
		
		System.out.print("Using no Additional DS: ");
		if(stringChecker.isStringUniqueWithNoAdditionalDS(userString)){
			System.out.println("The string is Unique!");
		}else{
			System.out.println("The string contains duplicates!");
		}
		
		System.out.print("Using Integer: ");
		if(stringChecker.isStringUniqueWithIntergerCheck(userString)){
			System.out.println("The string is Unique!");
		}else{
			System.out.println("The string contains duplicates!");
		}
	}
}
