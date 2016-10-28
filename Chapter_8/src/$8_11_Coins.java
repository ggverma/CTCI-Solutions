import java.util.HashMap;
import java.util.Scanner;

class AmountIndexPair{
	int amount;
	int index;
	public AmountIndexPair(int amount, int index) {
		// TODO Auto-generated constructor stub
		this.amount = amount;
		this.index = index;
	}
}

class CoinsHelper{
	public int makeChange(int amount){
		HashMap<AmountIndexPair, Integer> map = new HashMap<>();
		return makeChange(amount, new int[]{25, 10, 5, 1}, 0, map);
	}
	
	private int makeChange(int amount, int[] denoms, int index, HashMap<AmountIndexPair, Integer> map){
		if(map.containsKey(new AmountIndexPair(amount, index))){
			return map.get(new AmountIndexPair(amount, index));
		}
		if(index >= denoms.length - 1) return 1;
		
		int denomAmount = denoms[index];
		int ways = 0;
		for(int i = 0 ; i * denomAmount <= amount ; i++){
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1, map);
		}
		map.put(new AmountIndexPair(amount, index), ways);
		return ways;
	}
}

public class $8_11_Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Coins Avaliable: [25, 10, 5, 1]\nEnter total coins value: ");
		int amount = sc.nextInt();
		System.out.println("Total ways: " + new CoinsHelper().makeChange(amount));
	}

}
