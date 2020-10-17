class Node{
  double cost;
  boolean wasChecked;
  char type;
  int x;
  int y;
  

  // For the function that is only going to pass in a character, to find weight
  //HashMap<Character, Double> quick = new HashMap<Character, Double>();
  public Node(){
    cost = 0;
    type = '1';
    wasChecked = false;
  }
  public Node(int c, char type){
    this.cost = c;
    this.type = type;
    this.wasChecked = false;
  }

  //Need to decide on Weighted Values for the spaces first
  public Node(char type){
    this.type = type;
    this.cost = 0.0;
    this.wasChecked = false;
  }
  
  //*/
  public Node(char type, int x, int y) {
	  this.cost = 0;
	  this.type = type;
	  this.x = x;
	  this.y= y;  
	  this.wasChecked = false;
  }

  public char getType(Node n) { return this.type; }
  public int getX(Node n) { return this.x; }
  public int getY(Node n) { return this.y; }
  public boolean wasChecked(Node n) { return this.wasChecked;}
  public double getCost(Node n) { return this.cost; }
  
  public void setChecked(Node n) {
	  this.wasChecked = true;
  }


}
