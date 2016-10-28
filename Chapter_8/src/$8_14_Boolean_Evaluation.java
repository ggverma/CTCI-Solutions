import java.util.HashMap;
import java.util.Scanner;

class BEHelper{
	public int getWaysForResult(String expr, boolean result, HashMap<String, Integer> memo){
		if(expr.length() == 0) return 0;
		if(expr.length() == 1) return strToBool(expr) == result ? 1 : 0;
		if(memo.containsKey(result + expr)) return memo.get(result + expr);
		
		int ways = 0;
		
		for(int i = 1; i < expr.length() ; i += 2){
			String left = expr.substring(0, i);
			String right = expr.substring(i + 1);
			
			int leftTrue = getWaysForResult(left, true, memo);
			int leftfalse = getWaysForResult(left, false, memo);
			
			int rightTrue = getWaysForResult(right, true, memo);
			int rightFalse = getWaysForResult(right, false, memo);
			
			int total = (leftfalse + leftTrue) * (rightFalse + rightTrue);
			
			int totalTrue = 0;
			
			char c = expr.charAt(i);
			
			if(c == '^'){
				totalTrue = leftTrue * rightFalse + leftfalse * rightTrue;
			}else if(c == '|'){
				totalTrue = leftTrue * rightFalse + leftfalse * rightTrue + leftTrue * rightTrue;
			}else{
				totalTrue = leftTrue * rightTrue;
			}
			
			int subWays = result ? totalTrue : total - totalTrue;	
			
			ways += subWays;
			}
		memo.put(result + expr, ways);
		return ways;
	}
	
	
	private boolean strToBool(String s){
		if(s.charAt(0) == 0){
			return false;
		}else{
			return true;
		}
	}
}

public class $8_14_Boolean_Evaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your expression: ");
		String expr = sc.nextLine();
		System.out.print("Enter your boolean result : ");
		boolean result = sc.nextBoolean();
		System.out.println("Total ways: " + new BEHelper().getWaysForResult(expr, result, new HashMap<String, Integer>()));
	}

}
