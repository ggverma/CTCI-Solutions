class ValidateBSTHelper{
	
	public boolean checkBST(TreeNode<Integer> node){
		return checkBST(node, null, null);
	}
	
	public boolean checkBST(TreeNode<Integer> node, Integer min, Integer max){
		if(node == null) return true;
		
		if((min != null && node.data <= min) || (max != null && node.data > max)){
			return false;
		}
		
		if(!checkBST(node.left, min, node.data) || !checkBST(node.right, node.data, max)){
			return false;
		}
		
		return true;
	}
}

public class ValidateBST_4_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimalTreeHelper minimalTreeHelper = new MinimalTreeHelper();
		
		ValidateBSTHelper validateBSTHelper = new ValidateBSTHelper();
		
		int arraySize = 10;
		
		int array[] = new int[arraySize];
		
		for(int i = 0 ; i < arraySize ; i++){
			//array[i] = arraySize - i; //Invalid BST
			array[i] = i; //Valid BST
		}
		
		TreeNode<Integer> root = minimalTreeHelper.constructTree(array);
		
		if(validateBSTHelper.checkBST(root)){
			System.out.println("Valid BST");
		}else{
			System.out.println("In-Valid BST");
		}
	}

}
