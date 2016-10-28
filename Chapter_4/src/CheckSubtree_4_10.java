class CheckSubtreeHelper{
	public boolean containsTree(TreeNode<Integer> t1, TreeNode<Integer> t2){
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		
		getOrderString(t1, s1);
		getOrderString(t2, s2);
		
		return s1.indexOf(s2.toString()) != -1;
	}
	
	private void getOrderString(TreeNode<Integer> node, StringBuilder sb){
		if(node == null){
			sb.append("X");
			return;
		}
		sb.append(node.data);
		getOrderString(node.left, sb);
		getOrderString(node.right, sb);
	}
	
	public boolean containsTreeAlternative(TreeNode<Integer> t1, TreeNode<Integer> t2){
		if(t2 == null) return true;
		return subTree(t1, t2);
	}
	
	private boolean subTree(TreeNode<Integer> t1, TreeNode<Integer> t2){
		if(t1 == null) return false;
		else if(t1.data == t2.data && matchTree(t1, t2)){
			return true;
		}
		return subTree(t1.left, t2) || subTree(t1.right, t2);
	}
	
	private boolean matchTree(TreeNode<Integer> n1, TreeNode<Integer> n2){
		if(n1 == null && n2 == null){
			return true;
		}else if(n1 == null || n2 == null){
			return false;
		}else if(n1.data != n2.data){
			return false;
		}else{
			return matchTree(n1.left, n2.left) && matchTree(n1.right, n2.right);
		}
	}
}

public class CheckSubtree_4_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimalTreeHelper minimalTreeHelper = new MinimalTreeHelper();
		
		int array1Size = 6;
		int array2Size = 6;
		
		int array1[] = new int[array1Size];
		int array2[] = new int[array2Size];
		
		for(int i = 0 ; i < array1Size ; i++){
			//array[i] = arraySize - i; //Invalid BST
			array1[i] = i; //Valid BST
		}
		for(int i = 0 ; i < array2Size ; i++){
			//array[i] = arraySize - i; //Invalid BST
			array2[i] = i; //Valid BST
		}
		
		TreeNode<Integer> root1 = minimalTreeHelper.constructTree(array1);
		TreeNode<Integer> root2 = minimalTreeHelper.constructTree(array2);
		
		CheckSubtreeHelper checkSubtreeHelper = new CheckSubtreeHelper();
		
		if(checkSubtreeHelper.containsTree(root1, root2)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		
		if(checkSubtreeHelper.containsTreeAlternative(root1, root2)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

}
