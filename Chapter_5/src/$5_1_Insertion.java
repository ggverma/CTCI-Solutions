/*
 * CTCI
 * 
 * WORKING
 */
import java.util.Scanner;

class InsertionHelper{
	public int getInsertion(int m, int n, int i, int j){// n > m, i <= j
		int mask = ~0; 
		
		mask = mask << (j + 1);
		
		int temp = ((1 << i) - 1);
		
		mask |= temp;
		
		n &= mask;
		System.out.println(n);
		m = m << i;
		
		return n | m;
	}
}

public class $5_1_Insertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int i = sc.nextInt();
		int j = sc.nextInt();
		
		System.out.println(new InsertionHelper().getInsertion(m, n, i, j));
	}

}
