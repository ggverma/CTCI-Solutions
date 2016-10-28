
class PalindromeHelper{
	public MyLinkedList<Integer> getDefaultList(int listLength){
		MyLinkedList<Integer> myList = new MyLinkedList<>();
		for(int i = 0 ; i < listLength ; i++){
			myList.add((int)(Math.random() * 10));
		}
		return myList;
	}
	
	public boolean isPalindrome(MyLinkedList<Integer> myList){
		Node<Integer> checkerNode = checkList(myList.getHead(), myList);
		if(checkerNode == null){
			return false;
		}
		return true;
	}
	
	//CheckList traverses the entire list. At the end, returns the first element of list. 
	//Now, at each recursion, we have access to the ith node through head and (N - i)th node through return.
	//If the two values don't match, then the method starts returning null. 
	//If all values match, return non-null Node at the end (when the head reaches middle element).
	private Node<Integer> checkList(Node<Integer> head, MyLinkedList<Integer> myList){
		if(head == null){
			return myList.getHead();
		}
		
		Node<Integer> gotNode = checkList(head.next, myList);
		if(gotNode != null){
			if(gotNode.value != head.value)
				return null;
			if(gotNode.next == null){
				return myList.getHead();
			}
			return gotNode.next;
		}
		return null;
	}
}

public class Palindrome_2_6 {
	public static void main(String[] args) {
		PalindromeHelper palindromeHelper = new PalindromeHelper();
		
		//MyLinkedList<Integer> myList = palindromeHelper.getDefaultList(10);
		MyLinkedList<Integer> myList = new MyLinkedList<>();
		myList.add(0);
		myList.add(1);
		myList.add(1);
		myList.add(1);
		//myList.add(2);
		myList.add(1);
		myList.add(1);
		myList.add(0);
		myList.printPointedList();
		if(palindromeHelper.isPalindrome(myList)){
			System.out.println("Palindrome List");
		}else{
			System.out.println("NOT Palindrome List");
		}
	}
}
