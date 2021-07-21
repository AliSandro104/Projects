import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestTurnRightOrLeft {
	
	private static WallE ROBOT = new WallE();
		
		@Test
		public void TurnRightWithChargingBeforeAnd_ArmIsRetracted() {
			
			System.out.println("\nTest: Turn Right with Charging before, while Arm is Retracted");
			
			TurnRightOrLeft turn = new TurnRightOrLeft(true, TurnRightOrLeft.Direction.RIGHT);
			
			assertTrue(turn.getDistanceToTravel() == 0);
			assertTrue(turn.getNumberOfObjectsToBeCompacted() == 0);
			
			turn.perform(ROBOT);
		}
		
		@Test
		public void TurnLeftAnd_ArmIsExtended() {
			
			System.out.println("\nTest: Turn Left, while Arm is Extended");
			ROBOT.extendArm();
			
			TurnRightOrLeft turn = new TurnRightOrLeft(false, TurnRightOrLeft.Direction.LEFT);
			
			assertTrue(turn.getDistanceToTravel() == 0);
			assertTrue(turn.getNumberOfObjectsToBeCompacted() == 0);
			
			turn.perform(ROBOT);
		}
}
