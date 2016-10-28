import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class StackInfoHolder{
	int top = 0;
	int base = 0;
}

class ThreeInOneHelper{
	
	private StackInfoHolder[] stackInfoHolders;
	
	private int array[];
	
	private int capacity;
	
	public ThreeInOneHelper(int totalStacks, int arrayLength){
		if(totalStacks > arrayLength) throw new InvalidParameterException();
		
		stackInfoHolders = new StackInfoHolder[totalStacks];

		array = new int[arrayLength];
		
		capacity = (arrayLength / totalStacks);
		
		for(int i = -1, j = 0 ; j < totalStacks ; i += capacity, j++){
			stackInfoHolders[j] = new StackInfoHolder();
			stackInfoHolders[j].top = i;
			stackInfoHolders[j].base = i + 1;
		}
		
	}
	
	public void insertInto(int stackNumber, int data){
		if(stackInfoHolders[stackNumber].top - stackInfoHolders[stackNumber].base == capacity) throw new StackOverflowError();
		stackInfoHolders[stackNumber].top++;
		array[stackInfoHolders[stackNumber].top] = data;
	}
	
	public void printAllStackData(){
		for(int i = 0 ; i < stackInfoHolders.length ; i++){
			printStackNumber(i);
		}
	}
	
	public void printStackNumber(int stackNumber){
		int pointer = stackInfoHolders[stackNumber].top;
		System.out.println("Stack " + stackNumber + " Contents: ");
		while(pointer >= stackInfoHolders[stackNumber].base){
			System.out.println(array[pointer]);
			pointer--;
		}
	}
	
	public int peek(int stackNumber){
		if(stackInfoHolders[stackNumber].top < stackInfoHolders[stackNumber].base) throw new NoSuchElementException();
		return array[stackInfoHolders[stackNumber].top];
	}
	
	public int popFromStack(int stackNumber){
		if(stackInfoHolders[stackNumber].top < stackInfoHolders[stackNumber].base) throw new NoSuchElementException();
		stackInfoHolders[stackNumber].top--;
		return array[stackInfoHolders[stackNumber].top + 1];
	}
}

public class ThreeInOne_3_1 {
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		System.out.print("Enter array length: ");
		int arrayLength = sc.nextInt();
		
		ThreeInOneHelper myHelper;
		
		try{
			myHelper = new ThreeInOneHelper(3, arrayLength);
			
			myHelper.insertInto(1, 7);
			myHelper.insertInto(1, 4);
			myHelper.insertInto(1, -23);
			myHelper.insertInto(2, 42);
			myHelper.insertInto(2, 5);
			myHelper.insertInto(0, 43);
			myHelper.insertInto(0, 31);
			myHelper.insertInto(2, 78);
			
			myHelper.printStackNumber(0);
			myHelper.printStackNumber(1);
			myHelper.printStackNumber(2);
			
			System.out.println("Pop From Stack 2: " + myHelper.popFromStack(2));
			
			myHelper.printStackNumber(2);
		}catch(InvalidParameterException e){
			System.out.println("INVALID PARAMETER EXCEPTION: Total stacks are greater than the length of array!");
			e.printStackTrace();
		}
	}
}
