class LRDepth{
	int lD;
	int rD;
	boolean isBalanced;
	
	public LRDepth(int lD, int rD, boolean isBalanced) {
		// TODO Auto-generated constructor stub
		this.lD = lD;
		this.rD = rD;
		this.isBalanced = isBalanced;
	}
}

class CheckBalancedHelper{
	private boolean isTreeBalanced;
	
	public CheckBalancedHelper() {
		// TODO Auto-generated constructor stub
		isTreeBalanced = true;
	}
	
	public int checkLeftRightDepth(TreeNode<Integer> node){
		if(!isTreeBalanced) return Integer.MIN_VALUE;
		if(node == null) return 0;
		
		int leftDepth, rightDepth;
		leftDepth = rightDepth = 0;
		
		if(node.left != null){
			leftDepth += checkLeftRightDepth(node.left) + 1;
		}
		
		if(node.right != null)
			rightDepth += checkLeftRightDepth(node.right) + 1;
		
		if(Math.abs(rightDepth - leftDepth) > 1){
			isTreeBalanced = false;
			return Integer.MIN_VALUE;
		}
		
		return Math.max(leftDepth, rightDepth);
	}
}

public class CheckBalanced_4_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MinimalTreeHelper minimalTreeHelper = new MinimalTreeHelper();
		
		CheckBalancedHelper checkBalancedHelper = new CheckBalancedHelper();
		
		int arraySize = 10;
		
		int array[] = new int[arraySize];
		
		for(int i = 0 ; i < arraySize ; i++){
			array[i] = i;
		}
		
		//TreeNode<Integer> root = minimalTreeHelper.constructTree(array);
		TreeNode<Integer> root = new TreeNode<Integer>(5);
		root.left = new TreeNode<Integer>(3);
		root.right = new TreeNode<Integer>(4);
		root.left.left = new TreeNode<Integer>(2);
		root.left.right = new TreeNode<Integer>(1);
		root.left.left.left = new TreeNode<Integer>(8);
		
		if(checkBalancedHelper.checkLeftRightDepth(root) != Integer.MIN_VALUE){
			System.out.println("Balanced");
		}else{
			System.out.println("UNBalanced");
		}
	}

}
