import java.util.Scanner;

class PSHelper{
	public int getSwapped(int num){
		return ( ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1));
	}
}

public class $5_7_Pairwise_Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = sc.nextInt();
		System.out.print("Swapped even and odd bits make: " + new PSHelper().getSwapped(num));
	}

}
