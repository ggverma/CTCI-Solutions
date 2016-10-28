class Node <T>{
	Node<T> next;
	T value;
	
	public Node(T value){
		this.value = value;
		next = null;
	}
}

class MyLinkedList<T> {
	private Node<T> head;
	
	private int length;
	
	public MyLinkedList(){
		head = new Node<>(null);
	}
	
	public void add(T value){
		Node<T> h = head;
		while(h.next != null){
			h = h.next;
		}
		
		Node<T> n = new Node<>(value);
		h.next = n;
		length++;
	}
	
	public Node<T> getNodeAt(int index){
		if(head.next == null){
			return null;
		}
		
		if(length < index){
			return null;
		}
		
		Node<T> h = head.next;
		
		for(int i = 0 ; i < index ; i++){
			h = h.next;
		}
		
		return h;
	}
	
	public void printPointedList(){
		if(head.next == null){
			return;
		}
		Node<T> h = head.next;
		
		while(h.next != null){
			System.out.print(h.value + "->");
			h = h.next;
		}
		System.out.println(h.value);
	}
	
	public void printContinousList(){
		if(head.next == null){
			return;
		}
		Node<T> h = head.next;
		
		while(h.next != null){
			System.out.print(h.value);
			h = h.next;
		}
		System.out.println(h.value);
	}
	
	@Override
	public String toString(){
		if(head.next == null) return "";
		Node<T> h = head.next;
		StringBuilder b = new StringBuilder();
		while(h.next != null){
			b.append(h.value);
			h = h.next;
		}
		b.append(h.value);
		return b.toString();
	}
	
	public Node<T> getHead(){
		return head.next;
	}
	
	public void addSingleNode(Node<T> node){
		Node<T> h = head;
		while(h.next != null){
			h = h.next;
		}
		
		h.next = node;
		
		length++;
	}
	
	public void add(Node<T> node){
		Node<T> h = head;
		while(h.next != null){
			h = h.next;
		}
		
		h.next = node;
		
		int nodeListLength = 1;
		while(node != null){
			nodeListLength++;
			node = node.next;
		}
		length += nodeListLength;
	}
	
	public void setHead(Node<T> node){
		head.next = node;
	}
	
	public void remove(Node<T> node){
		if(head.next == null) return;
		Node<T> h = head;
		while(h.next != node){
			h = h.next;
		}
		h.next = h.next.next;
		length--;
	}
	
	public void remove(T value){
		if(head.next == null) return;
		Node<T> h = head;
		while(h.next.value != value){
			h = h.next;
		}
		h.next = h.next.next;
		length--;
	}
	
	public int length(){
		return length;
	}
}
