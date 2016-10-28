import java.util.NoSuchElementException;

class QueueViaStackHelper{
	MyStack<Integer> stack1, stack2;
	
	public QueueViaStackHelper() {
		// TODO Auto-generated constructor stub
		stack1 = new MyStack<Integer>();
		stack2 = new MyStack<Integer>();
	}
	
	public void enqueue(int data){
		stack1.push(data);
	}
	
	private void fillStack2(){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
	}
	
	public int dequeue(){
		if(stack2.isEmpty())
			fillStack2();
		if(stack2.isEmpty()) throw new NoSuchElementException();
		return stack2.pop();
	}
	
	public void printQueue(){
		if(stack2.isEmpty())
			fillStack2();
		stack2.printStackAsQueue();
	}
}

public class QueueViaStack_3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueViaStackHelper testSubject = new QueueViaStackHelper();
		
		for(int i = 0 ; i < 20 ; i++){
			testSubject.enqueue((int)(Math.random() * 100));
		}
		
		testSubject.printQueue();
		
		System.out.println("Dequeued: " + testSubject.dequeue());
		System.out.println("Dequeued: " + testSubject.dequeue());
		System.out.println("Dequeued: " + testSubject.dequeue());
		
		testSubject.printQueue();
		
		for(int i = 0 ; i < 20 ; i++){
			testSubject.enqueue((int)(Math.random() * 100));
		}
		
		testSubject.printQueue();
		
		System.out.println("Dequeued: " + testSubject.dequeue());
		System.out.println("Dequeued: " + testSubject.dequeue());
		System.out.println("Dequeued: " + testSubject.dequeue());
		
		testSubject.printQueue();
	}

}
