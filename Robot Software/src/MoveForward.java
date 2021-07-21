

public class MoveForward extends AbstractAction {

	private double aDistance;
	
	/**
	 * Constructor that initializes the MoveForward action. Calls the super constructor.
	 * 
	 * @param pChargeBeforeAction
	 * 		true if client wants to fully charge before performing the action, false otherwise.
	 * 
	 * @param pDistance
	 * 		the distance to travel, in meters.
	 * 
	 * @pre pDistance >= 0
	 */
	public MoveForward(boolean pChargeBeforeAction, double pDistance) {
		
		super(pChargeBeforeAction);
		
		assert pDistance >= 0;
		aDistance = pDistance;
	}
	
	
	@Override
	/**
	 * If the arm is retracted, the robot moves forward. Otherwise, retract the arm first and then move forward
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 * 
	 * @pre (pRobot != null) && (pRobot.getArmState() == Robot.ArmState.RETRACTED)
	 */
	protected void execute(WallE pRobot) {
		
		assert pRobot != null;
		
		if (pRobot.getArmState() != Robot.ArmState.RETRACTED) {
			
			pRobot.retractArm();
		}
		
		if (aDistance > 0) {
			
			pRobot.moveRobot(aDistance);
		}
	}
	
	
	@Override
	/**
	 * Getter method for the total distance to be traveled as a result of this action
	 * 
	 * @return aDistance
	 */
	public double getDistanceToTravel() {
		
		if (aDistance > 0) {
			
			return aDistance;
		}
		return 0;
	}

}
