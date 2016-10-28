import java.util.ArrayList;
import java.util.LinkedList;

class BSTSeqHelper{
	
	public ArrayList<LinkedList<Integer>> allSequences(TreeNode<Integer> node){
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if(node == null){
			result.add(new LinkedList<Integer>());
			return result;
		}
		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(node.data);
		
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		for(LinkedList<Integer> left : leftSeq){
			for(LinkedList<Integer> right : rightSeq){
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}
	
	private void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
		//System.out.println(first.size() + " " + second.size());
		if(first.size() == 0 || second.size() == 0){
			LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}
}

public class BSTSequences_4_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimalTreeHelper minimalTreeHelper = new MinimalTreeHelper();
		
		int arraySize = 6;
		
		int array[] = new int[arraySize];
		
		for(int i = 0 ; i < arraySize ; i++){
			//array[i] = arraySize - i; //Invalid BST
			array[i] = i; //Valid BST
		}
		
		TreeNode<Integer> root = minimalTreeHelper.constructTree(array);
		//System.out.println("dadas" + root.data);
		BSTSeqHelper bstSeqHelper = new BSTSeqHelper();
		
		ArrayList<LinkedList<Integer>> lists = bstSeqHelper.allSequences(root);
		//System.out.println("dadas");
		for(LinkedList<Integer> list : lists){
			System.out.print("{");
			for(int num : list){
				System.out.print(num + ", ");
			}
			System.out.print("}\n");
		}
	}

}
