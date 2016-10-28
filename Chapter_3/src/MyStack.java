import java.util.EmptyStackException;

public class MyStack <T>{
	protected static class StackNode<T>{
		protected T data;
		protected StackNode<T> next;
		
		public StackNode(T data){
			this.data = data;
		}
	}
	
	public int size;
	
	protected StackNode<T> top;
	
	public T pop(){
		if(top == null) throw new EmptyStackException();
		size--;
		T item = top.data;
		top = top.next;
		return item;
	}
	
	public void push(T item){
		size++;
		StackNode<T> newNode = new StackNode<T>(item);
		newNode.next = top;
		top = newNode;
	}
	
	public T peek(){
		if(top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public void printStack(){
		StackNode<T> t = top;
		while(t != null){
			System.out.println(t.data);
			t = t.next;
		}
	}
	
	public void printStackAsQueue(){
		StackNode<T> t = top;
		while(t != null){
			System.out.print(t.data + " ");
			t = t.next;
		}
		System.out.println();
	}
}
