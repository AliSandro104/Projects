import java.util.ArrayList;

public class Program {

	ArrayList<AbstractAction> aActions;
	
	/**
	 * Constructor that initializes a program to be transferred to a robot.
	 */
	public Program() {
		
		aActions = new ArrayList<AbstractAction>();
	}
	
	
	/**
	 * Adds the action to the program that will be executed by the robot
	 * 
	 * @param pAction
	 * 		basic action to be performed
	 * 
	 * @pre pAction != null
	 */
	public void addAction(AbstractAction pAction) {
		
		assert pAction != null;	
		aActions.add(pAction);
	}
	
	/**
	 * Removes the last action from the program that will be executed by the robot
	 * 
	 * @return the Action that was removed
	 * 
	 * @pre aActions.size() > 0
	 * 
	 */
	public AbstractAction removeAction() {
		
		assert aActions.size() > 0;
		
		return aActions.remove(aActions.size() - 1);
	}
	
	
	/**
	 * Performs all the actions in the program
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 * 
	 * @pre pRobot != null
	 */
	public void runProgram(WallE pRobot) {
		
		assert pRobot != null;
		
		for (AbstractAction a : aActions) {
		
			a.perform(pRobot);
		}
	}
	
	
	/**
	 * Getter method for the total distance to be traveled as a result of the whole program
	 * 
	 * @return the sum of the distances of all actions in the program
	 */
	public double getDistanceToTravel() {
		
		double totalDistance = 0;
		
		for (AbstractAction a : aActions) {
			
			totalDistance = totalDistance + a.getDistanceToTravel();
		}
		
		return totalDistance;
	}
	
	
	/**
	 * Getter method for the total number of objects to be compacted as a result of the whole program
	 * 
	 * @return the sum of the number of objects to be compacted
	 */
	public int getNumberOfObjectsToBeCompacted() {
		
		int totalObjects = 0;
		
		for (AbstractAction a : aActions) {
			
			 totalObjects =  totalObjects + a.getNumberOfObjectsToBeCompacted();
		}
		
		return totalObjects;
	}
}
