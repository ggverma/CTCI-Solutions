import java.util.ArrayList;
import java.util.NoSuchElementException;

class ListOfDepthsHelper{
	ArrayList<ArrayList<Integer>> myListOfLevels;
	
	public ListOfDepthsHelper() {
		// TODO Auto-generated constructor stub
		myListOfLevels = new ArrayList<>();
	}
	
	public ArrayList<ArrayList<Integer>> getDepthWiseList(TreeNode<Integer> root){
		
		if(root == null) throw new NoSuchElementException();
		
		int level = 0;
		
		myListOfLevels.add(new ArrayList<Integer>());
		
		doPreorder(root, level);
		
		return myListOfLevels;
	}
	
	private void doPreorder(TreeNode<Integer> node, int level){
		if(node == null) return;
		
		
		if(myListOfLevels.size() <= level){
			myListOfLevels.add(new ArrayList<Integer>());
		}
		myListOfLevels.get(level).add(node.data);
		
		doPreorder(node.left, level + 1);
		
		doPreorder(node.right, level + 1);
	}
}

public class ListOfDepths_4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimalTreeHelper minimalTreeHelper = new MinimalTreeHelper();
		
		ListOfDepthsHelper listOfDepthsHelper = new ListOfDepthsHelper();
		
		int arraySize = 10;
		
		int array[] = new int[arraySize];
		
		for(int i = 0 ; i < arraySize ; i++){
			array[i] = i;
		}
		
		TreeNode<Integer> root = minimalTreeHelper.constructTree(array);
		
		ArrayList<ArrayList<Integer>> depthList = listOfDepthsHelper.getDepthWiseList(root);
		
		for(ArrayList<Integer> x : depthList){
			
			for(int y : x){
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}

}
