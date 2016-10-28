class EnhancedNode{
	Node<Integer> node = null;
	int position = 0;
	
	public EnhancedNode(Node<Integer> node, int p){
		position = p;
		this.node = node;
	}
}

class IntersectionHelper{
	
	public MyLinkedList<Integer> getDefaultList(int listLength){
		MyLinkedList<Integer> myList = new MyLinkedList<>();
		for(int i = 0 ; i < listLength ; i++){
			myList.add((int)(Math.random() * 10));
		}
		return myList;
	}
	
	public Node<Integer> getTailNode(MyLinkedList<Integer> myList){
		Node<Integer> head = myList.getHead();
		while(head.next != null){
			head = head.next;
		}
		return head;
	}
	
	public EnhancedNode getIntersectingNode(MyLinkedList<Integer> firstList, MyLinkedList<Integer> secondList){
		if(getTailNode(firstList) != getTailNode(secondList)) return null;
		
		int firstListLength = firstList.length();
		int secondListLength = secondList.length();
		
		Node<Integer> firstListHeader = firstList.getHead();//Because first list has larger length!
		
		for(int i = 0 ; i <= (firstListLength - secondListLength) ; i++){
			firstListHeader = firstListHeader.next;
		}
		
		Node<Integer> secondListHeader = secondList.getHead();
		
		int position = 1;
		while(firstListHeader != secondListHeader){
			position++;
			firstListHeader = firstListHeader.next;
			secondListHeader = secondListHeader.next;
		}
		return new EnhancedNode(firstListHeader, position);
	}
}

public class Intersection_2_7 {

	private static void join(MyLinkedList<Integer> firstList, MyLinkedList<Integer> secondList, int k){
		Node<Integer> headOfFirst = firstList.getHead();
		
		for(int i = 0 ; i < k ; i++){
			headOfFirst = headOfFirst.next;
		}
		
		secondList.add(headOfFirst);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionHelper intersectionHelper = new IntersectionHelper();
		
		int firstListLength = 25;
		MyLinkedList<Integer> firstList = intersectionHelper.getDefaultList(firstListLength);
		
		int secondListLength = (int)(Math.random() * firstListLength);
		MyLinkedList<Integer> secondList = intersectionHelper.getDefaultList(secondListLength);
		
		join(firstList, secondList, secondListLength + (int)(Math.random() * (firstListLength - secondListLength)));
		
		System.out.print("List 1: ");
		firstList.printPointedList();
		
		System.out.print("List 2: ");
		secondList.printPointedList();
		
		EnhancedNode intersectingNode = intersectionHelper.getIntersectingNode(firstList, secondList);
		
		if(intersectingNode.node == null){
			System.out.println("Lists don't intersect!");
		}else{
			System.out.println("Lists intersect at node " + intersectingNode.position + " in list 2 having value " + intersectingNode.node.value);
		}
	}

}
