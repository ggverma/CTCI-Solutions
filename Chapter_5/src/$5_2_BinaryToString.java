import java.util.Scanner;

class BTSHelper{
	public String getString(double num){
		if(num >= 1 || num <= 0) return "ERROR";
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for(; i < 32 ; i++){
			num *= 2;
			if(num > 1){
				num -= 1;
				sb.append("1");
			}else if(num < 1){
				sb.append("0");
			}else{
				sb.append(1);
				return sb.toString();
			}
		}
		return "ERROR";
	}
}


public class $5_2_BinaryToString {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		double num = sc.nextDouble();
		
		System.out.println(new BTSHelper().getString(num));
	}
}
