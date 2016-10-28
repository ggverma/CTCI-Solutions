import java.util.Scanner;

class RMHelper{
	public int add(int a, int b){
		return a > b ? minProduct(a, b) : minProduct(b, a);
	}
	
	private int minProduct(int larger, int smaller){
		if(smaller == 0) return 0;
		else if(smaller == 1) return larger;
		
		int s = smaller >> 1;
		int halfProduct = minProduct(larger, s);
		
		if((smaller & 1) == 0){
			//even
			return 2 * halfProduct;
		}else{
			return 2 * halfProduct + larger;
		}
	}
}

public class $8_5_Recursive_Multiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers to be multiplied: ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.println("Sum: " + new RMHelper().add(n1, n2));
	}

}
