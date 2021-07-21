import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestGrabAnObject {

private static WallE ROBOT = new WallE();
	
	@Test
	public void GrabAnObjectWithChargingBeforeAnd_GripperStateIsEmpty() {
		
		System.out.println("\nTest: GrabAnObject with Charging before while GripperState is Empty");
		
		GrabAnObject grab = new GrabAnObject(true);
		
		assertTrue(grab.getNumberOfObjectsToBeCompacted() == 0);
		assertTrue(grab.getDistanceToTravel() == 0);
		
		grab.perform(ROBOT);
	}
	
	@Test
	public void GrabAnObjectAnd_GripperStateIsOpen() {
		
		System.out.println("\nTest: GrabAnObject while GripperState is Open");
		ROBOT.openGripper();
		
		GrabAnObject grab = new GrabAnObject(false);
		
		assertTrue(grab.getNumberOfObjectsToBeCompacted() == 0);
		assertTrue(grab.getDistanceToTravel() == 0);
		
		grab.perform(ROBOT);
	}
	
	@Test
	public void GrabAnObjectAnd_GripperStateIsHoldingAnObject() {
		
		System.out.println("\nTest: GrabAnObject while GripperState is already Holding An Object");
		// robot is supposed to remove the object it holds before grabbing the new one
		
		GrabAnObject grab = new GrabAnObject(false);
		
		assertTrue(grab.getNumberOfObjectsToBeCompacted() == 0);
		assertTrue(grab.getDistanceToTravel() == 0);
		
		grab.perform(ROBOT);
		grab.perform(ROBOT);
	}
}
