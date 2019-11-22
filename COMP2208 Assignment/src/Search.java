import java.util.*;

public class Search {
    private Node root;
    private String goalSate;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public String getGoalSate() {
        return goalSate;
    }

    public void setGoalSate(String goalSate) {
        this.goalSate = goalSate;
    }

    public Search(Node root, String goalSate) {
        this.root = root;
        this.goalSate = goalSate;
    }


    public void breadthFirstSearch() {
    
        Set<String> visitedNodes = new HashSet<String>();     
        int time = 0;
        Node node = new Node(root.getState());       
        Queue<Node> queue = new LinkedList<Node>();       
        Node currentNode = node;
        while (!(currentNode.getState().equals(goalSate))) {
           System.out.println("Current node");
           Helper.printBoard(currentNode.getState());
            visitedNodes.add(currentNode.getState());
            
            List<String> fringe = Helper.getFringe(currentNode.getState());
            
           
           System.out.println("Fringe");
            for (String n : fringe) {
            	Helper.printBoard(n);
                if (visitedNodes.contains(n))
                    continue;
                visitedNodes.add(n);
                
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);
                queue.add(child);
                	

            }
            currentNode = queue.poll();
            
            
            time += 1;
        }
        

        Helper.printSolution(currentNode, visitedNodes, root, time);

    }

    
    public void depthFirstSearch() {
       
        Set<String> visitedNodes = new HashSet<String>();
        
        int time = 0;
        Node node = new Node(root.getState());
       
        MyQueue<Node> mainQueue = new MyQueue<>();

        MyQueue<Node> fringeQueue = new MyQueue<>();

        Node currentNode = node;

        while (!currentNode.getState().equals(goalSate)) {
            System.out.println("Current Node");
            Helper.printBoard(currentNode.getState());
            visitedNodes.add(currentNode.getState());
            
            List<String> fringe = Helper.getFringe(currentNode.getState());
           
            System.out.println("Fringe");
           
            for (String n : fringe) {
            	Helper.printBoard(n);
                if (visitedNodes.contains(n))
                    continue;
                visitedNodes.add(n);
               
                Helper.printBoard(n);
               
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);
                fringeQueue.enqueue(child);
                

            }
           
            mainQueue.addQueue(fringeQueue);
            fringeQueue.clear();
            currentNode = mainQueue.dequeue();
            time += 1;
            fringe.clear();
         
        }
        Helper.printSolution(currentNode, visitedNodes, root, time);

    }
    

    
    public void iterativeDeepening(int depthLimit) {
        Node currentNode = new Node(root.getState());
        boolean solutionFound = false;
       
        Set<String> visitedNodes = new HashSet<String>();
        Set<String> totalVisitedStates = new HashSet<>();
        int time = 0;
    
        for (int maxDepth = 1; maxDepth < depthLimit; maxDepth++) {
            visitedNodes.clear();
            MyQueue<Node> nodeQueue = new MyQueue<>();
            MyQueue<Node> fringeQueue = new MyQueue<>();
            Node node = new Node(root.getState());
            nodeQueue.enqueue(node);
            currentNode = node;
            List<String> fringe = null;
            visitedNodes.add(currentNode.getState());

            while (!nodeQueue.isEmpty()) {
                currentNode = nodeQueue.dequeue();
                time += 1;
                if (currentNode.getState().equals(goalSate)) {
                    solutionFound = true;
                    break;
                }
                if (currentNode.getDepth() <= maxDepth) {
                    fringe = Helper.getFringe(currentNode.getState());
                   
                    for (String n : fringe) {
                        if (visitedNodes.contains(n))
                            continue;

                        visitedNodes.add(n);
                    
                        Node child = new Node(n);
                        currentNode.addChild(child);
                        child.setParent(currentNode);
                        child.setVisited(true);
                        child.setDepth(currentNode.getDepth() + 1);
                        fringeQueue.enqueue(child);

                    }
          	
                    nodeQueue.addQueue(fringeQueue);
                 
                    fringeQueue.clear();
                }
                
            }

            if (solutionFound)
                break;
            totalVisitedStates.addAll(visitedNodes);
        }
        if (!solutionFound)
            System.out.println("No solution Found!");
        else {
            Helper.printSolution(currentNode, totalVisitedStates, root, time);


        }


    }

    public void aStar(String heuristic) {
       
        Set<String> visitedNodes = new HashSet<String>();
        int totalCost = 0;
        int time = 0;
        Node node = new Node(root.getState());
        node.setTotalCost(0);
        
        NodePriorityComparator nodePriorityComparator = new NodePriorityComparator();

        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<Node>(10, nodePriorityComparator);
        Node currentNode = node;

        while (!currentNode.getState().equals(goalSate)) {
            visitedNodes.add(currentNode.getState());
            System.out.println("Current node");
            Helper.printBoard(currentNode.getState());
            List<String> fringe = Helper.getFringe(currentNode.getState());

            System.out.println("Fringe");
            for (String n : fringe) {
            
                if (visitedNodes.contains(n))
                    continue;
                Helper.printBoard(n);
                visitedNodes.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);

                if (heuristic == "Misplaced Tiles")
                    child.setTotalCost(currentNode.getTotalCost() , misplacedTiles(child.getState(), goalSate));
                else if (heuristic == "Manhattan Distance")
                    child.setTotalCost(currentNode.getTotalCost() , manhattanDistance(child.getState(), goalSate));
                
                    
                nodePriorityQueue.add(child);

            }
            currentNode = nodePriorityQueue.poll();
            time += 1;
            

        }
        Helper.printSolution(currentNode, visitedNodes, root, time);
    }


    private int misplacedTiles(String currentState, String goalSate) {
        int difference = 0;
        for (int i = 0; i < currentState.length(); i += 1)
            if (currentState.charAt(i) != goalSate.charAt(i))
                difference += 1;
        return difference;
    }

    
    private int manhattanDistance(String currentState, String goalState) {
        int distance = 0;
        for (int i = 0; i < currentState.length(); i += 1){
            for (int j = 0; j < goalState.length(); j += 1){
                if (currentState.charAt(i) == goalState.charAt(j)){
                    distance = distance + 0;
                } else {
                	distance = Math.abs(getPoint(currentState, i).x - getPoint(goalState, j).x) + Math.abs(getPoint(currentState, i).y - (getPoint(goalState, j).y));
                }
            }
        }
        return distance;
    }
    
	public Point getPoint(String state, int index){
		Point point = null;
		if (state.length() == 9){
			if (index == 0){
				point = new Point(1,3);
			} else if (index == 1){
				point = new Point(2,3);
			} else if (index == 2){
				point = new Point(3,3);
			}else if (index == 3){
				point = new Point(1,2);
			}else if (index == 4){
				point = new Point(2,2);
			}else if (index == 5){
				point = new Point(3,2);
			}else if (index == 6){
				point = new Point(1,1);
			}else if (index == 7){
				point = new Point(2,1);
			}else if (index == 8){
				point = new Point(3,1);
			}
		}
			
			if (state.length() == 16){
				if (index == 0){
					point = new Point(1,4);
				} else if (index == 1){
					point = new Point(2,4);
				} else if (index == 2){
					point = new Point(3,4);
				}else if (index == 3){
					point = new Point(4,4);
				}else if (index == 4){
					point = new Point(1,3);
				}else if (index == 5){
					point = new Point(2,3);
				}else if (index == 6){
					point = new Point(3,3);
				}else if (index == 7){
					point = new Point(4,3);
				}else if (index == 8){
					point = new Point(1,2);
				}else if (index == 9){
					point = new Point(2,2);
				}else if (index == 10){
					point = new Point(3,2);
				}else if (index == 11){
					point = new Point(4,2);
				}else if (index == 12){
					point = new Point(1,1);
				}else if (index == 13){
					point = new Point(2,1);
				}else if (index == 14){
					point = new Point(3,1);
				}else if (index == 15){
					point = new Point(4,1);
				}
			
		}
			
			if (state.length() == 25){
				if (index == 0){
					point = new Point(1,5);
				} else if (index == 1){
					point = new Point(2,5);
				} else if (index == 2){
					point = new Point(3,5);
				}else if (index == 3){
					point = new Point(4,5);
				}else if (index == 4){
					point = new Point(5,5);
				}else if (index == 5){
					point = new Point(1,4);
				}else if (index == 6){
					point = new Point(2,4);
				}else if (index == 7){
					point = new Point(3,4);
				}else if (index == 8){
					point = new Point(4,4);
				}else if (index == 9){
					point = new Point(5,4);
				}else if (index == 10){
					point = new Point(1,3);
				}else if (index == 11){
					point = new Point(2,3);
				}else if (index == 12){
					point = new Point(3,3);
				}else if (index == 13){
					point = new Point(4,3);
				}else if (index == 14){
					point = new Point(5,3);
				}else if (index == 15){
					point = new Point(1,2);
				}else if (index == 16){
					point = new Point(2,2);
				}else if (index == 17){
					point = new Point(3,2);
				}else if (index == 18){
					point = new Point(4,2);
				}else if (index == 19){
					point = new Point(5,2);
				}else if (index == 20){
					point = new Point(1,1);
				}else if (index == 21){
					point = new Point(2,1);
				}else if (index == 22){
					point = new Point(3,1);
				}else if (index == 23){
					point = new Point(4,1);
				}else if (index == 24){
					point = new Point(5,1);
				}
			
		}
			
	
		return point;
	}


}