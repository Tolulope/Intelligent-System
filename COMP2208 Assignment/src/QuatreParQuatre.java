
public class QuatreParQuatre extends Board{

	public QuatreParQuatre(String initial, String goal) {
		super(initial, goal);
		int initLen = initial.length();
		int goalLen = goal.length();
		if (initLen != 16 || goalLen != 16) {
			setInitialState("Incorrect");
			setGoalState("Incorrect");
			}
	}

}
