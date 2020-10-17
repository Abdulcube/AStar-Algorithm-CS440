import java.util.ArrayList;
import java.util.PriorityQueue;

public class Algorithm {
	
	GridGenerator test;
	
	//Default Constructor
	//For testing and demonstrating purposes
	public Algorithm() {
		test = new GridGenerator();
	}
	
	//Perform Algorithm on particular Grid
	public Algorithm(GridGenerator a) {
		test = a;
	}
	
	int[] s = test.start;
	int[] f = test.end;
	Node end = new Node();
	//
	
	
	public void AStar() {
		
		//List of current nodes to be expanded
		PriorityQueue<Node> fringe = new PriorityQueue<Node>();
		
		//List of all verticies that A* has expanded
		PriorityQueue<Node> closed = new PriorityQueue<Node>();
		
		fringe.add(test.Grid[s[0]][s[1]]);
		
		while(!fringe.isEmpty()) {
			Node cur = fringe.remove();
			
			if (cur.x == test.end[0] && cur.y == test.end[1]) {
				//Path Found
			}
			

		}
	}
	//FInd shortest path from start to current node
	public void findG(PriorityQueue<Node> fringe) {
		
	}
	
	public void fingH() {
		
	}
}
