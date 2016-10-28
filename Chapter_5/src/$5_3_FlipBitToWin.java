import java.util.Scanner;

class FBTWHelper{
	public int getLongest1s(int num){
		int max = Integer.MIN_VALUE; // max 1s
		
		int r2 = 0, r1 = 0; // r1 = current r2 = 1s after encountering any 0
		
		while(num > 0){
			if((num & 1) == 1){
				r1++;
				r2++;
			}else{
				if(r1 > max) max = r1;
				r1 = r2;
				r2 = 0;
				r1++;
			}
			num = num >>> 1;
		}
		
		if(r1 > max) max = r1;
		
		return max;
	}
}

public class $5_3_FlipBitToWin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println(new FBTWHelper().getLongest1s(num));
	}

}
