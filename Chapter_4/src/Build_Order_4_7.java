import java.util.LinkedList;
enum MyState{univisited, visiting, visited};
class MyProject{
	String id;
	private int dependencies;
	private LinkedList<MyProject> childrenProjects;
	public MyState nodeState;
	public MyProject(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		childrenProjects = new LinkedList<>();
		nodeState = MyState.univisited;
	}
	
	public void addChild(MyProject project){
		childrenProjects.add(project);
		project.incrementDependency();
	}
	
	public LinkedList<MyProject> getChildren(){
		return childrenProjects;
	}
	
	public void incrementDependency(){
		dependencies++;
	}
	
	public void decrementDependency(){
		dependencies--;
	}
	
	public int getDependencies(){
		return dependencies;
	}
}

class BuildOrderHelper{
	
	StringBuilder dfsAns = new StringBuilder();
	
	public String getSequence(LinkedList<MyProject> projects){
		
		StringBuilder answer = new StringBuilder();
		
		LinkedList<MyProject> toRemoveProjects = new LinkedList<>();
		for(MyProject project : projects){
			
			if(project.getDependencies() == 0){
				answer.append(project.id + ", ");
				for(MyProject cP : project.getChildren()){
					cP.decrementDependency();
				}
				toRemoveProjects.add(project);
			}
		}
		
		for(MyProject p : toRemoveProjects){
			projects.remove(p);
		}
		
		while(true){
			toRemoveProjects = new LinkedList<>();
			for(MyProject project : projects){
				if(project.getDependencies() == 0){
					answer.append(project.id + ", ");
					for(MyProject cP : project.getChildren()){
						cP.decrementDependency();
					}
					toRemoveProjects.add(project);
				}
			}
			for(MyProject p : toRemoveProjects){
				projects.remove(p);
			}
			if(projects.isEmpty())
				break;			
		}
		
		return answer.toString().substring(0, answer.length() - 2);
	}
	
	public String getSequenceFromDFS(LinkedList<MyProject> projects){
		for(MyProject project : projects){
			
			if(project.nodeState == MyState.univisited){
				project.nodeState = MyState.visiting;
				doDFS(project);
				dfsAns.append(project.id + ", ");
				//System.out.println("Did Node " + project.id);
				project.nodeState = MyState.visited;
			}
		}
		return dfsAns.reverse().toString().substring(2);
	}
	
	private void doDFS(MyProject project){
		if(project.getChildren().isEmpty()){
			//System.out.println("\tAt Node " + project.id);
			return;
		}
		//System.out.println("At Node " + project.id);
		for(MyProject pC : project.getChildren()){
			if(pC.nodeState == MyState.univisited){
				pC.nodeState = MyState.visiting;
				doDFS(pC);
				//System.out.println("Did Node " + pC.id);
				dfsAns.append(pC.id + ", ");
				pC.nodeState = MyState.visited;
			}
		}
	}
}

public class Build_Order_4_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numProjects = 6;
		
		LinkedList<MyProject> projects = new LinkedList<>();
		
		for(int i = 0 ; i < numProjects ; i++){
			projects.add(new MyProject("" + (char)(Character.valueOf('a') + i)));
			//System.out.println("Project " + i +" = " + projects[i].id);
		}
		
		projects.get(0).addChild(projects.get(3));
		projects.get(5).addChild(projects.get(1));
		projects.get(1).addChild(projects.get(3));
		projects.get(5).addChild(projects.get(0));
		projects.get(3).addChild(projects.get(2));
		
		BuildOrderHelper buildOrderHelper = new BuildOrderHelper();
		
		
		System.out.println("Build Order Using DFS: " + buildOrderHelper.getSequenceFromDFS(projects));
		System.out.println("Build Order Using Linked List : " + buildOrderHelper.getSequence(projects));
	}

}
