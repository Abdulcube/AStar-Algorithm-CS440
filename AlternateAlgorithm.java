import java.util.ArrayList;
import java.util.List;


public class AlternateAlgorithm {
	GridGenerator grid;
	DrawGrid scene;
	
	private boolean solving = false;
	private int length = 0;
	private int checks = 0;
	
	
	
	//Default Constructor
	//For testing and demonstrating purposes
	public AlternateAlgorithm() {
		grid = new GridGenerator();
		scene = new DrawGrid();
	}

	//Perform Algorithm on particular Grid
	public AlternateAlgorithm(GridGenerator a, DrawGrid b) {
		grid = a;
		scene = b;
		
	}
	
public void AStar() {
		

		int[] start;
		int[] end;
		
		start = grid.start;
		end = grid.end;
		
		solving = true;
		
		ArrayList<Node> priority = new ArrayList<Node>();
		priority.add(grid.Grid[start[0]][start[1]]);
		
		
		while(solving) {
			
			
			System.out.println("__________while()_______________");
			
			
			if(priority.size() <= 0) {
				solving = false;
				break;
			}
			
			double cost = priority.get(0).cost;
			
			int jumps = priority.get(0).jumps+1;
			
			
			ArrayList<Node> explored = exploreNeighborsW(priority.get(0),jumps,cost);
			if(explored.size() > 0) {
				
				priority.remove(0);
				priority.addAll(explored);
				
				//LIVE UPDATE
				scene.updateMap();
				
				
			} else {
				priority.remove(0);
			}
			sortQueW(priority);	//SORT THE PRIORITY QUE
		}
	}
	
	public ArrayList<Node> sortQueW(ArrayList<Node> sort) {	//SORT PRIORITY QUE
		
		System.out.println("___________sortQ______________");
		int[] start;
		int[] end;
		
		start = grid.start;
		end = grid.end;
		
		int c = 0;
		while(c < sort.size()) {
			int sm = c;
			for(int i = c+1; i < sort.size(); i++) {
				
				if(sort.get(i).getEuclidDist(end[0],end[1])+sort.get(i).cost < sort.get(sm).getEuclidDist(end[0],end[1])+sort.get(sm).cost){
					sm = i;
				}
			}
			if(c != sm) {
				Node temp = sort.get(c);
				sort.set(c, sort.get(sm));
				sort.set(sm, temp);
			}	
			c++;
		}
		return sort;
	}
	
	public ArrayList<Node> exploreNeighborsW(Node current, int hops , double cost) {	//EXPLORE NEIGHBORS
		//System.out.println("____________exploreNei_____________");
		ArrayList<Node> explored = new ArrayList<Node>();	//LIST OF NODES THAT HAVE BEEN EXPLORED
		for(int a = -1; a <= 1; a++) {
			for(int b = -1; b <= 1; b++) {
				int xbound = current.getX()+a;
				int ybound = current.getY()+b;
				if((xbound > -1 && xbound < 160) && (ybound > -1 && ybound < 120)) {	
					//MAKES SURE THE NODE IS NOT OUTSIDE THE GRID
					Node neighbor = grid.Grid[xbound][ybound];
					if((neighbor.jumps ==-1 || neighbor.jumps > cost) && neighbor.getType()!= '0') {	//CHECKS IF THE NODE IS NOT A WALL AND THAT IT HAS NOT BEEN EXPLORED
						//System.out.println("__________in if_______________");
						//System.out.println("______________________________________________count =  " + hops);
						
						//neighbor.cost  += cost(current , neighbor);
						System.out.println("________________________________________" + neighbor.cost);
						
						exploreW(neighbor, current.getX(), current.getY(), hops , cost);	//EXPLORE THE NODE
						explored.add(neighbor);	//ADD THE NODE TO THE LIST
					}
				}
			}
		}
		return explored;
	}
	
