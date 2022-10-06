package BFS;

import Astar.*;

public class RunEpuzzleBFS {
	
	public static void main(String[] arg) {
		
		EpuzzGen puzzle = new EpuzzGen();
		
		int[][] P1 = {{1, 0, 3}, {4, 2, 6}, {7, 5, 8}};
		int[][] P2 = {{4, 1, 3}, {7, 2, 5}, {0, 8, 6}};
		int[][] P3 = {{2, 3, 6}, {1, 5, 8}, {4, 7, 0}};
		int[][] target = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
		
		int d = 6;
		int[][] puzz = puzzle.puzzGen(d);
				
		EpuzzleSearch searcher = new EpuzzleSearch(puzz, target);
		SearchState initState = (SearchState) new EpuzzleState(puzz);
		
		String resb = searcher.runSearch(initState, "breadthFirst");
		System.out.println(resb);
		
	  }
	
}
