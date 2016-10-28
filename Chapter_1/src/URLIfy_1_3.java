import java.util.Scanner;

class URLIfyHelper{
	
	public char[] formatString(char[] userStringArray, String userString){
		int pointerLocation = userString.length() + 2 * countSpacesInString(userString);
		
		userStringArray[pointerLocation] = '\0';
		
		pointerLocation--;
		
		for(int i = userString.length() - 1 ; i >= 0 ; i--){
			if(userString.charAt(i) == ' '){
				userStringArray[pointerLocation--] = '0';
				userStringArray[pointerLocation--] = '2';
				userStringArray[pointerLocation--] = '%';
			}else{
				userStringArray[pointerLocation--] = userString.charAt(i);
			}
		}
		
		return userStringArray;
	}
	
	private int countSpacesInString(String userString){
		int count = 0;
		for(char c : userString.toCharArray()){
			if(c == ' ') count++;
		}
		return count;
	}
}

public class URLIfy_1_3 {
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		System.out.print("Please enter your string: ");
		String userString = sc.nextLine();
		
		URLIfyHelper myHelper = new URLIfyHelper();
		
		char[] userStringArray = new char[userString.toCharArray().length + 3 * userString.length()];
		
		String formattedString = new String(myHelper.formatString(userStringArray, userString));
		
		System.out.println("String before format: " + userString);
		System.out.println("String after format: " + formattedString);
	}
}
