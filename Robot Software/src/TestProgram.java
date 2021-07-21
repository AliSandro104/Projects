import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


public class TestProgram {

	private static WallE ROBOT = new WallE();
	private static Program PROGRAM = new Program();
	
	
	@BeforeAll
	public static void setUp() {
		
		//Initialize 6 basic actions
		MoveForward move = new MoveForward(false, 5);
		TurnRightOrLeft turn = new TurnRightOrLeft(false, TurnRightOrLeft.Direction.RIGHT);
		GrabAnObject grab = new GrabAnObject(false);
		ReleaseAnObject release = new ReleaseAnObject(false);
		CompactAnObject compact = new CompactAnObject(false);
		EmptyCompactor empty = new EmptyCompactor(true);
	
		
		ArrayList<AbstractAction> aActions = new ArrayList<AbstractAction>();
		aActions.add(move);
		aActions.add(turn);
		aActions.add(move);
		aActions.add(move);
		
		// Complex action of moving forward 5 units then turning right and moving forward 10 units
		CompositeAction moveForwardThenRight = new CompositeAction(aActions);
		
		// Add basic and complex actions to the program
		PROGRAM.addAction(moveForwardThenRight);
		PROGRAM.addAction(grab);
		PROGRAM.addAction(release);
		PROGRAM.addAction(moveForwardThenRight);
		PROGRAM.addAction(grab);
		PROGRAM.addAction(compact);
		PROGRAM.addAction(moveForwardThenRight);
		PROGRAM.addAction(grab);
		PROGRAM.addAction(compact);
		PROGRAM.addAction(empty);
	}
	
	
	@Test
	public void TestRemoveAction() {
		
		assertTrue(PROGRAM.getNumberOfObjectsToBeCompacted() == 2);
		AbstractAction removed1 = PROGRAM.removeAction();
		AbstractAction removed2 = PROGRAM.removeAction();
		assertTrue(PROGRAM.getNumberOfObjectsToBeCompacted() == 1);
		
		PROGRAM.addAction(removed2);
		PROGRAM.addAction(removed1);
	}
	
	
	@Test
	public void TestGetDistanceToTravel() {
		
		assertTrue(PROGRAM.getDistanceToTravel() == 45);
	}
	
	
	@Test
	public void TestGetNumberOfObjectsToBeCompacted() {
		
		assertTrue(PROGRAM.getNumberOfObjectsToBeCompacted() == 2);
	}
	
	
	@Test
	public void TestRunProgramContainingBasicAndComplexActions() {
		
		System.out.println("\nTesting runProgram() for a program containing both basic and complex actions");
		PROGRAM.runProgram(ROBOT);
	}
	
}
