class MinimalTreeHelper{
	
	public void printInorderTree(TreeNode<Integer> root){
		if(root == null) return;
		printInorderTree(root.left);
		System.out.print(root.data + " ");
		printInorderTree(root.right);
	}
	
	public void printPreorderTree(TreeNode<Integer> root){
		if(root == null) return;
		System.out.print(root.data + " ");
		printInorderTree(root.left);
		printInorderTree(root.right);
	}
	
	public void printPostorderTree(TreeNode<Integer> root){
		if(root == null) return;
		printInorderTree(root.left);
		printInorderTree(root.right);
		System.out.print(root.data + " ");
	}
	
	public TreeNode<Integer> constructTree(int array[]){
		return constructTree(array, 0, array.length - 1);
	}
	
	public TreeNode<Integer> constructTree(int array[], int start, int end){
		if(end < start){
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode<Integer> newNode = new TreeNode<Integer>(array[mid]);
		newNode.left = constructTree(array, start, mid - 1);
		newNode.right = constructTree(array, mid + 1, end);
		return newNode;
	}
}

public class MinimalTree_4_2 {
	public static void main(String[] args){
		MinimalTreeHelper testSubject = new MinimalTreeHelper();
		
		int array[] = new int[10];
		
		for(int i = 0 ; i < 10 ; i++){
			array[i] = i;
		}
		
		TreeNode<Integer> root = testSubject.constructTree(array);
		
		System.out.print("In-Order: ");
		testSubject.printInorderTree(root);
		
		System.out.print("\nPre-Order: ");
		testSubject.printPreorderTree(root);
		
		System.out.print("\nPost-Order: ");
		testSubject.printPostorderTree(root);
	}
}
