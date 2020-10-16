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
			
			if (cur.x == test.end[0] && cur.y == test.end[1]) {
				//Path Found
			}
			

		}
		
	}
}
