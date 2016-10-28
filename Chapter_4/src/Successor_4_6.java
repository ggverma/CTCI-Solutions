class SuccessorHelper{
	public EnhacedTreeNode<Integer> getSuccessor(EnhacedTreeNode<Integer> node){
		//System.out.println("At node" + node.data);
		if(node == null) return null;
		if(node.right != null){
			return getLeftMostChild(node.right);
		}else{
			EnhacedTreeNode<Integer> q = node;
			EnhacedTreeNode<Integer> x = q.parent;
			
			while(x != null && x.left != q){
				q = x;
				x = x.parent;
			}
			
			return x;
		}
	}
	
	private EnhacedTreeNode<Integer> getLeftMostChild(EnhacedTreeNode<Integer> node){
		//System.out.println("Here At node" + node.data);
		
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
}

public class Successor_4_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuccessorHelper successorHelper = new SuccessorHelper();
		
		EnhacedTreeNode<Integer> root = new EnhacedTreeNode<Integer>(2);
		
		EnhacedTreeNode<Integer> rL = new EnhacedTreeNode<Integer>(1); 
		root.left = rL;
		rL.parent = root;
		EnhacedTreeNode<Integer> rR = new EnhacedTreeNode<Integer>(3); 
		root.right = rR;
		rR.parent = root;
		
		EnhacedTreeNode<Integer> rLL = new EnhacedTreeNode<Integer>(4); 
		rL.left = rLL;
		rLL.parent = rL;
		
		EnhacedTreeNode<Integer> successor = successorHelper.getSuccessor(root); 
		
		if(successor != null)
			System.out.println("Node: " + successor.data);
		else
			System.out.println("No Successor!");
	}

}
