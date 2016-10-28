class LoopDetectionHelper{
	public MyLinkedList<Integer> getDefaultList(int listLength){
		MyLinkedList<Integer> myList = new MyLinkedList<>();
		for(int i = 0 ; i < listLength ; i++){
			myList.add((int)(Math.random() * 10));
		}
		return myList;
	}
	
	public int getCircularListIndex(MyLinkedList<Integer> myList){
		Node<Integer> doubleSpeedNode = myList.getHead();
		Node<Integer> normalSpeedNode = myList.getHead();
		
		do{
			doubleSpeedNode = doubleSpeedNode.next.next;
			normalSpeedNode = normalSpeedNode.next;
		}while(doubleSpeedNode != normalSpeedNode);
		
		normalSpeedNode = myList.getHead();
		
		int k = 0;
		
		while(normalSpeedNode != doubleSpeedNode){
			k++;
			normalSpeedNode = normalSpeedNode.next;
			doubleSpeedNode = doubleSpeedNode.next;
		}
		
		return k;
	}
}

public class LoopDetection_2_8 {

	static void makeListCirculatAt(int index, MyLinkedList<Integer> myList){
		Node<Integer> node = myList.getHead();
		
		for(int i = 0 ; i < index ; i++){
			node = node.next;
		}
		
		myList.addSingleNode(node);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int listLength = 30;
		
		LoopDetectionHelper loopDetectionHelper = new LoopDetectionHelper();
		
		MyLinkedList<Integer> myList = loopDetectionHelper.getDefaultList(listLength);
		
		int circularIndex = (int)(Math.random() * listLength);
		
		System.out.print("Generate List: ");
		myList.printPointedList();
		
		System.out.println("Set circular index: " + circularIndex);
		
		makeListCirculatAt(circularIndex, myList);
		
		System.out.println("Got circular index: " + loopDetectionHelper.getCircularListIndex(myList));
	}

}
