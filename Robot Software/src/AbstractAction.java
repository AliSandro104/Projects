
public abstract class AbstractAction {
	
	private boolean aChargeBeforeAction;
	
	
	/**
	 * Constructor that initializes an abstract action
	 * Will be called by subclasses to instantiate the aChargeBeforeAction field.
	 * 
	 * @param pChargeBeforeAction
	 * 		true if client wants to fully charge before performing the action, false otherwise.
	 */
	protected AbstractAction(boolean pChargeBeforeAction) {
		
		aChargeBeforeAction = pChargeBeforeAction;
	}
	
	
	/**
	 * Charge battery if necessary, calls execute and log and updates the battery level.
	 * The CompositeAction class will override this method
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 * 
	 * @pre pRobot != null
	 */
	public void perform(WallE pRobot) {
		
		assert pRobot != null;
		rechargeBatteryIfLowOrIfClientWants(pRobot);
		execute(pRobot);
		pRobot.updateBatteryLevel();
		log(pRobot);
	}
	
	
	/**
	 * The implementation of this method will be given by the subclasses.
	 * 
	 * It performs the corresponding action if the preconditions are not violated.
	 * If the conditions are violated, we change the state of the robot and then perform the action.
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 * 
	 * @pre pRobot != null
	 */
	protected abstract void execute(WallE pRobot);
	
	
	/**
	 * Every time an action is performed, log the statement "X action performed, battery level is Y"
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 * 
	 * @pre pRobot != null
	 */
	private void log(WallE pRobot) {
		
		assert pRobot != null;
		
		System.out.println(getClass().getName() + " action performed, battery level is " + pRobot.getBatteryCharge());
	}
	
	
	/**
	 * If the charge of the battery is <= 5 units or if client wants to charge before the action, then fully charge the battery of the robot
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 * 
	 * @pre pRobot != null
	 */
	public void rechargeBatteryIfLowOrIfClientWants(WallE pRobot) {
		
		assert pRobot != null;
		
		if (aChargeBeforeAction) {
			
			pRobot.rechargeBattery();
		
		} else if (pRobot.getBatteryCharge() <= 5) {
			
			pRobot.rechargeBattery();
		}
	}
	
	
	/**
	 * Getter method for the total distance to be traveled as a result of this action
	 * This method will be overriden by the actions that will make the robot move
	 * 
	 * @return 0 by default. 
	 */
	public double getDistanceToTravel() {
		
		return 0;
	}
	
	
	/**
	 * Getter method for the total number of objects to be compacted as a result of this action
	 * This method will be overriden by the actions that will actually compact an object
	 * 
	 * @return 0 by default. 
	 */
	public int getNumberOfObjectsToBeCompacted() {
		
		return 0;
	}
}