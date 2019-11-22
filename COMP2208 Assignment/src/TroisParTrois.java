
public class TroisParTrois extends Board {

	public TroisParTrois(String initial, String goal) {
		super(initial, goal);
		int initLen = initial.length();
		int goalLen = goal.length();
		if (initLen != 9 || goalLen != 9) {
			setInitialState("Incorrect");
			setGoalState("Incorrect");
			}
	}
	
	

}
