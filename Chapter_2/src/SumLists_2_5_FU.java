class PartialSum{
	Node<Integer> sum = null;
	int carry = 0;
}

class SumListFUHelper{
	public MyLinkedList<Integer> getDefaultList(int listLength){
		MyLinkedList<Integer> myList = new MyLinkedList<>();
		for(int i = 0 ; i < listLength ; i++){
			myList.add((int)(Math.random() * 10));
		}
		return myList;
	}
	
	public MyLinkedList<Integer> padZeroes(MyLinkedList<Integer> myList, int k){
		Node<Integer> start = new Node<>(0);
		Node<Integer> startAsHead = start;
		for(int i = 1 ; i < k ; i++){
			Node<Integer> newNode = new Node<>(0);
			start.next = newNode;
			start = newNode;
		}
		start.next = myList.getHead();
		myList.setHead(startAsHead);
		return myList;
	}
	
	public Node<Integer> insertBefore(Node<Integer> node, int value){
		Node<Integer> newNode = new Node<>(value);
		newNode.next = node;
		node = newNode;
		return node;
	}
	
	public Node<Integer> addLists(MyLinkedList<Integer> firstLL, MyLinkedList<Integer> secondLL){
		if(firstLL.length() < secondLL.length()){
			firstLL = padZeroes(firstLL, secondLL.length() - firstLL.length());
		}else if(firstLL.length() > secondLL.length()){
			secondLL = padZeroes(secondLL, firstLL.length() - secondLL.length());
		}
		
		PartialSum sum = addListsHelper(firstLL.getHead(), secondLL.getHead());
		
		if(sum.carry == 0){
			return sum.sum;
		}else{
			Node<Integer> result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	public PartialSum addListsHelper(Node<Integer> l1, Node<Integer> l2){
		if(l1 == null && l2 == null){
			return new PartialSum();
		}
		
		PartialSum sum = addListsHelper(l1.next, l2.next);
		
		int val = sum.carry + l1.value + l2.value;
		
		Node<Integer> full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}
}

public class SumLists_2_5_FU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumListFUHelper sumListFUHelper = new SumListFUHelper();
		
		MyLinkedList<Integer> firstLL = sumListFUHelper.getDefaultList(7);
		MyLinkedList<Integer> secondLL = sumListFUHelper.getDefaultList(10);
		
		System.out.print("List 1: ");
		firstLL.printPointedList();
		
		System.out.print("List 2: ");
		secondLL.printPointedList();
		
		System.out.print("Solution: ");
		Node<Integer> solutionList = sumListFUHelper.addLists(firstLL, secondLL);
		
		while(solutionList != null){
			System.out.print(solutionList.value + "->");
			solutionList = solutionList.next;
		}
	}

}
