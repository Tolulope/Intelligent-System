import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Helper {
	
	 public static List<String> getFringe(String state) {
		 List<String> theSuccessors = null;
		 if (state.length() == 9){
			 theSuccessors = getFringe3(state);
		 } else if (state.length() == 16){
			 theSuccessors = getFringe4(state);
		 }  else if (state.length() == 25){
			 theSuccessors = getFringe5(state);
		 }
		 return theSuccessors;
	 }
	
    public static List<String> getFringe3(String state) {
        List<String> fringe = new ArrayList<String>();

        switch (state.indexOf("S")) {
            case 0: {
            	fringe.add(swapChars(state, 0, 1));
            	fringe.add(swapChars(state, 0, 3));
                
                break;
            }
            case 1: {
            	fringe.add(swapChars(state, 1, 2));
            	fringe.add(swapChars(state, 1, 4));
            	fringe.add(swapChars(state, 1, 0));
              
                break;
            }
            case 2: {
            	fringe.add(swapChars(state, 2, 1));
            	fringe.add(swapChars(state, 2, 5));
                
                break;
            }
            case 3: {
            	fringe.add(swapChars(state, 3, 4));
            	fringe.add(swapChars(state, 3, 6));
            	fringe.add(swapChars(state, 3, 0));
                
                break;
            }
            case 4: {
            	fringe.add(swapChars(state, 4, 1));
            	fringe.add(swapChars(state, 4, 3));
            	fringe.add(swapChars(state, 4, 5));
            	fringe.add(swapChars(state, 4, 7));
                
                break;
            }
            case 5: {
            	fringe.add(swapChars(state, 5, 2));
            	fringe.add(swapChars(state, 5, 4));
            	fringe.add(swapChars(state, 5, 8));
                
                break;
            }
            case 6: {
            	fringe.add(swapChars(state, 6, 3));
            	fringe.add(swapChars(state, 6, 7));
               
                break;

            }
            case 7: {
            	fringe.add(swapChars(state, 7, 4));
            	fringe.add(swapChars(state, 7, 6));
            	fringe.add(swapChars(state, 7, 8));
                
                break;
            }
            case 8: {
            	fringe.add(swapChars(state, 8, 5));
            	fringe.add(swapChars(state, 8, 7));
            	
                break;
            }
        }

        return fringe;


    }
    
    public static List<String> getFringe4(String state) {
        List<String> fringe = new ArrayList<String>();
    
    switch (state.indexOf("S")) {
    case 0: {
    	fringe.add(swapChars(state, 0, 1));
    	fringe.add(swapChars(state, 0, 4));
       
        break;
    }
    case 1: {
    	fringe.add(swapChars(state, 1, 2));
    	fringe.add(swapChars(state, 1, 5));
    	fringe.add(swapChars(state, 1, 0));
     
        break;
    }
    case 2: {
    	fringe.add(swapChars(state, 2, 1));
    	fringe.add(swapChars(state, 2, 6));
    	fringe.add(swapChars(state, 2, 3));
    	
    
        break;
    }
    case 3: {
    	fringe.add(swapChars(state, 3, 2));
    	fringe.add(swapChars(state, 3, 7));
    	
        break;
    }
    case 4: {
    	fringe.add(swapChars(state, 4, 0));
    	fringe.add(swapChars(state, 4, 5));
    	fringe.add(swapChars(state, 4, 8));
       
        break;
    }
    case 5: {
    	fringe.add(swapChars(state, 5, 1));
    	fringe.add(swapChars(state, 5, 4));
    	fringe.add(swapChars(state, 5, 6));
    	fringe.add(swapChars(state, 5, 9));
        
        break;
    }
    case 6: {
    	fringe.add(swapChars(state, 6, 2));
    	fringe.add(swapChars(state, 6, 5));
    	fringe.add(swapChars(state, 6, 7));
    	fringe.add(swapChars(state, 6, 10));
       
        break;

    }
    case 7: {
    	fringe.add(swapChars(state, 7, 3));
    	fringe.add(swapChars(state, 7, 6));
    	fringe.add(swapChars(state, 7, 11));
        
        break;
    }
    case 8: {
    	fringe.add(swapChars(state, 8, 4));
    	fringe.add(swapChars(state, 8, 9));
    	fringe.add(swapChars(state, 8, 12));
    	
        break;
    }
    
    case 9: {
    	fringe.add(swapChars(state, 9, 5));
    	fringe.add(swapChars(state, 9, 8));
    	fringe.add(swapChars(state, 9, 10));
    	fringe.add(swapChars(state, 9, 13));
    	
    	
        break;
    }
    
    case 10: {
    	fringe.add(swapChars(state, 10, 6));
    	fringe.add(swapChars(state, 10, 9));
    	fringe.add(swapChars(state, 10, 11));
    	fringe.add(swapChars(state, 10, 14));
    	
        break;
    }
    
    case 11: {
    	fringe.add(swapChars(state, 11, 7));
    	fringe.add(swapChars(state, 11, 10));
    	fringe.add(swapChars(state, 11, 15));
    	
        break;
    }
    
    case 12: {
    	fringe.add(swapChars(state, 12, 8));
    	fringe.add(swapChars(state, 12, 7));
    	
        break;
    }
    
    case 13: {
    	fringe.add(swapChars(state, 13, 9));
    	fringe.add(swapChars(state, 13, 14));
    	fringe.add(swapChars(state, 13, 12));
    	
        break;
    }
    
    case 14: {
    	fringe.add(swapChars(state, 14, 10));
    	fringe.add(swapChars(state, 14, 13));
    	fringe.add(swapChars(state, 14, 15));
    	
        break;
    }
    
    case 15: {
    	fringe.add(swapChars(state, 15, 11));
    	fringe.add(swapChars(state, 15, 14));
    	
        break;
    }
  }
    
    return fringe;
    }
    
    
    public static List<String> getFringe5(String state) {
        List<String> fringe = new ArrayList<String>();
    
    switch (state.indexOf("S")) {
    case 0: {
    	fringe.add(swapChars(state, 0, 1));
    	fringe.add(swapChars(state, 0, 5));
       
        break;
    }
    case 1: {
    	fringe.add(swapChars(state, 1, 2));
    	fringe.add(swapChars(state, 1, 6));
    	fringe.add(swapChars(state, 1, 0));
     
        break;
    }
    case 2: {
    	fringe.add(swapChars(state, 2, 1));
    	fringe.add(swapChars(state, 2, 7));
    	fringe.add(swapChars(state, 2, 3));
    	
    
        break;
    }
    case 3: {
    	fringe.add(swapChars(state, 3, 2));
    	fringe.add(swapChars(state, 3, 4));
    	fringe.add(swapChars(state, 3, 8));
    	
        break;
    }
    case 4: {
    	fringe.add(swapChars(state, 4, 3));
    	fringe.add(swapChars(state, 4, 9));
       
        break;
    }
    case 5: {
    	fringe.add(swapChars(state, 5, 0));
    	fringe.add(swapChars(state, 5, 6));
        
        break;
    }
    case 6: {
    	fringe.add(swapChars(state, 6, 1));
    	fringe.add(swapChars(state, 6, 5));
    	fringe.add(swapChars(state, 6, 7));
    	fringe.add(swapChars(state, 6, 11));
       
        break;

    }
    case 7: {
    	fringe.add(swapChars(state, 7, 2));
    	fringe.add(swapChars(state, 7, 6));
    	fringe.add(swapChars(state, 7, 8));
    	fringe.add(swapChars(state, 7, 12));
        
        break;
    }
    case 8: {
    	fringe.add(swapChars(state, 8, 3));
    	fringe.add(swapChars(state, 8, 7));
    	fringe.add(swapChars(state, 8, 9));
    	fringe.add(swapChars(state, 8, 13));
    	
        break;
    }
    
    case 9: {
    	fringe.add(swapChars(state, 9, 4));
    	fringe.add(swapChars(state, 9, 8));
    	fringe.add(swapChars(state, 9, 14));
    	
    	
        break;
    }
    
    case 10: {
    	fringe.add(swapChars(state, 10, 5));
    	fringe.add(swapChars(state, 10, 11));
    	fringe.add(swapChars(state, 10, 15));
    	
        break;
    }
    
    case 11: {
    	fringe.add(swapChars(state, 11, 6));
    	fringe.add(swapChars(state, 11, 10));
    	fringe.add(swapChars(state, 11, 12));
    	fringe.add(swapChars(state, 11, 16));
    	
        break;
    }
    
    case 12: {
    	fringe.add(swapChars(state, 12, 7));
    	fringe.add(swapChars(state, 12, 11));
    	fringe.add(swapChars(state, 12, 13));
    	fringe.add(swapChars(state, 12, 17));
    	
        break;
    }
    
    case 13: {
    	fringe.add(swapChars(state, 13, 8));
    	fringe.add(swapChars(state, 13, 14));
    	fringe.add(swapChars(state, 13, 12));
    	fringe.add(swapChars(state, 13, 18));
    	
        break;
    }
    
    case 14: {
    	fringe.add(swapChars(state, 14, 9));
    	fringe.add(swapChars(state, 14, 13));
    	fringe.add(swapChars(state, 14, 19));
    	
        break;
    }
    
    case 15: {
    	fringe.add(swapChars(state, 15, 10));
    	fringe.add(swapChars(state, 15, 16));
    	fringe.add(swapChars(state, 15, 20));
    	
        break;
    }
    case 16: {
    	fringe.add(swapChars(state, 16, 11));
    	fringe.add(swapChars(state, 16, 15));
    	fringe.add(swapChars(state, 16, 17));
    	fringe.add(swapChars(state, 16, 21));
    	
        break;
    }
    case 17: {
    	fringe.add(swapChars(state, 17, 12));
    	fringe.add(swapChars(state, 17, 16));
    	fringe.add(swapChars(state, 17, 18));
    	fringe.add(swapChars(state, 17, 22));
    	
        break;
    }
    case 18: {
    	fringe.add(swapChars(state, 18, 13));
    	fringe.add(swapChars(state, 18, 17));
    	fringe.add(swapChars(state, 18, 19));
    	fringe.add(swapChars(state, 18, 23));
    	
        break;
    }
    case 19: {
    	fringe.add(swapChars(state, 19, 14));
    	fringe.add(swapChars(state, 19, 18));
    	fringe.add(swapChars(state, 19, 24));
    	
        break;
    }
    case 20: {
    	fringe.add(swapChars(state, 20, 15));
    	fringe.add(swapChars(state, 20, 21));
    	
        break;
    }
    case 21: {
    	fringe.add(swapChars(state, 21, 16));
    	fringe.add(swapChars(state, 21, 20));
    	fringe.add(swapChars(state, 21, 22));
    	
        break;
    }
    case 22: {
    	fringe.add(swapChars(state, 22, 17));
    	fringe.add(swapChars(state, 22, 21));
    	fringe.add(swapChars(state, 22, 23));
    	
        break;
    }
    case 23: {
    	fringe.add(swapChars(state, 23, 18));
    	fringe.add(swapChars(state, 23, 22));
    	fringe.add(swapChars(state, 23, 24));
    	
        break;
    }
    case 24: {
    	fringe.add(swapChars(state, 24, 19));
    	fringe.add(swapChars(state, 24, 23));
    	
        break;
    }

  }
    
    return fringe;
    }
    

    
    private static String swapChars(String str, int lIdx, int rIdx) {
        StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(lIdx), r = sb.charAt(rIdx);
        sb.setCharAt(lIdx, r);
        sb.setCharAt(rIdx, l);
        return sb.toString();
    }



   
    public static void printSolution(Node goalNode, Set<String> visitedNodes, Node root, int time) {

        int totalCost = 0;

        Stack<Node> solutionStack = new Stack<Node>();
        solutionStack.push(goalNode);
        while (!goalNode.getState().equals(root.getState())) {
            solutionStack.push(goalNode.getParent());
            goalNode = goalNode.getParent();
        }
        String sourceState = root.getState();
        String destinationState;
       
        System.out.println("SOLUTION"); 
        for (int i = solutionStack.size() - 1; i >= 0; i--) {
           
            destinationState = solutionStack.get(i).getState();
            

            sourceState = destinationState;
            if ( solutionStack.get(i).getState().length() == 9) {
	            System.out.println("*******");
	            System.out.println("* " + solutionStack.get(i).getState().substring(0, 3)+" *");
	            System.out.println("* " + solutionStack.get(i).getState().substring(3, 6)+" *");
	            System.out.println("* " + solutionStack.get(i).getState().substring(6, 9)+" *");
	            System.out.println("*******");
            }
            if (solutionStack.get(i).getState().length() == 16) {
                System.out.println("********");
                System.out.println("* " + solutionStack.get(i).getState().substring(0, 4)+" *");
                System.out.println("* " + solutionStack.get(i).getState().substring(4, 8)+" *");
                System.out.println("* " + solutionStack.get(i).getState().substring(8, 12)+" *");
                System.out.println("* " + solutionStack.get(i).getState().substring(12, 16)+" *");
                System.out.println("********");
                }
            if (solutionStack.get(i).getState().length() == 25) {
                System.out.println("*********");
                System.out.println("* " + solutionStack.get(i).getState().substring(0, 5)+" *");
                System.out.println("* " + solutionStack.get(i).getState().substring(5, 10)+" *");
                System.out.println("* " + solutionStack.get(i).getState().substring(10, 15)+" *");
                System.out.println("* " + solutionStack.get(i).getState().substring(15, 20)+" *");
                System.out.println("* " + solutionStack.get(i).getState().substring(20, 25)+" *");
                System.out.println("*********");
                }
        }
        
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("** Number of transitions to get to the goal state:  " + (solutionStack.size() - 1));
        System.out.println("** Number of visited nodes:  " + (visitedNodes.size()));
        System.out.println("** Number of Nodes expanded: " + time);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

    }
    
    
    public static void printBoard(String board){
        if ( board.length() == 9) {
            System.out.println("*******");
            System.out.println("* " + board.substring(0, 3)+" *");
            System.out.println("* " + board.substring(3, 6)+" *");
            System.out.println("* " + board.substring(6, 9)+" *");
            System.out.println("*******");
        }
        if (board.length() == 16) {
            System.out.println("********");
            System.out.println("* " + board.substring(0, 4)+" *");
            System.out.println("* " + board.substring(4, 8)+" *");
            System.out.println("* " + board.substring(8, 12)+" *");
            System.out.println("* " + board.substring(12, 16)+" *");
            System.out.println("********");
            }
        if (board.length() == 25) {
            System.out.println("*********");
            System.out.println("* " + board.substring(0, 5)+" *");
            System.out.println("* " + board.substring(5, 10)+" *");
            System.out.println("* " + board.substring(10, 15)+" *");
            System.out.println("* " + board.substring(15, 20)+" *");
            System.out.println("* " + board.substring(20, 25)+" *");
            System.out.println("*********");
            }
    } 
    
    

}


