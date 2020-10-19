import java.io.*;
class Exev{
	public static void main(String[] args) {
    
		
		//GridGenerator test = new GridGenerator("test2.txt");
		GridGenerator test = new GridGenerator();
		
		test.writeToFile("test2.txt");
		
		DrawGrid b = new DrawGrid(test);
		
	    AlternateAlgorithm c  = new AlternateAlgorithm(test,b);	   
	    c.USearch();
	    
	    c.reset();
	    
	    c.AStar();
	    
	    

	    

		
	}
}
