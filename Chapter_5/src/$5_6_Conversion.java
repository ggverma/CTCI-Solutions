import java.util.Scanner;

public class $5_6_Conversion {

	private static int minFlips(int n, int m){
		int count = 0;
		for(int c = m ^ n ; c != 0 ; c &= (c - 1)){
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter two numbers: ");
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.print("Minimum flips: " + minFlips(n, m));
	}

}
