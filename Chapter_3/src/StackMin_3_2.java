class StackMinHelper extends MyStack<Integer>{
	
	private MyStack<Integer> minStack;
	
	private int min;
	
	public StackMinHelper() {
		// TODO Auto-generated constructor stub
		minStack = new MyStack<>();
		
		min = Integer.MAX_VALUE;
	}
	
	public int getMinRecursively(){
		int min = top.data;
		StackNode<Integer> t = top.next;
		while(t != null){
			if(min > t.data)
				min = t.data;
			t = t.next;
		}
		return min;
	}
	
	@Override
	public void push(Integer item){
		super.push(item);
		if(min > item){
			min = item;
			minStack.push(item);	
		}
	}
	
	public int getMinInstantly(){
		return minStack.pop();
	}
	
}

public class StackMin_3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackMinHelper testStack = new StackMinHelper();
		
		for(int i = 0 ; i < 10 ; i++){
			testStack.push((int)(Math.random() * 100));
		}
		
		//testStack.printStack();
		
		System.out.println("MinRecursively: " + testStack.getMinRecursively());
		System.out.println("Min Instantly: " + testStack.getMinInstantly());
	}

}
