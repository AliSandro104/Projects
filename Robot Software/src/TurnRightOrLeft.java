
public class TurnRightOrLeft extends AbstractAction {

	private Direction aDirection;
	
	/**
	 * Constructor that initializes the TurnRightOrLeft action. Calls the super constructor.

	 * @param pChargeBeforeAction
	 * 		true if client wants to fully charge before performing the action, false otherwise.
	 * 
	 * @param pDirection
	 * 		the direction to turn the robot: RIGHT or LEFT
	 * 
	 * @pre pDirection != null
	 */
	public TurnRightOrLeft(boolean pChargeBeforeAction, Direction pDirection) {
		
		super(pChargeBeforeAction);
		
		assert pDirection != null;
		aDirection = pDirection;
	}
	
	
	@Override
	/**
	 * The robot turns to the given direction if the preconditions are not violated
	 * If aDirection == Direction.RIGHT, turn 90 degrees.
	 * If aDirection == Direction.LEFT, turn -90 degrees.
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
			
		if (aDirection == Direction.RIGHT) {
				
			pRobot.turnRobot(90);
			
		} else {
				
			pRobot.turnRobot(-90);
		}
	}
	
	
	public static enum Direction {
		RIGHT,
		LEFT,
	}
}
