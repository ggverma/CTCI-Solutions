import java.util.Scanner;

class NNHelper{
	public int nextLargestWithSame1s(int num){
		int n = num;
		int c0 = 0, c1 = 0;
		while((n & 1) == 0 && n != 0){
			n = n >>> 1;
			c0++;
		}
		while((n & 1) == 1){
			n = n >>> 1;
			c1++;
		}
		if(c0 + c1 == 31 || c0 + c1 == 0){
			return -1;
		}
		int p = c0 + c1;
		
		num |= (1 << p);
		num &= ~((1<<p) - 1);
		num |= ((1<<(c1 - 1)) - 1);
		return num;		
	}
	
	public int nextSmallestWithSame1s(int num){
		int n = num;
		int c0 = 0, c1 = 0;
		
		while((n & 1) == 1){
			n = n >>> 1;
			c1++;
		}
		
		if(n == 0) return -1;
		
		while((n & 1) == 0 && n != 0){
			n = n>>>1;
			c0++;
		}
		
		int p = c0 + c1;
		
		num &= ((~0)<<(p+1));
		int mask = (1<<(c1 + 1)) - 1;
		num |= mask << (c0 - 1);
		return num;
	}
}

public class $5_4_NextNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		NNHelper nnhelper = new NNHelper();
		
		System.out.println("Next Largest: " + nnhelper.nextLargestWithSame1s(num));
		System.out.println("Next Smallest: " + nnhelper.nextSmallestWithSame1s(num));
	}

}
