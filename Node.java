class Node{
  double cost;
  boolean wasChecked;
  boolean isFinalPath;
  char type;
  int x;
  int y;
  int parent_x;
  int parent_y;
  double f,h,g = Double.POSITIVE_INFINITY;
  

  // For the function that is only going to pass in a character, to find weight
  //HashMap<Character, Double> quick = new HashMap<Character, Double>();
  public Node(){
    cost = 0;
    type = '1';
    wasChecked = false;
    this.isFinalPath = false;
  }
  public Node(int c, char type){
    this.cost = c;
    this.type = type;
    this.wasChecked = false;
    this.isFinalPath = false;
  }

  //Need to decide on Weighted Values for the spaces first
  public Node(char type){
    this.type = type;
    this.cost = 0.0;
    this.wasChecked = false;
    this.isFinalPath = false;
  }
  
  //*/
  public Node(char type, int x, int y) {
	  this.cost = 0;
	  this.type = type;
	  this.x = x;
	  this.y= y;  
	  this.wasChecked = false;
	  this.isFinalPath = false;
  }

  public char getType() { return this.type; }
  public int getX() { return this.x; }
  public int getY() { return this.y; }
  public boolean wasChecked() { return this.wasChecked;}
  public double getCost() { return this.cost; }
  
  public void setChecked() {
	  this.wasChecked = true;
  }
  public void setFinalPath() {
	  this.isFinalPath = true;
  }


}
