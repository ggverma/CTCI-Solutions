import java.util.EmptyStackException;

class SortStackHelper{
	MyStack<Integer> stack1, stack2;
	
	public SortStackHelper() {
		// TODO Auto-generated constructor stub
		stack1 = new MyStack<Integer>();
		stack2 = new MyStack<Integer>();
	}
	
	public void sortMyStack(){
		if(stack1.isEmpty()) throw new EmptyStackException();
		
		if(stack2.isEmpty())
			stack2.push(stack1.pop());
		
		while(!stack1.isEmpty()){
			int temp = stack1.pop();
			while(!stack2.isEmpty()){
				if(stack2.peek() >= temp){
					stack2.push(temp);
					break;
				}else{
					stack1.push(stack2.pop());
				}
			}
			if(stack2.isEmpty()){
				stack2.push(temp);
			}
		}
	}
	
	public void addData(int data){
		stack1.push(data);
	}
	
	public void printStack(MyStack<Integer> stack){
		stack.printStack();
	}
	
	public void showMyEntries(){
		printStack(stack1);
	}
	
	public void printSortedStack(){
		sortMyStack();
		printStack(stack2);
	}
}

public class SortStack_3_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortStackHelper testSubject = new SortStackHelper();
		
		for(int i = 0 ; i < 10 ; i++){
			testSubject.addData((int)(Math.random() * 100));
		}
		
		testSubject.showMyEntries();
		System.out.println();
		testSubject.printSortedStack();
	}

}
