import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

	/* Testing get_valid_moves with zero walls */
	public void testGhostValidMoves_0Walls() throws FileNotFoundException {
		/* Assuming that getLoc in Map class is correctly implemented */
		// TODO: add Map-getLoc() code once available

		/* creating test map */
		Map map_0Walls = new Map(3);
		/* creating location objects */
		Location locAbove = new Location(1, 0);
		map_0Walls.add("empty", locAbove, new WallComponent(1, 0, 20), Map.Type.EMPTY);
		Location locLeft = new Location(0, 1);
		map_0Walls.add("empty", locLeft, new WallComponent(0, 1, 20), Map.Type.EMPTY);
		Location locBelow = new Location(1, 2);
		map_0Walls.add("empty", locBelow, new WallComponent(1, 2, 20), Map.Type.EMPTY);
		Location locRight = new Location(2, 1);
		map_0Walls.add("empty", locRight, new WallComponent(2, 1, 20), Map.Type.EMPTY);
		
		Location locGhost = new Location(1, 1);
		Ghost ghost_0Walls = new Ghost("ghost", locGhost, map_0Walls);
		map_0Walls.add("ghost", locGhost, new GhostComponent(1, 1, Color.orange, 20), Map.Type.GHOST);

		ArrayList<Location> returnedList = ghost_0Walls.get_valid_moves();
		
		assertTrue(returnedList.size() == 4);
		assertTrue(returnedList.contains(locAbove));
		assertTrue(returnedList.contains(locLeft));
		assertTrue(returnedList.contains(locBelow));
		assertTrue(returnedList.contains(locRight));		

		return;
	}
	
	/* Testing get_valid_moves with three walls */
	public void testGhostValidMoves_3Walls() throws FileNotFoundException {
		/* creating test map */
		Map map_3Walls = new Map(3);
		/* creating location objects */
		Location locAbove = new Location(1, 0);
		map_3Walls.add("wall", locAbove, new WallComponent(1, 0, 20), Map.Type.WALL);
		Location locLeft = new Location(0, 1);
		map_3Walls.add("wall", locLeft, new WallComponent(0, 1, 20), Map.Type.WALL);
		Location locBelow = new Location(1, 2);
		map_3Walls.add("wall", locBelow, new WallComponent(1, 2, 20), Map.Type.WALL);
		Location locRight = new Location(2, 1);
		map_3Walls.add("empty", locRight, new WallComponent(2, 1, 20), Map.Type.EMPTY);
		
		Location locGhost = new Location(1, 1);
		Ghost ghost_3Walls = new Ghost("ghost", locGhost, map_3Walls);
		map_3Walls.add("ghost", locGhost, new GhostComponent(1, 1, Color.orange, 20), Map.Type.GHOST);

		ArrayList<Location> returnedList = ghost_3Walls.get_valid_moves();
		
		assertTrue(returnedList.size() == 1);
		assertTrue(returnedList.contains(locRight));		

		return;
	}
	
	/* Testing get_valid_moves with three ghosts and one pacman */
	public void testGhostValidMoves_3ghost() throws FileNotFoundException {
		/* creating test map */
		Map map_3ghost = new Map(3);
		/* creating location objects */
		Location locAbove = new Location(1, 0);
		map_3ghost.add("ghost", locAbove, new WallComponent(1, 0, 20), Map.Type.GHOST);
		Location locLeft = new Location(0, 1);
		map_3ghost.add("ghost", locLeft, new WallComponent(0, 1, 20), Map.Type.GHOST);
		Location locBelow = new Location(1, 2);
		map_3ghost.add("ghost", locBelow, new WallComponent(1, 2, 20), Map.Type.GHOST);
		Location locRight = new Location(2, 1);
		map_3ghost.add("pacman", locRight, new PacManComponent(2, 1, 20), Map.Type.PACMAN);
		
		Location locGhost = new Location(1, 1);
		Ghost ghost_3ghost = new Ghost("ghost", locGhost, map_3ghost);
		map_3ghost.add("ghost", locGhost, new GhostComponent(1, 1, Color.orange, 20), Map.Type.GHOST);

		ArrayList<Location> returnedList = ghost_3ghost.get_valid_moves();
		
		assertTrue(returnedList.size() == 1);
		assertTrue(returnedList.contains(locRight));			

		return;
	}
	
	/* Testing get_valid_moves with two ghosts and one cookie */
	public void testPacManValidMoves_2ghost1cookie() throws FileNotFoundException {
		/* creating test map */
		Map map_2ghost1cookie = new Map(3);
		/* creating location objects */
		Location locAbove = new Location(1, 0);
		map_2ghost1cookie.add("ghost", locAbove, new WallComponent(1, 0, 20), Map.Type.GHOST);
		Location locLeft = new Location(0, 1);
		map_2ghost1cookie.add("ghost", locLeft, new WallComponent(0, 1, 20), Map.Type.GHOST);
		Location locBelow = new Location(1, 2);
		map_2ghost1cookie.add("cookie", locBelow, new WallComponent(1, 2, 20), Map.Type.COOKIE);
		Location locRight = new Location(2, 1);
		map_2ghost1cookie.add("empty", locRight, new WallComponent(2, 1, 20), Map.Type.EMPTY);
		
		Location locGhost = new Location(1, 1);
		Ghost ghost_2ghost1cookie = new Ghost("ghost", locGhost, map_2ghost1cookie);
		map_2ghost1cookie.add("ghost", locGhost, new GhostComponent(1, 1, Color.orange, 20), Map.Type.GHOST);

		ArrayList<Location> returnedList = ghost_2ghost1cookie.get_valid_moves();
		
		assertTrue(returnedList.size() == 2);
		assertTrue(returnedList.contains(locBelow));
		assertTrue(returnedList.contains(locRight));			

		return;
	}
}
