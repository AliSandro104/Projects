
public class EmptyCompactor extends AbstractAction {
	
	/**
	 * Constructor that initializes the EmptyCompactor action. Calls the super constructor.
	 * 
	 * @param pChargeBeforeAction
	 * 		true if client wants to fully charge before performing the action, false otherwise.
	 * 
	 */
	public EmptyCompactor(boolean pChargeBeforeAction) {
	
		super(pChargeBeforeAction);
	}
	
	
	@Override
	/**
	 * Empties the compactor if it is not empty.
	 * 
	 * @param pRobot
	 * 		WallE instance that will perform the action
	 *
	 * @pre (pRobot != null) && (pRobot.getCompactorLevel() != 0)
	 */
	protected void execute(WallE pRobot) {
		
		assert pRobot != null;
		
		if (pRobot.getCompactorLevel() > 0) {
		
			pRobot.emptyCompactor();
		}
	}
}
