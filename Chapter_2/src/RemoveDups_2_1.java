import java.util.HashSet;
import java.util.Scanner;

class RemoveDupsHelper{
	public String removeDuplicates(String userString) {
		MyLinkedList<Character> myList = toList(userString);
		
		HashSet<Character> mySet = new HashSet<>();
		
		Node<Character> node = myList.getHead();
		
		while(node.next != null){
			if(mySet.contains(node.value)){
				myList.remove(node);
			}else{
				mySet.add(node.value);
			}
			node = node.next;
		}
		
		return myList.toString();
	}
	
	private MyLinkedList<Character> toList(String userString){
		MyLinkedList<Character> myList = new MyLinkedList<>();
		
		for(char c : userString.toCharArray()){
			myList.add(c);
		}
		
		return myList;
	}
}

public class RemoveDups_2_1 {
	
	static private Scanner sc;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		System.out.println("Please input your string here: ");
		String userString = sc.nextLine();
		
		RemoveDupsHelper myHelper = new RemoveDupsHelper();
		
		String formattedString = myHelper.removeDuplicates(userString);
		
		System.out.println("Formatted String: " + formattedString);
	}
	
}
