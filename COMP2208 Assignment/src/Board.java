
public class Board {
	
	public String initialState;
	public String goalState;
	
	public Board(String initial, String goal){
		this.initialState = initial;
		this.goalState = goal;
	}
	
	
	public void setInitialState(String initial){
		this.initialState = initial;
	}
	
	public void setGoalState(String goal){
		this.goalState = goal;
	}
	
	public String getInitialState(){
		return this.initialState;
	}
	
	public String getGoalState(){
		return this.goalState;
	}
	
	
	

}
