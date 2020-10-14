class Node{
  double weight;
  char type;

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



}
