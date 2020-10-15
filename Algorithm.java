import java.util.ArrayList;
import java.util.PriorityQueue;

public class Algorithm {
	
	GridGenerator test = new GridGenerator();
	int[] s = test.start;
	int[] f = test.end;
	Node end = new Node();
	//
	
	public void AStar() {
		PriorityQueue<Node> fringe = new PriorityQueue<Node>();
		fringe.add(test.Grid[s[0]][s[1]]);
		
		while(!fringe.isEmpty()) {
			Node cur = fringe.remove();
			
			// We need to set up x and y inside of the Node class
			//if(cur = end)
		}
		
	}
}
