import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DelayedProjects {

	int noOfDependencies, noOfDelayedProjects;
	HashMap<Character, ArrayList<Character>> projectDependencies;
	ArrayList<Character> delayedProjects;
	
	public DelayedProjects(int i, int j) {
		noOfDependencies = i;
		noOfDelayedProjects = j;
		projectDependencies = new HashMap<Character, ArrayList<Character>>();
		delayedProjects = new ArrayList<Character>();
	}

	public static void main(String[] args) {
		DelayedProjects obj = new DelayedProjects(5, 2);
		obj.addDependency("P Q");
		obj.addDependency("P S");
		obj.addDependency("Q R");
		obj.addDependency("R T");
		obj.addDependency("S T");
		obj.addProjectDelayed("Q S");
		obj.printDelayedProjects();
	}

	private void addProjectDelayed(String string) {
		
		for(String s: string.split(" ")) {
			delayedProjects.add(s.charAt(0));
		}
		ArrayList<Character> q = new ArrayList<Character>();
		for(char c: delayedProjects) {
			q.add(c);
		}
		while(!q.isEmpty()) {
			char front = q.get(0);
			q.remove(0);
			if(projectDependencies.containsKey(front))
				for(char c: projectDependencies.get(front))
				{
					q.add(c);
					if(!delayedProjects.contains(c))
						delayedProjects.add(c);
				}
		}
		
	}

	private void printDelayedProjects() {
		
		Collections.sort(delayedProjects);
		for(char a: delayedProjects)
			System.out.print(a+" ");
		System.out.println();
		
	}

	private void addDependency(String string) {
		String[] s = string.split(" ");
		ArrayList<Character> arr;
		if(!projectDependencies.containsKey(s[1].charAt(0)))
		{
			arr = new ArrayList<Character>();
			
		} else {
			arr = projectDependencies.get(s[1].charAt(0));
		}
		arr.add(s[0].charAt(0));
		projectDependencies.put(s[1].charAt(0), arr);
		
	}

}
