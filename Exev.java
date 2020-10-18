
class Exev{

  public static void main(String[] args) {
    System.out.println("Hello, World");
    GridGenerator test = new GridGenerator();
    new DrawGrid(test);
    Algorithm a = new Algorithm();
    a.AStar();
    test.writeToFile("test1.txt");
    //int[] start = {0,0};
    //int[] end = {159,119};
  //  GridGenerator test = new GridGenerator();
    //test.stats();
    //test = new GridGenerator();
  //  test.stats();
  //  test.hardCells();

    //test.writeToFile("test1.txt");
    // test.stats();
     //int[] res = GridGenerator.genEnd();
     //System.out.println(""+ res[0]+res[1]);
    // test.traverse();
     //test.blockedCells();
    // test.traverse();
    //test.traverse();
  //  test.writeToFile("test1.txt");
  //  System.out.println((int)Math.random()*20);
  }
}
