package Astar;

public class EpuzzleSearch extends Search {

	  private int[][] target;
	  private int[][] epuzz;
	  private String costStrategy;
	  
	  //Constructor
	  //In this case costStrategy is the method you want to calculate estRemCost (hamming or manhattan)
	  public EpuzzleSearch(int[][] e, int[][] t, String c){
		this.epuzz = e;
		this.target = t;
		this.costStrategy = c.toLowerCase();
	  }

	  public int[][] getEpuzz(){
		  return epuzz;
	  }
	  
	  public int[][] getTarget(){
		  return target;
	  }
	  
	  public String getCostStrategy() {
		  return costStrategy;
	  }
}