
class DeleteNodeHelper{
	public MyLinkedList<Character> getDefaultList(){
		MyLinkedList<Character> myList = new MyLinkedList<>();
		
		for(int i = 70 ; i < 90 ; i++){
			myList.add((char)i);
		}
		
		return myList;
	}
	
	public void removeMiddle(Node<Character> node){
		Node<Character> nextNode = node.next;
		node.value = nextNode.value;
		node.next = nextNode.next;
	}
}

public class DeleteMiddleNode_2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteNodeHelper myHelper = new DeleteNodeHelper();
		
		MyLinkedList<Character> myList = myHelper.getDefaultList();
		
		Node<Character> nodeToRemove = myList.getNodeAt(3);
		
		myList.printPointedList();
		
		myHelper.removeMiddle(nodeToRemove);
		
		myList.printPointedList();
	}

}
