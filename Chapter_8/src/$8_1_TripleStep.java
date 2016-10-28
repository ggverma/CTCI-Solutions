import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

class TSHelper{
	
	int memo[];
	
	public TSHelper(int steps) {
		// TODO Auto-generated constructor stub
		memo = new int[steps + 1];
		Arrays.fill(memo, -1);
	}
	
	public int getNumberOfWaysToReachSteps(int steps){
		if(steps < 0) return 0;
		else if(steps == 0) return 1;
		else if(memo[steps] > -1) return memo[steps];
		else{
			memo[steps] = getNumberOfWaysToReachSteps(steps - 1) + getNumberOfWaysToReachSteps(steps - 2) + getNumberOfWaysToReachSteps(steps - 3); 
			return memo[steps];
		}
	}
}

public class $8_1_TripleStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of steps: ");
		int steps = sc.nextInt();
		System.out.print("Total number of ways: " + new TSHelper(steps).getNumberOfWaysToReachSteps(steps));
	}

}