	public void exploreW(Node current, int lastx, int lasty, int hops , double cost) {	//EXPLORE A NODE
		//System.out.println("_____________explor____________");
		if(current.getType()!= 's' && current.getType() != 'e') {	//CHECK THAT THE NODE IS NOT THE START OR FINISH
			current.setChecked();
			//grid.Grid[current.x][current.y].setChecked();
			System.out.println("* (" + current.x + " , " + current.y + ")");
		}
		//SET IT TO EXPLORED
		current.setLastNode(lastx, lasty);
		System.out.println("__________________________________________:::::::::::::" + lastx);
		//KEEP TRACK OF THE NODE THAT THIS NODE IS EXPLORED FROM
		current.jumps = hops;	//SET THE HOPS FROM THE START
		
		current.cost += cost(grid.Grid[lastx][lasty],current);
		
		//current.cost = cost;
		
		checks++;
		if(current.getType() == 'e') {	//IF THE NODE IS THE FINISH THEN BACKTRACK TO GET THE PATH
			System.out.println("____________________________________________________________+++++" + hops);
			backtrackW(current.parent_x, current.parent_y, hops);
		}
	}
	
	
	public void backtrackW(int lx, int ly, int count) {	//BACKTRACK
		System.out.println("____________bacTrac_____________");
		length = count;
		System.out.println("______________________________________________count =  " + length); 
		while(count > 1) {	//BACKTRACK FROM THE END OF THE PATH TO THE START

			Node current = grid.Grid[lx][ly];
			
			current.setFinalPathA();
			grid.Grid[current.x][current.y].setFinalPathA();
			
			
			lx = current.parent_x;
			ly = current.parent_y;
			System.out.println("_________________________-=====++++" + current.parent_x);
			
			count--;
		}
		solving = false;
	}
	
	public void USearch() {
		

		int[] start;
		int[] end;
		
		start = grid.start;
		end = grid.end;
		
		solving = true;
		
		ArrayList<Node> priority = new ArrayList<Node>();
		priority.add(grid.Grid[start[0]][start[1]]);
		
		
		while(solving) {
			
			
			System.out.println("__________while()_______________");
			
			
			if(priority.size() <= 0) {
				solving = false;
				break;
			}
			
			
			int jumps = priority.get(0).jumps+1;
			
			
			ArrayList<Node> explored = exploreNeighbors(priority.get(0),jumps);
			if(explored.size() > 0) {
				
				priority.remove(0);
				priority.addAll(explored);
				
				//LIVE UPDATE
				scene.updateMap();
				
				
			} else {
				priority.remove(0);
			}
			sortQue(priority);	//SORT THE PRIORITY QUE
		}
	}
	
	public ArrayList<Node> sortQue(ArrayList<Node> sort) {	//SORT PRIORITY QUE
		
		System.out.println("___________sortQ______________");
		int[] start;
		int[] end;
		
		start = grid.start;
		end = grid.end;
		
		int c = 0;
		while(c < sort.size()) {
			int sm = c;
			for(int i = c+1; i < sort.size(); i++) {
				
				if(sort.get(i).getEuclidDist(end[0],end[1])+sort.get(i).jumps < sort.get(sm).getEuclidDist(end[0],end[1])+sort.get(sm).jumps){
					sm = i;
				}
			}
			if(c != sm) {
				Node temp = sort.get(c);
				sort.set(c, sort.get(sm));
				sort.set(sm, temp);
			}	
			c++;
		}
		return sort;
	}
	
	public ArrayList<Node> exploreNeighbors(Node current, int hops) {	//EXPLORE NEIGHBORS
		System.out.println("____________exploreNei_____________");
		ArrayList<Node> explored = new ArrayList<Node>();	//LIST OF NODES THAT HAVE BEEN EXPLORED
		for(int a = -1; a <= 1; a++) {
			for(int b = -1; b <= 1; b++) {
				int xbound = current.getX()+a;
				int ybound = current.getY()+b;
				if((xbound > -1 && xbound < 160) && (ybound > -1 && ybound < 120)) {	
					//MAKES SURE THE NODE IS NOT OUTSIDE THE GRID
					Node neighbor = grid.Grid[xbound][ybound];
					if((neighbor.jumps ==-1 || neighbor.jumps > hops) && neighbor.getType()!= '0') {	//CHECKS IF THE NODE IS NOT A WALL AND THAT IT HAS NOT BEEN EXPLORED
						
						//cost(neighbor , current);
						
						explore(neighbor, current.getX(), current.getY(), hops);	//EXPLORE THE NODE
						explored.add(neighbor);	//ADD THE NODE TO THE LIST
					}
				}
			}
		}
		return explored;
	}
	
