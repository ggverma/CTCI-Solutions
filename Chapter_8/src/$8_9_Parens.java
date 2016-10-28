import java.util.ArrayList;
import java.util.Scanner;

class ParensHelper{
	public ArrayList<String> getParens(int n){
		ArrayList<String> result = new ArrayList<>();
		char[] str = new char[2 * n];
		generateParen(n, n, result, str, 0);
		return result;
	}
	
	private void generateParen(int leftBraces, int rightBraces, ArrayList<String> result, char[] str, int count){
		if(leftBraces < 0 || rightBraces < leftBraces) return;
		
		if(leftBraces == 0 && rightBraces == 0){
			result.add(String.copyValueOf(str));
		}else{
			if(leftBraces > 0){
				str[count] = '(';
				generateParen(leftBraces - 1, rightBraces, result, str, count + 1);
			}
			
			if(rightBraces > leftBraces){
				str[count] = ')';
				generateParen(leftBraces, rightBraces - 1, result, str, count + 1);
			}
		}
	}
}

public class $8_9_Parens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter total number of perfect braces: ");
		int n = sc.nextInt();
		System.out.println("All combinations: " + new ParensHelper().getParens(n));
	}

}
