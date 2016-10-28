import java.util.Scanner;

class StringCompressionHelper{
	public String formatString(String userString) {
		StringBuilder stringBuilt = new StringBuilder();
		
		char lastCharacter = userString.charAt(0);
		
		int lastCharacterCount = 1;
		for(char newCharacter : userString.substring(1).toCharArray()){
			if(newCharacter == lastCharacter){
				lastCharacterCount++;
			}else{
				stringBuilt.append(lastCharacter).append(lastCharacterCount);
				lastCharacter = newCharacter;
				lastCharacterCount = 1;
			}
		}
		
		stringBuilt.append(lastCharacter).append(lastCharacterCount);
		
		return stringBuilt.toString();
	}
}

public class StringCompression_1_6 {

	static private Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		System.out.print("Enter your string: ");
		
		String userString = sc.nextLine();
		
		StringCompressionHelper myStringCompressionHelper = new StringCompressionHelper(); 
		
		String userFormatString = myStringCompressionHelper.formatString(userString);
		
		if(userFormatString.length() < userString.length()){
			System.out.println(userFormatString);
		}else{
			System.out.println(userString);
		}
	}

}
