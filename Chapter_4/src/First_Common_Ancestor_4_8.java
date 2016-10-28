class FCAHelper{
	
	public EnhacedTreeNode<Integer> findCOmmonAncestor(EnhacedTreeNode<Integer> a, EnhacedTreeNode<Integer> b){
		if(a == null || b == null){
			System.out.println("Invalid Node Input!");
			return null;
		}
		if(a.depth > b.depth){
			EnhacedTreeNode<Integer> temp = a;
			a = b;
			b = temp;
		}
		int diff = b.depth - a.depth;
		while(diff > 0){
			b = b.parent;
			diff--;
		}
		while(a != b && b != null){
			a = a.parent;
			b = b.parent;
		}
		return b;
	}
	
	public EnhacedTreeNode<Integer> findCommonAncestorOptimized(EnhacedTreeNode<Integer> root, EnhacedTreeNode<Integer> a, EnhacedTreeNode<Integer> b){
		if(!covers(root, a) || !covers(root, b)){
			return null;
		} else if(covers(a, b)){
			return a;
		} else if(covers(b, a)){
			return b;
		}
		
		EnhacedTreeNode<Integer> sibling = getSibling(a);
		EnhacedTreeNode<Integer> parent = a.parent;
		while(!covers(sibling, b)){
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}
	
	private boolean covers(EnhacedTreeNode<Integer> root, EnhacedTreeNode<Integer> a){
		if(root == null) return false;
		if(root  == a) return true;
		return covers(root.left, a) || covers(root.right, a);
	}
	
	private EnhacedTreeNode<Integer> getSibling(EnhacedTreeNode<Integer> node){
		if(node == null || node.parent == null){
			return null;
		}
		
		EnhacedTreeNode<Integer> parent = node.parent;
		
		return parent.left == node ? parent.right : parent.left;
	}
	
	public EnhacedTreeNode<Integer> findCommonAncestorWithoutParents(EnhacedTreeNode<Integer> root, EnhacedTreeNode<Integer> a, EnhacedTreeNode<Integer> b){
		if(!covers(root, a) || !covers(root, b)){
			return null;
		}
		return ancestorHelper(root, a, b);
	}
	
	private EnhacedTreeNode<Integer> ancestorHelper(EnhacedTreeNode<Integer> root, EnhacedTreeNode<Integer> a, EnhacedTreeNode<Integer> b){
		if(root == null || root == a || root == b){
			return root;
		}
		
		boolean aIsOnLeft = covers(root.left, a);
		boolean bIsOnLeft = covers(root.left, b);
		
		if(aIsOnLeft != bIsOnLeft)
			return root;
		
		EnhacedTreeNode<Integer> childSide = aIsOnLeft ? root.left : root.right;
		return ancestorHelper(childSide, a, b);
	}
	
	public EnhacedTreeNode<Integer> findCommonAncestorWithoutParentsOptimized(EnhacedTreeNode<Integer> root, EnhacedTreeNode<Integer> a, EnhacedTreeNode<Integer> b){
		Result r = commonAncHelper(root, a, b);
		if(r.isAnc){
			return r.node;
		}
		return null;
	}
	
	private Result commonAncHelper(EnhacedTreeNode<Integer> root, EnhacedTreeNode<Integer> a, EnhacedTreeNode<Integer> b){
		if(root == null) return new Result(null, false);
		
		if(root == a && root == b){
			return new Result(root, true);
		}
		
		Result rx = commonAncHelper(root.left, a, b);
		if(rx.isAnc){
			return rx;
		}
		Result ry = commonAncHelper(root.right, a, b);
		if(ry.isAnc){
			return ry;
		}
		
		if(rx.node != null && ry.node != null){
			return new Result(root, true);
		}else if(root == a || root == b){
			boolean isAnc = rx.node != null || ry.node != null;
			return new Result(root, isAnc);
		}else{
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
	}
	
	class Result{
		public EnhacedTreeNode<Integer> node;
		public boolean isAnc;
		public Result(EnhacedTreeNode<Integer> node, boolean isA){
			isAnc = isA;
			this.node = node;
		}
	}
}

public class First_Common_Ancestor_4_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnhancedTree<Integer> myTree = new EnhancedTree<>();
		
		int arraySize = 20;
		
		int array[] = new int[arraySize];
		
		for(int i = 0 ; i < arraySize ; i++){
			array[i] = arraySize - i; //Invalid BST
			//array[i] = i; //Valid BST
		}
		
		EnhacedTreeNode<Integer> root = myTree.makeEnhancedTree(array);
		
		int a = 14;
		int b = 5;
		
		FCAHelper fcaHelper = new FCAHelper();
		System.out.println("Binary Tree: ");
		myTree.showTree();
		
		System.out.print("Common Acestor of node-" + a + " and node-" + b + " is " );
		EnhacedTreeNode<Integer> cA = fcaHelper.findCOmmonAncestor(myTree.getNodeWithData(a), myTree.getNodeWithData(b));
		
		if(cA != null){
			System.out.println("node-" + cA.data);
		}else{
			System.out.println("null");
		}
		
		System.out.print("[OPTIMIZED] Common Acestor of node-" + a + " and node-" + b + " is " );
		cA = fcaHelper.findCommonAncestorOptimized(root, myTree.getNodeWithData(a), myTree.getNodeWithData(b));
		
		if(cA != null){
			System.out.println("node-" + cA.data);
		}else{
			System.out.println("null");
		}
		
		System.out.print("[No Parent Link] Common Acestor of node-" + a + " and node-" + b + " is " );
		cA = fcaHelper.findCommonAncestorWithoutParents(root, myTree.getNodeWithData(a), myTree.getNodeWithData(b));
		
		if(cA != null){
			System.out.println("node-" + cA.data);
		}else{
			System.out.println("null");
		}
		
		System.out.print("[No Parent Link Optimized] Common Acestor of node-" + a + " and node-" + b + " is " );
		cA = fcaHelper.findCommonAncestorWithoutParentsOptimized(root, myTree.getNodeWithData(a), myTree.getNodeWithData(b));
		
		if(cA != null){
			System.out.println("node-" + cA.data);
		}else{
			System.out.println("null");
		}
	}

}
