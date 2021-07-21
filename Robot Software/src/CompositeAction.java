import java.util.ArrayList;

public class CompositeAction extends AbstractAction {

	private ArrayList<AbstractAction> aActions;
	
	/**
	 * Constructor that initializes a CompositeAction. Calls the super constructor with a false parameter.
	 * 
	 * @param pActions
	 * 			list of actions to be performed by the robot
	 * 
	 * @pre pActions != null
	 */
	public CompositeAction(ArrayList<AbstractAction> pActions) {
		
		super(false);
		
		assert pActions != null;
		aActions = pActions;
	}
	
	
	@Override
	/**
	 * Calls execute
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 * 
	 * @pre pRobot != null
	 */
	public void perform(WallE pRobot) {
		
		assert pRobot != null;
		execute(pRobot);
	}
	
	
	@Override
	/**
	 * Performs all the actions in the list consecutively 
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 * 
	 * @pre pRobot != null
	 */
	protected void execute(WallE pRobot) {
		
		assert pRobot != null;
		
		for (AbstractAction a : aActions) {
		
			a.perform(pRobot);
		}
	}
	
	
	@Override
	/**
	 * Getter method for the total distance to be traveled as a result of this action
	 * 
	 * @return the sum of the distances of all actions in the list
	 */
	public double getDistanceToTravel() {
		
		double totalDistance = 0;
		
		for (AbstractAction a : aActions) {
			
			totalDistance = totalDistance + a.getDistanceToTravel();
		}
		
		return totalDistance;
	}
	
	
	@Override
	/**
	 * Getter method for the total number of objects to be compacted as a result of this action
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
