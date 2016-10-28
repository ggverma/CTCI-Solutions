import java.util.Scanner;
import java.util.Stack;

class Disk{
	private int ID;
	
	public Disk(int id){
		ID = id;
	}
	
	public int getID(){
		return ID;
	}
}

class TOHHelper{
	private Stack<Disk> tower[];
	
	private int moves;
	
	public TOHHelper(int disksInT1) {
		// TODO Auto-generated constructor stub
		
		tower = (Stack<Disk>[])new Stack[3];
		
		tower[0] = new Stack<>();
		tower[1] = new Stack<>();
		tower[2] = new Stack<>();
		
		for(int i = disksInT1 ; i > 0 ; i--){
			tower[0].add(new Disk(i));
		}
		
		moves = 0;
	}
	
	public void rearrangeDisks(){
		if(tower[0].isEmpty()) return;
		moveDisks(tower[0].size(), tower[0], tower[2], tower[1]);
	}
	
	private void moveDisks(int n, Stack<Disk> origin, Stack<Disk> destination, Stack<Disk> buffer){
		if(n <= 0) return;
		
		moveDisks(n - 1, origin, buffer, destination);
		
		destination.push(origin.pop());
		
		moveDisks(n - 1, buffer, destination, origin);
	}
	
	public void showTower(int towerID){
		System.out.println("Tower " + (towerID + 1));
		Stack<Disk> towerClone = (Stack<Disk>) tower[towerID].clone();
		while(!towerClone.isEmpty()){
			System.out.println(towerClone.pop().getID());
		}
	}
}

public class $8_6_Towers_Of_Henoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter total disk in Tower 1: ");
		int disks = sc.nextInt();
		TOHHelper helper = new TOHHelper(disks);
		helper.showTower(0);
		helper.rearrangeDisks();
		helper.showTower(2);
	}

}
