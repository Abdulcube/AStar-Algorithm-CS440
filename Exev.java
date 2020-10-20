import java.io.*;
class Exev{
	public static void main(String[] args) {
		int[] x= {0,0};
		int[] y= {100,100};
		GridGenerator test = new GridGenerator("test5.txt");
		test.writeToFile("test4.txt");
		//GridGenerator test = new GridGenerator("test2.txt");
		/*GridGenerator test = new GridGenerator();

		test.writeToFile("test2.txt");

		DrawGrid b = new DrawGrid(test);

	    AlternateAlgorithm c  = new AlternateAlgorithm(test,b);
	    c.USearch();

	    c.reset();

	    c.AStar();

	    */




	}
}
