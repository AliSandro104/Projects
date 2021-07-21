import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestCompositeAction {

	private static WallE ROBOT = new WallE();
	private static CompositeAction complexAction;
	//Complex Action: Move Backwards by 10 units, grab an object, release it, grab it again, compact it, recharge the robot and empty the compactor.
	
	@BeforeEach
	public void setUp() {
		
		MoveForward move = new MoveForward(false, 5);
		TurnRightOrLeft turn = new TurnRightOrLeft(false, TurnRightOrLeft.Direction.RIGHT);
		GrabAnObject grab = new GrabAnObject(false);
		ReleaseAnObject release = new ReleaseAnObject(false);
		CompactAnObject compact = new CompactAnObject(false);
		EmptyCompactor empty = new EmptyCompactor(true);
		
		ArrayList<AbstractAction> aActions = new ArrayList<AbstractAction>();
		aActions.add(turn);
		aActions.add(turn);
		aActions.add(move);
		aActions.add(move);
		aActions.add(grab);
		aActions.add(release);
		aActions.add(grab);
		aActions.add(compact);
		aActions.add(empty);
		
		complexAction = new CompositeAction(aActions);
	}
	
	@Test
	public void PeformComplexActionInOrderAndRechargeBeforeEmptyingCompactor() {
	
		System.out.println("Testing Complex Action: Move Backwards by 10 units, grab an object, release it, grab it again, compact it, recharge the robot and empty the compactor.");
		
		complexAction.perform(ROBOT);
	}
	
	@Test
	public void TestGetDistanceToTravel() {
		
		assertTrue (complexAction.getDistanceToTravel() == 10);
	}
	
	
	@Test
	public void TestGetNumberOfObjectsToBeCompacted() {
		
		assertTrue (complexAction.getNumberOfObjectsToBeCompacted() == 1);
	}
}
