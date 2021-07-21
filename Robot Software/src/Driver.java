import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
		WallE ROBOT = new WallE();
		Program PROGRAM = new Program();
		
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
		
		System.out.println("\n**********Testing a program containing both basic and complex actions.**********\n");
		
		System.out.println("Distance to travel: " + PROGRAM.getDistanceToTravel());
		System.out.println("Number of objects to compact: " + PROGRAM.getNumberOfObjectsToBeCompacted());
		
		System.out.println("\n\nProgram is running now!\n");
		PROGRAM.runProgram(ROBOT);

	}

}