	public void explore(Node current, int lastx, int lasty, int hops) {	//EXPLORE A NODE
		System.out.println("_____________explor____________");
		if(current.getType()!= 's' && current.getType() != 'e') {	//CHECK THAT THE NODE IS NOT THE START OR FINISH
			current.setChecked();
			//grid.Grid[current.x][current.y].setChecked();
			System.out.println("* (" + current.x + " , " + current.y + ")");
		}
		//SET IT TO EXPLORED
		current.setLastNode(lastx, lasty);
		System.out.println("__________________________________________:::::::::::::" + lastx);
		//KEEP TRACK OF THE NODE THAT THIS NODE IS EXPLORED FROM
		current.jumps = hops;	//SET THE HOPS FROM THE START
		checks++;
		if(current.getType() == 'e') {	//IF THE NODE IS THE FINISH THEN BACKTRACK TO GET THE PATH
			//System.out.println("____________________________________________________________" + hops);
			backtrack(current.parent_x, current.parent_y, hops);
		}
	}
	
	public void backtrack(int lx, int ly, int count) {	//BACKTRACK
		System.out.println("____________bacTrac_____________");
		length = count;
		//System.out.println("______________________________________________count =  " + length); 
		while(count >= 1) {	//BACKTRACK FROM THE END OF THE PATH TO THE START
			System.out.println("_________________________");
			Node current = grid.Grid[lx][ly];
			
			current.setFinalPath();
			grid.Grid[current.x][current.y].setFinalPath();
			
			System.out.println("_________________________-=====++++" + current.parent_x);
			lx = current.parent_x;
			ly = current.parent_y;
			count--;
		}
		solving = false;
	}
	
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
	
	public List<Node> findPath(Node node, GridGenerator grid) {
		Node temp = grid.Grid[grid.end[0]][grid.end[1]];
		List<Node> path = new ArrayList<>();
		do {
			path.add(temp);
			temp = temp.getNodeParent();
		}
		while (temp != grid.Grid[grid.start[0]][grid.start[1]]);

		//for (Node n : path) {
		//	n.getRectangle().setFill(Color.GREEN);
		//}
		return path;
	}

	public List<Node> getNeighbors(Node node, Node[][] grid) {
		int[][] NEIGHBOR_POINTS = {
						{-1, 0},
						{ 0,-1},
						{0, 1},
						{ 1, 0},
						{-1,-1},
						{-1,1},
						{1,1},
						{1,-1}
				};

				List<Node> neighbors = new ArrayList<>();

				for (int[] neighborPositions : NEIGHBOR_POINTS) {
					int nrow = node.getX() + neighborPositions[0];
					int ncol = node.getY() + neighborPositions[1];
					if (nrow >= 0 && nrow < 120 && ncol >= 0 && ncol < 160) {
						neighbors.add(grid[nrow][ncol]);
					}
				}
				return neighbors;
			}
////////////////////////////////////////////
/*
		while (!fringe.isEmpty()) {
			Node cur = fringe.remove();

			if (cur.x == test.end[0] && cur.y == test.end[1]) {
				//Path Found
			}


		}
	}
*/

	//FInd shortest path from start to current node
	public double findG(Node cur, Node start) {
		
		double dist = Math.sqrt((( start.x - cur.x )*2) + (( start.y - cur.y)*2));
		return dist;
		
	}

	//Finding the euclidean distance between the current node and the end node
	public double h(Node n, Node end) {
		double dist = Math.sqrt(((n.x - end.x)*2) + ((n.y - end.y)*2));
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
}
