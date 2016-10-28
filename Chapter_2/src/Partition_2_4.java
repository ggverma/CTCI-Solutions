import java.util.Scanner;

class PartitionHelper{
	public MyLinkedList<Integer> getDefaultList(int listLength){
		MyLinkedList<Integer> myList = new MyLinkedList<>();
		for(int i = 0 ; i < listLength ; i++){
			myList.add((int)(Math.random() * 10));
		}
		return myList;
	}
	
	public Node<Integer> partitionList(Node<Integer> node, int partitionElement){
		Node<Integer> head = node;
		Node<Integer> tail = node;
		
		while(node != null){
			Node<Integer> next = node.next;
			if(node.value < partitionElement){
				node.next = head;
				head = node;
			}else{
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
}

public class Partition_2_4 {
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		System.out.print("Enter list length: ");
		int listLength = sc.nextInt();
		
		PartitionHelper partitionHelper = new PartitionHelper();
		
		MyLinkedList<Integer> myList = partitionHelper.getDefaultList(listLength);
		
		System.out.print("Your list: ");
		myList.printPointedList();
		
		System.out.print("Enter partition Element: ");
		int partitionEl = sc.nextInt();
		
		Node<Integer> newHead = partitionHelper.partitionList(myList.getHead(), partitionEl);
		
		while(newHead != null){
			System.out.print(newHead.value + "->");
			newHead = newHead.next;
		}
	}
}
