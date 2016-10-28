import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.naming.SizeLimitExceededException;

//Stores the info of each stack. As many holders as the number of stacks.
class StackInfoHolderFU{
	int top;
	int base;
	int capacity;
}

class ThreeInOneHelperFU{
	
	private StackInfoHolderFU[] stackInfoHolders;
	
	//The array stores the data
	private int array[];
	
	private int increaseStackCapacityBy;
	
	//This is used to know whether the array or stacks are completely filled.
	private int totalValidEntriesInArray;
	
	
	public ThreeInOneHelperFU(int totalStacks, int arrayLength){
		if(totalStacks > arrayLength) throw new InvalidParameterException();
		
		totalValidEntriesInArray = 0;
		
		stackInfoHolders = new StackInfoHolderFU[totalStacks];

		array = new int[arrayLength];
		
		increaseStackCapacityBy = 1;
		
		for(int i = -1, j = 0 ; j < totalStacks ; i++, j++){
			stackInfoHolders[j] = new StackInfoHolderFU();
			stackInfoHolders[j].top = i;//top is 1 less than base because each stack is empty.
			stackInfoHolders[j].base = i + 1;
			stackInfoHolders[j].capacity = 1;
		}
		
	}
	
	//Shifts the right stacks right by a factor of increaseStackSizeBy to increase the appropriate stack size. 
	public void rightShift(int stackNumber, int increaseStackBy) throws SizeLimitExceededException{
		//System.out.println("Left Shifting Stack " + stackNumber);
		if(stackNumber == stackInfoHolders.length){
			return;
		}
		
		//recursion to get the rightmost stack
		rightShift(stackNumber + 1, increaseStackBy);
		
		//valid shift be performed if shift is within array limit.
		if(stackInfoHolders[stackNumber].top + increaseStackBy > stackInfoHolders.length) throw new SizeLimitExceededException();
		
		//Shift the elements.
		for(int i = stackInfoHolders[stackNumber].top + increaseStackBy ; i > stackInfoHolders[stackNumber].base ; i--){
			array[i] = array[i - 1];
		}
		
		//Update the respective stackHolder.
		stackInfoHolders[stackNumber].top++;
		stackInfoHolders[stackNumber].base++;
	}
	
	//Insert the data in the stack given by index stackNumber
	public void insertInto(int stackNumber, int data){
		//check if the array is completely filled.
		if(totalValidEntriesInArray == array.length) throw new StackOverflowError();
		
		//check if insertion in the stack requires shifting of right stacks
		if((stackInfoHolders[stackNumber].top - stackInfoHolders[stackNumber].base + 1) == stackInfoHolders[stackNumber].capacity){
			try{
				rightShift(stackNumber + 1, increaseStackCapacityBy);
			}
			catch(SizeLimitExceededException e){
				e.printStackTrace();
			}
			//Update this stachHolder's capacity. Note: Capacity once increased is never reduced! 
			//If  capacity is to be reduced, we can implement leftShift exactly similar to rightShift.
			stackInfoHolders[stackNumber].capacity += increaseStackCapacityBy;
		}
		
		totalValidEntriesInArray++;
		
		//Update this stackHolder
		stackInfoHolders[stackNumber].top++;
		array[stackInfoHolders[stackNumber].top] = data;
	}
	
	/*private void printStackHoldersData(){
		int i = 0;
		for(StackInfoHolderFU x : stackInfoHolders){
			System.out.println("\tInfo Holder #" + i + "\nTop: " + x.top + "\nBase: " + x.base + "\nCapacity: " + x.capacity);
			i++;
		}
	}*/
	
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
		
		//Check that this stack is not empty.
		if(stackInfoHolders[stackNumber].top < stackInfoHolders[stackNumber].base) throw new NoSuchElementException();
		
		totalValidEntriesInArray--;
		
		stackInfoHolders[stackNumber].top--;
		
		return array[stackInfoHolders[stackNumber].top + 1];
	}
	
	/*private void printArray(){
		for(int i : array){
			System.out.print(i + " ");
		}
		System.out.println();
	}*/
}

public class ThreeInOneFollowUp_3_1 {
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		System.out.print("Enter array length: ");
		int arrayLength = sc.nextInt();
		
		System.out.print("Enter number of stacks: ");
		int numberOfStacks = sc.nextInt();
		
		ThreeInOneHelperFU myHelper;
		
		try{
			myHelper = new ThreeInOneHelperFU(numberOfStacks, arrayLength);
			
			//For testing
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
			
			myHelper.insertInto(2, 10);
			
			myHelper.printStackNumber(2);
			myHelper.printAllStackData();
			
		}catch(InvalidParameterException e){
			System.out.println("INVALID PARAMETER EXCEPTION: Total stacks are greater than the length of array!");
			e.printStackTrace();
		}
	}
}
