import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class PWithDupsHelper{
	public ArrayList<String> getPerms(String str){
		ArrayList<String> result = new ArrayList<>();
		HashMap<Character, Integer> map = makeMap(str);
		printPerms(map, "", str.length(), result);
		return result;
	}
	
	private HashMap<Character, Integer> makeMap(String str){
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : str.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			}else{
				map.put(c, 1);
			}
		}
		return map;
	}
	
	private void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result){
		if(remaining == 0){
			result.add(prefix);
			return;
		}
		
		for(char c : map.keySet()){
			int count = map.get(c);
			if(count > 0){
				map.put(c, map.get(c) - 1);
				printPerms(map, prefix + c, remaining - 1, result);
				map.put(c, count);
			}
		}
	}
}

public class $8_8_Permutation_With_Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = sc.nextLine();
		System.out.println("Permutations: " + new PWithDupsHelper().getPerms(str));
	}

}
