class Node{
  double weight;
  char type;
  int x;
  int y;
  

  // For the function that is only going to pass in a character, to find weight
  //HashMap<Character, Double> quick = new HashMap<Character, Double>();
  public Node(){
    weight = .25;
    type = '1';
  }
  public Node(int weight, char type){
    this.weight = weight;
    this.type = type;
  }

  //Need to decide on Weighted Values for the spaces first
  public Node( char type){
    this.type = type;
    this.weight = 0.0;
  }
  //*/
  public Node(char type, int x, int y) {
	  if (type == '0') {
		  this.weight = 0; 
	  } else if (type == '1') {
		  this.weight = 0;
	  } else if (type == '2') {
		  this.weight = 0;
	  } else {
		  this.weight = 1;
	  }
	  
	  this.type = type;
	  this.x = x;
	  this.y= y;
	  
  }



}
