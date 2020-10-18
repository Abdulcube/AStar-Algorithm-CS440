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

		while (!fringe.isEmpty()) {
			Node cur = fringe.remove();

			if (cur.x == test.end[0] && cur.y == test.end[1]) {
				//Path Found
			}


		}
	}

	//FInd shortest path from start to current node
	public void findG(PriorityQueue<Node> fringe) {

	}

	//Finding the euclidean distance between the current node and the end node
	public double h(Node n, Node end) {
		int dist = Math.abs(n.x = end.x) + Math.abs(n.y - end.y);
		return dist;
	}

	//Return the position of the next node as a string to assist with the movement cost calculations
	public String cellPos(Node parent, Node child) {

		if ((parent.x == child.x + 1) && (parent.y == child.y - 1)) { //top right
			return ("tr");
		} else if ((parent.x == child.x + 1) && (parent.y == child.y + 1)) { //top left
			return ("tl");
		} else if ((parent.x == child.x - 1) && (parent.y == child.y + 1)) { //bottom left
			return ("bl");
		} else if ((parent.x == child.x - 1) && (parent.y == child.y - 1)) { //bottom right
			return ("tl");
		} else if ((parent.x == child.x - 1) && (parent.y == child.y)) { //bottom
			return ("b");
		} else if ((parent.x == child.x + 1) && (parent.y == child.y)) { //top
			return ("t");
		} else if ((parent.x == child.x) && (parent.y == child.y - 1)) { //right
			return ("r");
		} else return ("l");
	}

	//Calculating the cost of the movement from one node to its neighbor based on its neighbors type and position
	public double cost(Node parent, Node child) {
		//moving between two normal blocks vertically or horizontally
		if ((cellPos(parent, child).equals("b") || cellPos(parent, child).equals("t") || cellPos(parent, child).equals("r") || cellPos(parent, child).equals("l")) && parent.getType() == '1' && child.getType() == '1') {
			return 1.0;
		}
		//moving between 2 normal HIGHWAY blocks vertically or horizontally
		else if ((cellPos(parent, child).equals("b") || cellPos(parent, child).equals("t") || cellPos(parent, child).equals("r")|| cellPos(parent, child).equals("l")) && parent.getType() == 'a' && child.getType() == 'a') {
			return 1.0/4;
		}
		//moving between a normal and a hard block vertically or horizontally
		else if ((cellPos(parent, child).equals("b") || cellPos(parent, child).equals("t") || cellPos(parent, child).equals("r")|| cellPos(parent, child).equals("l")) && parent.getType() == '1' && child.getType() == '2') {
			return 1.5;
		}
		//moving between a normal and a hard block vertically or horizontally w HIGHWAY
		else if ((cellPos(parent, child).equals("b") || cellPos(parent, child).equals("t") || cellPos(parent, child).equals("r") || cellPos(parent, child).equals("l")) && parent.getType() == 'a' && child.getType() == 'b') {
			return 1.5/4;
		}
		//moving between a normal and a hard block vertically or horizontally
		else if ((cellPos(parent, child).equals("b") || cellPos(parent, child).equals("t") || cellPos(parent, child).equals("r") || cellPos(parent, child).equals("l")) && parent.getType() == '2' && child.getType() == '1') {
			return 1.5;
		}
		//moving between a normal and a hard block vertically or horizontally w HIGHWAY
		else if ((cellPos(parent, child).equals("b") || cellPos(parent, child).equals("t") || cellPos(parent, child).equals("r") || cellPos(parent, child).equals("l")) && parent.getType() == 'b' && child.getType() == 'a') {
			return 1.5/4;
		}
		//moving between two hard to traverse blocks vertically or horizontally
		else if ((cellPos(parent, child).equals("b") || cellPos(parent, child).equals("t") || cellPos(parent, child).equals("r") || cellPos(parent, child).equals("l")) && parent.getType() == '2' && child.getType() == '2') {
			return 2.0;
		}
		//moving between two hard to traverse HIGHWAY blocks vertically or horizontally
		else if ((cellPos(parent, child).equals("b") || cellPos(parent, child).equals("t") || cellPos(parent, child).equals("r")|| cellPos(parent, child).equals("l")) && parent.getType() == 'b' && child.getType() == 'b') {
			return 2.0/4;
		}
		//moving between two normal blocks diagonally
		else if ((cellPos(parent, child).equals("br") || cellPos(parent, child).equals("tr") || cellPos(parent, child).equals("bl") || cellPos(parent, child).equals("tl")) && parent.getType() == '1' && child.getType() == '1') {
			return (Math.sqrt(2.0));
		}
		//moving between two normal HIGHWAY blocks diagonally
		else if ((cellPos(parent, child).equals("br") || cellPos(parent, child).equals("tr") || cellPos(parent, child).equals("bl") || cellPos(parent, child).equals("tl")) && parent.getType() == 'a' && child.getType() == 'a') {
			return (Math.sqrt(2.0))/4;
		}
		//moving between a normal and a hard block diagonally
		else if ((cellPos(parent, child).equals("br") || cellPos(parent, child).equals("tr") || cellPos(parent, child).equals("bl") || cellPos(parent, child).equals("tl")) && parent.getType() == '1' && child.getType() == '2') {
			return ((Math.sqrt(2.0) + Math.sqrt(8)) / 2);
		}
		//moving between a normal and a hard block diagonally w HIGHWAY
		else if ((cellPos(parent, child).equals("br") || cellPos(parent, child).equals("tr") || cellPos(parent, child).equals("bl") || cellPos(parent, child).equals("tl")) && parent.getType() == 'a' && child.getType() == 'b') {
			return ((Math.sqrt(2.0) + Math.sqrt(8)) / 2)/4;
		}
		//moving between a normal and a hard block diagonally
		else if ((cellPos(parent, child).equals("br") || cellPos(parent, child).equals("tr") || cellPos(parent, child).equals("bl") || cellPos(parent, child).equals("tl")) && parent.getType() == '2' && child.getType() == '1') {
			return ((Math.sqrt(2.0) + Math.sqrt(8)) / 2);
		}
		//moving between a normal and a hard block diagonally w HIGHWAY
		else if ((cellPos(parent, child).equals("br") || cellPos(parent, child).equals("tr") || cellPos(parent, child).equals("bl") || cellPos(parent, child).equals("tl")) && parent.getType() == 'b' && child.getType() == 'a') {
			return ((Math.sqrt(2.0) + Math.sqrt(8)) / 2)/4;
		}
		//moving between two hard HIGHWAY blocks diagonally
		else if ((cellPos(parent, child).equals("br") || cellPos(parent, child).equals("tr") || cellPos(parent, child).equals("bl") || cellPos(parent, child).equals("tl")) && parent.getType() == 'b' && child.getType() == 'b') {
			return Math.sqrt(8)/ 4;
		}
		//moving between two hard cells diagonally
		else {
			return (Math.sqrt(8));
		}


	}
}