import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCompactAnObject {
	
	private static WallE ROBOT = new WallE();
	
	@Test
	public void CompactAnObjectWithChargingBeforeAnd_GripperStateIsEmpty() {
		
		System.out.println("\nTest: CompactAnObject with Charging before while GripperState is Empty");
		ROBOT.closeGripper();
		
		CompactAnObject compact = new CompactAnObject(true);
		
		assertTrue(compact.getNumberOfObjectsToBeCompacted() == 1);
		assertTrue(compact.getDistanceToTravel() == 0);
		
		compact.perform(ROBOT);
	}
	
	@Test
	public void CompactAnObjectAnd_GripperStateIsOpen() {
		
		System.out.println("\nTest: CompactAnObject while GripperState is Open");
		ROBOT.openGripper();
		
		CompactAnObject compact = new CompactAnObject(false);
		
		assertTrue(compact.getNumberOfObjectsToBeCompacted() == 1);
		assertTrue(compact.getDistanceToTravel() == 0);
		compact.perform(ROBOT);	
	}
	
	@Test
	public void CompactAnObjectAnd_GripperStateIsHoldingAnObject() {
		
		System.out.println("\nTest: CompactAnObject while GripperState is Holding An Object");
		
		GrabAnObject grab = new GrabAnObject(false);
		grab.perform(ROBOT);
		
		CompactAnObject compact = new CompactAnObject(false);
		
		assertTrue(compact.getNumberOfObjectsToBeCompacted() == 1);
		assertTrue(compact.getDistanceToTravel() == 0);
		
		compact.perform(ROBOT);	
	}
}
