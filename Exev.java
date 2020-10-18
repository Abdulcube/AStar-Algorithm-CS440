import java.io.*;
class Exev{
	public static void main(String[] args) {
    
		//new DrawGrid();
		
		//int[] s = {1,1};
		//int[] e = {119,119};
		
		GridGenerator test = new GridGenerator();
		DrawGrid b = new DrawGrid(test);
		
	    AlternateAlgorithm c  = new AlternateAlgorithm(test,b);
	    //c.USearch();
	    c.AStar();
	    
		
		/*
		GridGenerator test = new GridGenerator();
		
		DrawGrid a = new DrawGrid(test);
		
		//test.Grid[0][0].wasChecked = true;
		
		test.Grid[0][0].isFinalPath = true;
		test.Grid[0][1].isFinalPath = true;
		test.Grid[1][0].isFinalPath = true;
		test.Grid[1][1].isFinalPath = true;
		
		for(int k = 10; k < 100; k++) {
			for(int j = 60; j< 100 ; j++) {
				if (test.Grid[k][j].type == 's' ||  test.Grid[k][j].type == 'e') {continue;} else {
					test.Grid[k][j].wasChecked = true;
					test.Grid[k+20][j-30].isFinalPath = true;
					a.updateMap();		
				}
			}
		}
		*/
	}
}
