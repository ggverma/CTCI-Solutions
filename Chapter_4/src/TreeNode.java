
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

enum NodeState{univisted, visiting, visited};

class MyGraph<T>{
	class MyGraphNode <T>{
		T data;
		NodeState state;
		
		ArrayList<MyGraphNode<T>> children;
		
		public MyGraphNode(T data) {
			// TODO Auto-generated constructor stub
			state = NodeState.univisted;
			this.data = data;
			children = new ArrayList<>();
		}
	}
	
	MyGraphNode<Integer> graphNodes[];
	
	public MyGraph(int adjacencyMatrix[][]) {
		// TODO Auto-generated constructor stub
		
		graphNodes = new MyGraphNode[adjacencyMatrix.length];
		
		for (int i = 0; i < graphNodes.length; i++) {
			graphNodes[i]= new MyGraphNode<Integer>(i);
		}
		
		for(int i = 0 ; i < adjacencyMatrix.length ; i++){
			for(int j = 0 ; j < adjacencyMatrix[0].length ; j++){
				if(i != j && adjacencyMatrix[i][j] == 1){
					graphNodes[i].children.add(graphNodes[j]);
				}
			}
		}
		
		
	}
	
	public void showMyGraph(){
		for (int i = 0; i < graphNodes.length; i++) {
			System.out.println("Node " + graphNodes[i].data + "\nChildren: ");
			for (Iterator<MyGraph<T>.MyGraphNode<Integer>> iterator = graphNodes[i].children.iterator(); iterator.hasNext();) {
				MyGraph<T>.MyGraphNode<Integer> y = iterator.next();
				System.out.print(y.data + " ");
			}
			System.out.println();
		}
	}
	
	public void refreshNodeStates(){
		for(MyGraph<T>.MyGraphNode<Integer> x : graphNodes){
			x.state = NodeState.univisted;
		}
	}
}

class TreeNode<T>{
	T data;
	TreeNode<T> left, right;
	
	public TreeNode(T data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		left = right = null;
	}
}

class EnhancedTree <T>{
	
	EnhacedTreeNode<T> root;
	
	public EnhacedTreeNode<T> makeEnhancedTree(int[] array){
		if(array.length > 0){
			root = new EnhacedTreeNode<>(array[0]);
			EnhacedTreeNode<T> rootC = root;
			for(int i = 1 ; i < array.length ; ){
				
				i = addNode(rootC, array, i);
				rootC = getAnyLeaf(root);
			}
			return root;
		}
		else{
			System.out.println("Empty array! Tree not constructed!");
			return null;
		}
	}
	
	private EnhacedTreeNode<T> getAnyLeaf(EnhacedTreeNode<T> root){
		if(root == null) return null;
		while(true){
			if(Math.random() < 0.5){
				if(root.left == null)
					return root;
				root = root.left;
			}
			else{
				if(root.right == null)
					return root;
				root = root.right;
			}
		}
	}
	
	private int addNode(EnhacedTreeNode<T> root, int[] array, int i){
		
		if(root == null){System.out.println("Root null returning!"); return i;}
		if(i == array.length) return i;
		//System.out.println("i= " + i);
		EnhacedTreeNode<T> leftNode = new EnhacedTreeNode<>(array[i++]);
		leftNode.parent = root;
		root.left = leftNode;
		leftNode.depth = root.depth + 1;
		//System.out.println("Root: " + root.data + " left: "  + leftNode.data);
		//System.out.println("i= " + i); 
		if(i == array.length) return i;
		EnhacedTreeNode<T> rightNode = new EnhacedTreeNode<>(array[i++]);
		rightNode.parent = root;
		root.right = rightNode;
		rightNode.depth = root.depth + 1;
		//System.out.println(" right= " + rightNode.data);
		if(Math.random() < 0.5 )
			i = addNode(root.left, array, i);
		else if(Math.random() < 0.5)
			i = addNode(root.right, array, i);
		
		return i;
	}
	
	public void showTree(){
		LinkedList<EnhacedTreeNode<T>> list = new LinkedList<>();
		list.add(root);
		System.out.println(root.data);
		int oldD = root.depth;
		while(!list.isEmpty()){
			
			EnhacedTreeNode<T> node = list.removeFirst();
			if(node.depth != oldD){
				oldD = node.depth;
				System.out.println();
			}
			if(node.left != null){
				list.add(node.left);
				System.out.print(node.left.data + " ");
			}
			if(node.right != null){
				list.add(node.right);
				System.out.print(node.right.data + " ");
			}
		}
	}
	
	public EnhacedTreeNode<T> getNodeWithData(int data){
		LinkedList<EnhacedTreeNode<T>> list = new LinkedList<>();
		list.add(root);
		while(!list.isEmpty()){
			
			EnhacedTreeNode<T> node = list.removeFirst();
			if(node.data == data){
				return node;
			}
			if(node.left != null){
				list.add(node.left);
			}
			if(node.right != null){
				list.add(node.right);
			}
		}
		return null;
	}
}

class EnhacedTreeNode<T>{
	public EnhacedTreeNode<T> left, right, parent;
	public int data;
	public int depth;
	public EnhacedTreeNode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		left = right = parent = null;
		depth = 0;
	}
}

class AdjacencyMatrix{
	int matrix[][];
	int numNodes;
	
	public AdjacencyMatrix(int numNodes, boolean isDirected) {
		// TODO Auto-generated constructor stub
		this.numNodes = numNodes;
		matrix = new int[numNodes][numNodes];
		
		int columnFillStartAt = 0;
		
		for(int i = 0 ; i < numNodes ; i++){
			for(int j = columnFillStartAt ; j < numNodes ; j++){
				matrix[i][j] = Math.random() * 2 > 0.4 ? 0 : 1;
				if(!isDirected){
					matrix[j][i] = matrix[i][j];
				}
			}
			if(!isDirected) columnFillStartAt++;
		}
	}
	
	public int[][] getAdjacencyMatrix(){
		return matrix;
	}
	
	public void printAdjacencyMatrix(){
		for(int i = 0 ; i < numNodes ; i++){
			for(int j = 0 ; j < numNodes ; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}