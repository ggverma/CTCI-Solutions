class SumListHelper{
	public MyLinkedList<Integer> getDefaultList(int listLength){
		MyLinkedList<Integer> myList = new MyLinkedList<>();
		for(int i = 0 ; i < listLength ; i++){
			myList.add((int)(Math.random() * 10));
		}
		return myList;
	}
	
	public MyLinkedList<Integer> addLists(MyLinkedList<Integer> firstLL, MyLinkedList<Integer> secondLL){
		int carry = 0;
		
		int sum = 0;
		
		Node<Integer> firstLLHead = firstLL.getHead();
		Node<Integer> secondLLHead = secondLL.getHead();
		MyLinkedList<Integer> mySolution = new MyLinkedList<>();
		
		while(firstLLHead != null || secondLLHead != null){
			if(firstLLHead != null){
				sum += firstLLHead.value ;
				firstLLHead = firstLLHead.next;
			}
			if(secondLLHead != null){
				sum += secondLLHead.value;
				secondLLHead = secondLLHead.next;
			}
			sum += carry;
			carry = 0;
			if(sum > 9){
				carry = 1;
			}
			sum %= 10;
			mySolution.add(sum);
			sum = 0;
		}
		
		return mySolution;
	}
}

public class SumLists_2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SumListHelper sumListHelper = new SumListHelper();
		
		MyLinkedList<Integer> firstLL = sumListHelper.getDefaultList(10);
		MyLinkedList<Integer> secondLL = sumListHelper.getDefaultList(8);
		
		System.out.print("List 1: ");
		firstLL.printPointedList();
		
		System.out.print("List 2: ");
		secondLL.printPointedList();
		
		System.out.print("Solution: ");
		MyLinkedList<Integer> solutionList = sumListHelper.addLists(firstLL, secondLL);
		solutionList.printPointedList();
	}

}
