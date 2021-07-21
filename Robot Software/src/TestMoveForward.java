import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestMoveForward {

private static WallE ROBOT = new WallE();
	
	@Test
	public void MoveForwardWithChargingBeforeAnd_ArmIsRetracted() {
		
		System.out.println("\nTest: MoveForward with Charging before, while Arm is Retracted");
		
		MoveForward move = new MoveForward(true, 12.3);
		
		assertTrue(move.getDistanceToTravel() == 12.3);
		assertTrue(move.getNumberOfObjectsToBeCompacted() == 0);
		
		move.perform(ROBOT);
	}
	
	@Test
	public void MoveForwardAnd_ArmIsExtended() {
		
		System.out.println("\nTest: MoveForward, while Arm is Extended");
		ROBOT.extendArm();
		
		MoveForward move = new MoveForward(false, 7.1);
		
		assertTrue(move.getDistanceToTravel() == 7.1);
		assertTrue(move.getNumberOfObjectsToBeCompacted() == 0);
		
		move.perform(ROBOT);
	}
	
	@Test
	public void MoveForwardAnd_DistanceIsLessThanOrEqualToZero() {
		
		System.out.println("\nTest: MoveForward, while Distance is <= 0");
		
		MoveForward move = new MoveForward(false, 0);
		
		assertTrue(move.getDistanceToTravel() == 0);
		assertTrue(move.getNumberOfObjectsToBeCompacted() == 0);
		
		move.perform(ROBOT);
	}
}
