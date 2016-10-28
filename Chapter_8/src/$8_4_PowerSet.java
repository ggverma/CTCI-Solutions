import java.util.ArrayList;
import java.util.Scanner;

class PowerSetHelper{
	public ArrayList<Integer> getSet(int size){
		ArrayList<Integer> set = new ArrayList<>();
		for(int i = 0 ; i < size ; i++){
			set.add(i);
		}
		return set;
	}
	
	public ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSubsets;
		if(set.size() == index){
			allSubsets = new ArrayList<>();
			allSubsets.add(new ArrayList<Integer>());
		}else{
			allSubsets = getPowerSet(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
			for(ArrayList<Integer> subsets : allSubsets){
				ArrayList<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subsets);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}
}

public class $8_4_PowerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter set size: ");
		int size = sc.nextInt();
		
		PowerSetHelper helper = new PowerSetHelper();
		
		ArrayList<Integer> set = helper.getSet(size);
		
		System.out.println("Set: " + set);
		System.out.println("Power Set: " + helper.getPowerSet(set, 0));
	}

}
