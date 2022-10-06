package BFS;

public class EpuzzleSearch extends Search {

	  private int[][] target;
	  private int[][] epuzz;
	  
	  //constructor
	  public EpuzzleSearch(int[][] e, int[][] t){
		this.epuzz = e;
		this.target = t;
	  }

	  public int[][] getEpuzz(){
		  return epuzz;
	  }
	  
	  public int[][] getTarget(){
		  return target;
	  }
}