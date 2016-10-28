import java.util.ArrayList;
import java.util.NoSuchElementException;

class StackOfPlatesHelper{
	ArrayList<MyStack<Integer>> myStackList;
	
	private int maxCapacity;
	
	public StackOfPlatesHelper(int defaultCapacity) {
		// TODO Auto-generated constructor stub
		maxCapacity = defaultCapacity;
		myStackList = new ArrayList<>();
		myStackList.add(new MyStack<Integer>());
	}
	
	public void setMaxCapacityOfStack(int capacity){
		maxCapacity = capacity;
	}
	
	public void addData(int data){
		int indexOfLastStack = getLastStackIndex() - 1;
		
		if(myStackList.get(indexOfLastStack).size == maxCapacity){
			myStackList.add(new MyStack<Integer>());
			indexOfLastStack++;
		}
		
		myStackList.get(indexOfLastStack).push(data);
	}
	
	public int popFromLastStack(){
		int indexOfLastStack = myStackList.size() - 1;
		if(indexOfLastStack == -1) throw new NoSuchElementException();
		if(myStackList.get(indexOfLastStack).isEmpty()){
			indexOfLastStack--;
		}
		return myStackList.get(indexOfLastStack).pop();
	}
	
	
	
	public void printStacks(){
		for(MyStack<Integer> x : myStackList){
			x.printStack();
			System.out.println("----");
		}
	}
	
	private int getLastStackIndex(){
		return myStackList.size();
	}
}

public class StackOfPlates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackOfPlatesHelper testSubject = new StackOfPlatesHelper(5);
		
		for(int i = 0 ; i < 20 ; i++){
			testSubject.addData((int)(Math.random() * 100));
		}
		
		testSubject.printStacks();
		
		System.out.println("Last Pop: " + testSubject.popFromLastStack());
		System.out.println("Last Pop: " + testSubject.popFromLastStack());
		System.out.println("Last Pop: " + testSubject.popFromLastStack());
		System.out.println("Last Pop: " + testSubject.popFromLastStack());
		System.out.println("Last Pop: " + testSubject.popFromLastStack());
		System.out.println("Last Pop: " + testSubject.popFromLastStack());
		System.out.println("Last Pop: " + testSubject.popFromLastStack());
		System.out.println("Last Pop: " + testSubject.popFromLastStack());
	}

}
