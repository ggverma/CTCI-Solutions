import java.util.Iterator;
import java.util.LinkedList;

class RouteBetweenNodesHelper extends MyGraph{

	public RouteBetweenNodesHelper(int[][] adjacencyMatrix) {
		super(adjacencyMatrix);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("rawtypes")
	public boolean checkPathusingBFSBetween(MyGraphNode node1, MyGraphNode node2){

		LinkedList<MyGraphNode> myQueue = new LinkedList<>();
		myQueue.add(node1);
		
		while(!myQueue.isEmpty()){
			MyGraphNode thisNode = myQueue.removeFirst();
			thisNode.state = NodeState.visiting;
			for (Iterator<MyGraph<Integer>.MyGraphNode<Integer>> iterator = thisNode.children.iterator(); iterator.hasNext();) {
				MyGraphNode y = iterator.next();
				if(y.data == node2.data){
					return true;
				}
				if(y.state == NodeState.univisted)
					myQueue.add(y);
			}
			thisNode.state = NodeState.visited;
		}
		return false;
	}
	
	public boolean checkPathUsingDFSBetween(MyGraphNode node1, MyGraphNode node2){
		node1.state = NodeState.visiting;
		
		//System.out.println("At Node " + node1.data);
		boolean doesPathExist = false;
		for (Iterator<MyGraph<Integer>.MyGraphNode<Integer>> iterator = node1.children.iterator(); iterator.hasNext() && !doesPathExist;) {
			MyGraphNode y = iterator.next();
			
			if(y.state == NodeState.univisted)
				doesPathExist = checkPathUsingDFSBetween(y, node2);
			if(y.data == node2.data || doesPathExist){
				return true;
			}
		}
		node1.state = NodeState.visited;
		return false;
	}
}

public class RouteBetweenNodes_4_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NUMBER_OF_NODES = 10;
		
		AdjacencyMatrix myAdjMat = new AdjacencyMatrix(NUMBER_OF_NODES, true);//Undirected graph
		
		//myAdjMat.printAdjacencyMatrix();
		
		RouteBetweenNodesHelper graph = new RouteBetweenNodesHelper(myAdjMat.getAdjacencyMatrix());
		
		//graph.showMyGraph();
		
		System.out.print("USING BFS, ");
		if(graph.checkPathusingBFSBetween(graph.graphNodes[2], graph.graphNodes[5])){
			System.out.println("Path exists");
		}else{
			System.out.println("Path does not exist");
		}
		
		graph.refreshNodeStates();
		
		System.out.print("USING DFS, ");
		if(graph.checkPathUsingDFSBetween(graph.graphNodes[2], graph.graphNodes[5])){
			System.out.println("Path exists");
		}else{
			System.out.println("Path does not exist");
		}
	}

}

