import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestEmptyCompactor {

	private static WallE ROBOT = new WallE();
	
	@Test
	public void EmptyCompactorAnd_CompactorIsEmpty() {
		
		System.out.println("\nTest: EmptyCompactor while Compactor is empty");
		
		EmptyCompactor empty = new EmptyCompactor(false);
		
		assertTrue(ROBOT.getCompactorLevel() == 0);
		assertTrue(empty.getDistanceToTravel() == 0);
		assertTrue(empty.getNumberOfObjectsToBeCompacted() == 0);
		
		empty.perform(ROBOT);
	}
	
	@Test
	public void EmptyCompactorWithChargingBeforeAnd_CompactorIsNotEmpty() {
		
		System.out.println("\nTest: EmptyCompactor with Charging before while Compactor is not Empty");
		
		GrabAnObject grab = new GrabAnObject(false);
		grab.perform(ROBOT);
		
		CompactAnObject compact = new CompactAnObject(false);
		compact.perform(ROBOT);	
		
		assertTrue(ROBOT.getCompactorLevel() == 1);
		EmptyCompactor empty = new EmptyCompactor(true);
		
		assertTrue(empty.getDistanceToTravel() == 0);
		assertTrue(empty.getNumberOfObjectsToBeCompacted() == 0);
		
		empty.perform(ROBOT);
		assertTrue(ROBOT.getCompactorLevel() == 0);
	}
}
