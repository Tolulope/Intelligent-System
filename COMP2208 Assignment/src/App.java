public class App {


    public static void main(String[] args) {
    	Board three = new TroisParTrois("      ABS", "    A  BS");
    	Board four = new QuatreParQuatre("            ABCS", "     A   B   C S");
    	Board five = new CinqParCinq("                    ABCDS", "      A    B    C    D  S");
    	
//    	String rootState = four.initialState;
    	String rootState = three.initialState;
//    	String rootState = five.initialState;

        Search search = new Search(new Node(rootState), three.goalState);
//        Search search = new Search(new Node(rootState), four.goalState);
//        Search search = new Search(new Node(rootState), five.goalState);
        
        search.breadthFirstSearch();
        search.depthFirstSearch();
        search.iterativeDeepening(2);
        search.aStar("Manhattan Distance");
        search.aStar("Misplaced Tiles");
        

    


    }
}
