
public class GrabAnObject extends AbstractAction {
	
	/**
	 * Constructor that initializes the GrabAnObject action. Calls the super constructor.
	 * 
	 * @param pChargeBeforeAction
	 * 		true if client wants to fully charge before performing the action, false otherwise.
	 */
	public GrabAnObject(boolean pChargeBeforeAction) {

		super(pChargeBeforeAction);
	}
	
	
	@Override
	/**
	 * If gripper is open, grab an object. Otherwise, change the state of the robot and grab the object 
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

		switch (pRobot.getGripperState()) {
		
			case HOLDING_OBJECT: 
				pRobot.openGripper();
				pRobot.extendArm();
				break;
				// release previous object to grab the new one
				
			case EMPTY:
				pRobot.openGripper();
				pRobot.extendArm();
				break;
				
			case OPEN:
				pRobot.extendArm();
				break;
		}
		pRobot.closeGripper();
		pRobot.retractArm();
	}
}
