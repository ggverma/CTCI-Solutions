import java.util.Scanner;

class StringRotationHelper{
	public boolean isRotation(String s1,String s2) {
		
		if(s1.length() != s2.length()) return false;
		
		s1 += s1;
		
		int i, j;
		
		for( i = 0, j = 0 ; i < s2.length() && j < s1.length(); ){
			if(s1.charAt(j) != s2.charAt(i)){
				j++;
			}else{
				i++;
				j++;
			}
		}
		
		if(i == s2.length())
			return true;
		return false;
	}
}

public class StringRotation_1_9 {
	
	static private Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		String userString1 = sc.nextLine();
		String userString2 = sc.nextLine();
		
		StringRotationHelper myHelper = new StringRotationHelper();
		
		if(myHelper.isRotation(userString1, userString2)){
			System.out.println("ROTATION");
		}else{
			System.out.println("NOT A ROTATION");
		}
	}

}
