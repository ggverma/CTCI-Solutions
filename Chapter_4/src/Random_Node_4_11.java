import java.util.LinkedList;
import java.util.Random;

class RandomTree{
	RandomNode root;
	
	public int size(){
		return root == null ? 0 : root.size;
	}
	
	public RandomNode getRandomNode(){
		if(root == null) return null;
		
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}
	
	public void insertInOrder(int value){
		if(root == null)
			root = new RandomNode(value);
		else
			root.insertInOrder(value);
	}
	
	public void deleteNode(int value){
		if(root.data == value){
			if(root.left == null && root.right == null){
				root = null;
			}else if(root.left == null && root.right != null){
				root = root.right;
				root.decrementDepthOfAll(root);
			}else if(root.left != null && root.right == null){
				root = root.left;
				root.decrementDepthOfAll(root);
			}else{
				if(root.left.size < root.right.size){
					RandomNode newRoot = root.left;
					newRoot.right = root.right;
					newRoot.left = findNextNode(root.left); 
					root = newRoot;
					root.depth--;
				}else{
					RandomNode newRoot = root.right;
					newRoot.left = root.left;
					newRoot.right = findNextNode(root.right); 
					root = newRoot;
					root.depth--;
				}
			}
		}else{
			root.deleteNode(value);
		}
	}
	
	private RandomNode findNextNode(RandomNode node){
		if(node.left == null && node.right == null){
			return null;
		}else if(node.left == null && node.right != null){
			node.decrementDepthOfAll(node.right);
			return node.right;
		}else if(node.left != null && node.right == null){
			node.decrementDepthOfAll(node.left);
			return node.left;
		}else{
			if(node.left.size < node.right.size){
				RandomNode newNode = node.left;
				newNode.right = node.right;
				newNode.left = findNextNode(newNode.left);
				node = newNode;
				node.depth--;
			}else{
				RandomNode newNode = node.right;
				newNode.left = node.left;
				newNode.right = findNextNode(newNode.right);
				node = newNode;
				node.depth--;
			}
			return node;
		}
	}
	
	//Prints the tree but not in completely correct format
	public void showTree(){
		LinkedList<RandomNode> list = new LinkedList<>();
		list.add(root);
		System.out.println(root.data);
		int oldD = root.depth;
		while(!list.isEmpty()){
			
			RandomNode node = list.removeFirst();
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
}

class RandomNode{
	int data;
	RandomNode left, right;
	int size, depth;
	
	public RandomNode(int d) {
		// TODO Auto-generated constructor stub
		data = d;
		size = 1;
		depth = 1;
	}
	
	public RandomNode getIthNode(int i){
		int leftSize = left == null ? 0 : left.size;
		if(i < leftSize){
			return left.getIthNode(i);
		}else if(i == leftSize){
			return this;
		}else{
			return right.getIthNode(i - (leftSize + 1));
		}
	}
	
	public void insertInOrder(int value){
		if(value <= data){
			if(left == null){
				left = new RandomNode(value);
				left.depth = depth + 1;
			}
			else
				left.insertInOrder(value);
		}else{
			if(right == null){
				right = new RandomNode(value);
				right.depth = depth + 1;
			}
			else
				right.insertInOrder(value);
		}
		size++;
	}
	
	public RandomNode find(int d){
		if(d == data)
			return this;
		else if(d <= data)
			return left != null ? left.find(d) : null;
		else
			return right != null ? right.find(d) : null;
	}
	
	public void deleteNode(int value){
		if(left == null && right == null)
			return;
		else if(left != null && value == left.data){
			if(left.left == null && left.right == null){
				left = null;
			}else if(left.left == null && left.right != null){
				left = left.right;
				decrementDepthOfAll(right);
			}else if(left.left != null && left.right == null){
				left = left.left;
				decrementDepthOfAll(left);
			}else{
				left = findNextNode(left);
				left.depth--;
			}
		}else if(right != null && value == right.data){
			if(right.left == null && right.right == null){
				right = null;
			}else if(right.left == null && right.right != null){
				right = right.right;
				decrementDepthOfAll(right);
			}else if(right.left != null && right.right == null){
				right = right.left;
				decrementDepthOfAll(left);
			}else{
				right = findNextNode(right);
				right.depth--;
			}
		}
		else if(value <= data){
			left.deleteNode(value);
			return;
		}
		else{
			right.deleteNode(value);
			return;
		}
		
	}
	
	private RandomNode findNextNode(RandomNode node){
		if(node.left == null && node.right == null){
			return null;
		}else if(node.left == null && node.right != null){
			decrementDepthOfAll(right);
			return node.right;
		}else if(node.left != null && node.right == null){
			decrementDepthOfAll(left);
			return node.left;
		}else{
			if(node.left.size < node.right.size){
				RandomNode newNode = node.left;
				newNode.right = node.right;
				newNode.left = findNextNode(newNode);
				node = newNode;
				node.depth--;
			}else{
				RandomNode newNode = node.right;
				newNode.left = node.left;
				newNode.right = findNextNode(newNode);
				node = newNode;
				node.depth--;
			}
			return node;
		}
	}
	
	public void decrementDepthOfAll(RandomNode node){
		node.depth--;
		if(node.left != null) decrementDepthOfAll(node.left);
		if(node.right != null) decrementDepthOfAll(node.right);
	}
}

public class Random_Node_4_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX_NUMBER = 100;
		int TOTAL_NODES = 40;
		//int array[] = new int[TOTAL_NODES];
		
		RandomTree randomTree = new RandomTree();
		
		for(int i = 0 ; i < TOTAL_NODES ; i++){
			//array[i] = (int)(Math.random() * MAX_NUMBER) + 1;
			randomTree.insertInOrder((int)(Math.random() * MAX_NUMBER) + 1);
		}
		
		int randVal = randomTree.getRandomNode().data;
		System.out.println("Random Value: " + randVal);
		randomTree.showTree();
		randomTree.deleteNode(randVal);
		randomTree.showTree();
	}

}
