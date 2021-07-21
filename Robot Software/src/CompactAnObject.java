
public class CompactAnObject extends AbstractAction {
	
	/**
	 * Constructor that initializes the CompactAnObject action. Calls the super constructor.
	 * 
	 * @param pChargeBeforeAction
	 * 		true if client wants to fully charge before performing the action, false otherwise.
	 * 
	 */
	public CompactAnObject(boolean pChargeBeforeAction) {
		
		super(pChargeBeforeAction);
	}
	
	
	@Override
	/**
	 * Compacts an object if the conditions are not violated. Otherwise, change the state of the robot and compact the object
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 * 
	 * @pre (pRobot != null) && (pRobot.getGripperState() == Robot.GripperState.HOLDING_OBJECT) && (pRobot.getCompactorLevel() < 10)
	 * @post gripper is open
	 */
	protected void execute(WallE pRobot) {
		
		assert pRobot != null;

		if (pRobot.getCompactorLevel() >= 10) {
			
			pRobot.emptyCompactor();
		}
		
		switch (pRobot.getGripperState()) {
			
			case HOLDING_OBJECT: 
				pRobot.compact();
				break;
		
			case EMPTY:
				pRobot.openGripper();
				break;
		
			case OPEN:
				break;
		} 
	}
	
	
	@Override
	/**
	 * Getter method for the total number of objects to be compacted as a result of this action
	 * 
	 * @return 1
	 */
	public int getNumberOfObjectsToBeCompacted() {
		
		return 1;
	}
}
