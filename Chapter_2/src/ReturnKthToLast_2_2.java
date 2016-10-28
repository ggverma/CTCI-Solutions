import java.util.Scanner;

class ReturnKthHelper{
	
	public MyLinkedList<Character> getDefaultList(){
		MyLinkedList<Character> myList = new MyLinkedList<>();
		
		for(int i = 70 ; i < 90 ; i++){
			myList.add((char)i);
		}
		
		return myList;
	}
	
	public char getKth(MyLinkedList<Character> myList, int k){
		if(k > myList.length()) return '\0';
		int i = 1;
		Node<Character> frontNode = myList.getHead();
		Node<Character> backNode = myList.getHead();
		for( ; i < (k) ; i++){
			frontNode = frontNode.next;
		}
		if(i < (k)){
			return '\0';
		}

		while(frontNode.next != null){
			frontNode = frontNode.next;
			backNode = backNode.next;
		}
		
		return backNode.value;
	}
	
}

public class ReturnKthToLast_2_2 {
	
	static private Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		ReturnKthHelper myHelper = new ReturnKthHelper();
		
		MyLinkedList<Character> myList = myHelper.getDefaultList();
		
		System.out.print("Enter k: ");
		int k = sc.nextInt();
		
		System.out.println("Your input: " + myList.toString() + "\nOutput: " + myHelper.getKth(myList, k));
	}
}
