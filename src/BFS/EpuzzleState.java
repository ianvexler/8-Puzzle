package BFS;

import java.util.*;

public class EpuzzleState extends SearchState {

    private int[][] currentPuzzle;

    //constructor
    public EpuzzleState(int[][] currentPuzzle) {
        this.currentPuzzle = currentPuzzle;
    }

    public int[][] getCurrentPuzzle() {
        return currentPuzzle;
    }
    
    public boolean goalPredicate(Search searcher){
        EpuzzleSearch epuzzSearcher = (EpuzzleSearch) searcher;
        int[][] target = epuzzSearcher.getTarget();
        
        Boolean isEqual = false;    	
        
        //Iterates through the current puzzle and checks each value one by one and compares them with the target
        for(int i = 0; i < currentPuzzle.length; i ++) {
     		for(int u = 0; u < currentPuzzle[i].length; u++) {
     			if(currentPuzzle[i][u] == target[i][u]) {
     				isEqual = true;
     			} else {
     				return false;
     			}
    		}
    	}
        
        return isEqual;
    }

    //Gets all successors by swapping the zero when possible
    public ArrayList<SearchState> getSuccessors(Search searcher){
    	int[][] puzzle = currentPuzzle;
        
        ArrayList<EpuzzleState> pslis = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> slis = new ArrayList<SearchState>();
        
        //Iterates through the current puzzle,
        for(int i = 0; i < puzzle.length; i++){
        	for(int u = 0; u < puzzle[i].length; u++) {
        		
        		if(puzzle[i][u] == 0) {
        			if(u > 0) { //Move above
        				int[][] copyArray = copyArray(puzzle);
        				//Swaps values with the number above
        				copyArray[i][u] = puzzle[i][u-1];
        				copyArray[i][u-1] = 0;
						pslis.add(new EpuzzleState(copyArray));
        			}
        			
        			if(u < (puzzle[i].length - 1)) { //Move bellow
        				int[][] copyArray = copyArray(puzzle);
        				//Swaps values with the number bellow 
        				copyArray[i][u] = puzzle[i][u+1];
        				copyArray[i][u+1] = 0;
						pslis.add(new EpuzzleState(copyArray));
        			}
        			
        			if(i < (puzzle.length - 1)) { //Move right
        				int[][] copyArray = copyArray(puzzle);
        				//Swaps values with the number on the right
        				copyArray[i][u] = puzzle[i+1][u];
        				copyArray[i+1][u] = 0;
						pslis.add(new EpuzzleState(copyArray));
        			}
        			
        			if(i > 0) { //Move left
        				int[][] copyArray = copyArray(puzzle);
        				//Swaps values with the number on the left
        				copyArray[i][u] = puzzle[i-1][u];
        				copyArray[i-1][u] = 0;
						pslis.add(new EpuzzleState(copyArray));
        			}
        		}
        	}
        }
        
        for (EpuzzleState ps : pslis) {
            slis.add((SearchState) ps);
        }
        
        return slis;
    }
    
    //Checks if it has the same state by comparing every item currentPuzzle to the desired puzzle
    public boolean sameState(SearchState n2) {
        EpuzzleState puzzleState2 = (EpuzzleState) n2;
        Boolean isEqual = false;    	
        
        //For loop that will compare if all the items are equal, if not return false
        for(int i = 0; i < currentPuzzle.length; i ++) {
     		for(int u = 0; u < currentPuzzle[i].length; u++) {
     			if(currentPuzzle[i][u] == puzzleState2.getCurrentPuzzle()[i][u]) {
     				isEqual = true;
     			} else {
     				return false;
     			}
    		}
    	}

        return isEqual;
    }
    
    //Prints the puzzle in a 3x3 grid
    public String toString() {
    	String str = "Puzzle State:\n";
    	
    	//For loop to print the puzzles in a 3x3 grid
    	for (int[] i : currentPuzzle) {
    		for(int u : i) {
    			str = str + " " + u;
    		}
    		str = str + "\n";
    	}
        return str;
      }

    
    //Method that copies arrays so that the values can be swapped without affecting the current puzzle
    public int[][] copyArray(int[][] puzz) {
    	int[][] puzzle = new int[puzz.length][];
    	
    	for(int i = 0; i < puzz.length; i ++) {
    		puzzle[i] = new int[puzz[i].length];
    		for(int u = 0; u < puzz[i].length; u++) {
    			puzzle[i][u] = puzz[i][u];
    		}
    	}
    	
    	return puzzle;
    }
    
    // For testing, prints the puzzle array
    public void printArray(int[][] puzz, String s) {
        String str = s;
    	
    	for (int[] i : puzz) {
    		for(int u : i) {
    			str = str + " " + u;
    		}
    		str = str + "\n";
    	}
        System.out.println(str);
    }
}