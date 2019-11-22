
public class CinqParCinq extends Board {

	public CinqParCinq(String initial, String goal) {
		super(initial, goal);
		int initLen = initial.length();
		int goalLen = goal.length();
		if (initLen != 25 || goalLen != 25) {
			setInitialState("Incorrect");
			setGoalState("Incorrect");
			}
	}

}
