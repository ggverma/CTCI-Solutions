import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Box implements Comparable<Box>{
	private int length, breadth, height;
	
	public Box(int l, int b, int h) {
		// TODO Auto-generated constructor stub
		length = l;
		breadth = b;
		height = h;
	}
	@Override
	
	public int compareTo(Box o) {
		// TODO Auto-generated method stub
		if(length < o.getLength())
			return 1;
		else if(length == o.getLength())
			return 0;
		else
			return -1;
	}
	
	public int getLength(){
		return length;
	}
	
	public int getBreadth(){
		return breadth;
	}
	
	public int getHeight(){
		return height;
	}
	
	public boolean isSmallerThan(Box box){
		return height <= box.getHeight() && length <= box.getLength() && breadth <= box.getBreadth() ? true : false; 
	}
}

class SOBHelper{
	private Box[] boxes;
	
	public SOBHelper(int totalBoxes) {
		// TODO Auto-generated constructor stub
		boxes = new Box[totalBoxes];
		
		Random generator = new Random();
		for(int i = 0 ; i < totalBoxes ; i++){
			boxes[i] = new Box(generator.nextInt(100), generator.nextInt(100), generator.nextInt(100));
		}
	}
	
	public int getMaxHeightStack(){
		int maxHeight = Integer.MIN_VALUE;
		Arrays.sort(boxes);
		int maxHeights[] = new int[boxes.length]; 
		for(int i = 0 ; i < boxes.length ; i++){
			//int newHeight = heightWithBase(i, maxHeights);
			int newHeight = heightWithBinaryDecisions(0, -1, maxHeights);
			maxHeight = maxHeight > newHeight ? maxHeight : newHeight; 
		}
		return maxHeight;
	}
	
	private int heightWithBase(int lowerBoxIndex, int[] cache){
		if(lowerBoxIndex < boxes.length && cache[lowerBoxIndex] > 0) return cache[lowerBoxIndex];
		int maxHeight = 0;
		for(int i = lowerBoxIndex + 1 ; i < boxes.length ; i++){
			if(boxes[i].isSmallerThan(boxes[lowerBoxIndex])){
				int height = heightWithBase(i, cache) + boxes[i].getHeight();
				if(height > maxHeight) maxHeight = height;
			}
		}
		cache[lowerBoxIndex] = maxHeight;
		return maxHeight;
	}
	
	public void showBoxes(){
		for(int i = 0 ; i < boxes.length ; i++){
			System.out.println("Box " + (i + 1) + ": (L,B,H) -> (" + boxes[i].getLength() + ", " + boxes[i].getBreadth() + ", " + boxes[i].getHeight() + ")");
		}
	}
	
	private int heightWithBinaryDecisions(int offset, int lowerBoxIndex, int[] cache){
		if(offset >= boxes.length) return 0;
		
		int heightWithBottom = 0;
		
		if(lowerBoxIndex == -1 || boxes[offset].isSmallerThan(boxes[lowerBoxIndex])){
			if(cache[offset] == 0){
				cache[offset] = heightWithBinaryDecisions(offset + 1, offset, cache);
				cache[offset] += boxes[offset].getHeight();
			}
			heightWithBottom = cache[offset];
		}
		
		int heightWithoutBottom = heightWithBinaryDecisions(offset + 1, lowerBoxIndex, cache);
		
		return Math.max(heightWithBottom, heightWithoutBottom);
	}
}

public class $8_13_Stack_Of_Boxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter total number of boxes: ");
		int totalBoxes = sc.nextInt();
		SOBHelper helper = new SOBHelper(totalBoxes);
		helper.showBoxes();
		System.out.println("Max Height: " + helper.getMaxHeightStack());
	}

}
