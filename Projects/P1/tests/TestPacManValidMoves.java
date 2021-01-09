import junit.framework.*;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	/*
	 * for (int row = 0; row < 3; row++) { for (int col = 0; col < 4; col++) {
	 * Location loc = new Location(row, col); setting pacman if (row == 1 && col ==
	 * 1 ) { map_3Walls.add("pacman", loc, new PacManComponent(1, 1, 20),
	 * Map.Type.PACMAN);
	 * 
	 * setting cookie space } else if (row == 1 && col == 2) {
	 * map_3Walls.add("cookie", loc, new CookieComponent(row, col, 20),
	 * Map.Type.COOKIE);
	 * 
	 * setting wall } else { map_3Walls.add("wall", loc, new WallComponent(row, col,
	 * 20), Map.Type.WALL); } } }
	 */
	
	/* Testing get_valid_moves with zero walls */
	public void testPacManValidMoves_0Walls() throws FileNotFoundException {
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
		
		Location locPacman = new Location(1, 1);
		PacMan pac_0Walls = new PacMan("pacman", locPacman, map_0Walls);
		map_0Walls.add("pacman", locPacman, new PacManComponent(1, 1, 20), Map.Type.PACMAN);

		ArrayList<Location> returnedList = pac_0Walls.get_valid_moves();
		
		assertTrue(returnedList.size() == 4);
		assertTrue(returnedList.contains(locAbove));
		assertTrue(returnedList.contains(locLeft));
		assertTrue(returnedList.contains(locBelow));
		assertTrue(returnedList.contains(locRight));		

		return;
	}
	
	/* Testing get_valid_moves with three walls */
	public void testPacManValidMoves_3Walls() throws FileNotFoundException {

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
		
		Location locPacman = new Location(1, 1);
		PacMan pac_3Walls = new PacMan("pacman", locPacman, map_3Walls);
		map_3Walls.add("pacman", locPacman, new PacManComponent(1, 1, 20), Map.Type.PACMAN);

		ArrayList<Location> returnedList = pac_3Walls.get_valid_moves();
		
		assertTrue(returnedList.size() == 1);
		assertTrue(returnedList.contains(locRight));		

		return;
	}
	
	/* Testing get_valid_moves with three ghosts */
	public void testPacManValidMoves_3ghost() throws FileNotFoundException {

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
		map_3ghost.add("empty", locRight, new WallComponent(2, 1, 20), Map.Type.EMPTY);
		
		Location locPacman = new Location(1, 1);
		PacMan pac_3ghost = new PacMan("pacman", locPacman, map_3ghost);
		map_3ghost.add("pacman", locPacman, new PacManComponent(1, 1, 20), Map.Type.PACMAN);

		ArrayList<Location> returnedList = pac_3ghost.get_valid_moves();
		
		assertTrue(returnedList.size() == 4);
		assertTrue(returnedList.contains(locAbove));
		assertTrue(returnedList.contains(locLeft));
		assertTrue(returnedList.contains(locBelow));
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
		
		Location locPacman = new Location(1, 1);
		PacMan pac_2ghost1cookie = new PacMan("pacman", locPacman, map_2ghost1cookie);
		map_2ghost1cookie.add("pacman", locPacman, new PacManComponent(1, 1, 20), Map.Type.PACMAN);

		ArrayList<Location> returnedList = pac_2ghost1cookie.get_valid_moves();
		
		assertTrue(returnedList.size() == 4);
		assertTrue(returnedList.contains(locAbove));
		assertTrue(returnedList.contains(locLeft));
		assertTrue(returnedList.contains(locBelow));
		assertTrue(returnedList.contains(locRight));			

		return;
	}

}
