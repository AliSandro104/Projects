
public class ReleaseAnObject extends AbstractAction {
	
	/**
	 * Constructor that initializes the ReleaseAnObject action. Calls the super constructor.
	 * 
	 * @param pChargeBeforeAction
	 * 		true if client wants to fully charge before performing the action, false otherwise.
	 */
	public ReleaseAnObject(boolean pChargeBeforeAction) {
		
		super(pChargeBeforeAction);
	}
	
	
	@Override
	/**
	 * Releases the object if conditions are not violated. Otherwise, adjust the robot state accordingly and release the object.
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 * 
	 * @pre (pRobot != null) && (pRobot.getArmState() == Robot.ArmState.RETRACTED) && (pRobot.getGripperState() != Robot.GripperState.OPEN)
	 */
	protected void execute(WallE pRobot) {
		
		assert pRobot != null;
			
		if (pRobot.getArmState() != Robot.ArmState.RETRACTED) {
			
			pRobot.retractArm();
		}
		
		if (pRobot.getGripperState() != Robot.GripperState.OPEN) {
			
			pRobot.openGripper();
		}
	}
}
