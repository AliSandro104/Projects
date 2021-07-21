
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestReleaseAnObject {

	private static WallE ROBOT = new WallE();
		
		@Test
		public void ReleaseAnObjectWithChargingBeforeAnd_GripperStateIsEmpty() {
			
			System.out.println("\nTest: Release An Object with Charging before, while GripperState is Empty");
			
			ReleaseAnObject release = new ReleaseAnObject(true);
			
			assertTrue(release.getDistanceToTravel() == 0);
			assertTrue(release.getNumberOfObjectsToBeCompacted() == 0);
			
			release.perform(ROBOT);
		}
		
		@Test
		public void ReleaseAnObjectAnd_GripperStateIsOpen() {
			
			System.out.println("\nTest: Release An Object while GripperState is Open");
			ROBOT.openGripper();
			
			ReleaseAnObject release = new ReleaseAnObject(false);
			
			assertTrue(release.getDistanceToTravel() == 0);
			assertTrue(release.getNumberOfObjectsToBeCompacted() == 0);
			
			release.perform(ROBOT);
		}
		
		@Test
		public void ReleaseAnObjectAnd_GripperStateIsHoldingAnObject() {
			
			System.out.println("\nTest: Release An Object while GripperState is already Holding An Object");
			
			GrabAnObject grab = new GrabAnObject(false);
			grab.perform(ROBOT);
			
			ReleaseAnObject release = new ReleaseAnObject(false);
			
			assertTrue(release.getDistanceToTravel() == 0);
			assertTrue(release.getNumberOfObjectsToBeCompacted() == 0);
			
			release.perform(ROBOT);
		}
}
