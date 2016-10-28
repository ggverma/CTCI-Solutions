import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MagicIndexHelper{
	public int[] makeRandomSortedDistinctElementArray(int length){
		int[] array = new int[length];
		
		Random generator = new Random();
		array[0] = (0 - length) / 4;
		for(int i = 1 ; i < length ; i++){
			array[i] = array[i - 1] + generator.nextInt(3) + 1;
		}
		
		return array;
	}
	
	public int[] makeRandomSortedDuplicateElementArray(int length){
		int[] array = new int[length];
		
		Random generator = new Random();
		array[0] = (0 - length) / 4;
		for(int i = 1 ; i < length ; i++){
			array[i] = array[i - 1] + generator.nextInt(5);
		}
		
		return array;
	}
	
	public int getMagicIndexInNoDuplicates(int[] array, int l, int r){
		if(l > r) return -1;
		int mid = ((l + r) / 2);
		if(array[mid] == mid){
			return mid;
		}else if(array[mid] < mid){
			return getMagicIndexInNoDuplicates(array, mid + 1, r);
		}else{
			return getMagicIndexInNoDuplicates(array, l, mid - 1);
		}
	}
	
	public int getMagicIndexInDuplicates(int[] array, int l, int r){
		if(l > r) return -1;
		int mid = ((l + r) / 2);
		if(array[mid] == mid){
			return mid;
		}
		
		int leftIndex = Math.min(mid - 1, array[mid]);
		int left = getMagicIndexInDuplicates(array, l, leftIndex);
		if(left >= 0) return left;
		
		int rightIndex = Math.max(mid + 1, array[mid]);
		int right = getMagicIndexInNoDuplicates(array, rightIndex, r);
		
		return right;
	}
}

public class $8_3_MagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter array length: ");
		
		int length = sc.nextInt();
		
		MagicIndexHelper helper = new MagicIndexHelper();
		
		int[] array = helper.makeRandomSortedDistinctElementArray(length);
		
		System.out.println("Array: " + Arrays.toString(array));
		
		System.out.println("Magic Index: " + helper.getMagicIndexInNoDuplicates(array, 0, length - 1));
		
		array = helper.makeRandomSortedDuplicateElementArray(length);
		
		System.out.println("\nArray: " + Arrays.toString(array));
		System.out.println("Magic Index: " + helper.getMagicIndexInDuplicates(array, 0, length - 1));
	}

}
