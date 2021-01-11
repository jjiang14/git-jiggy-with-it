import junit.framework.*;
import java.awt.Color;
import java.io.*;

/* assumes PacMan.get_valid_moves() works properly */

public class TestPacManMove extends TestCase {

	/* Testing Pacman.move() when Pacman has zero adjacent WALLs */
	public void testPacManMove_0Walls() throws FileNotFoundException {
		/* creating test map */
		Map map_0Walls = new Map(3);
		
		/* will be used for setting and adding Pacman to the map */
		Location locPacman = new Location(1, 1);
		PacMan pac_0Walls = new PacMan("pacman", locPacman, map_0Walls);
		
		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting pacman */
				if (row == 1 && col == 1) {
					map_0Walls.add("pacman", locPacman, new PacManComponent(row, col, 20), Map.Type.PACMAN);
					continue;
				} 
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_0Walls.add("empty", loc, new WallComponent(row, col, 20), Map.Type.EMPTY);
				
			}
			
		}

		ArrayList<Location> returnedList = pac_0Walls.get_valid_moves();

		pac_0Walls.move();
		assertTrue(pac_0Walls.myLoc.equals(returnedList.get(0)));
		assertTrue(map_0Walls.getLoc(returnedList.get(0).contains(Map.Type.PACMAN)));
		
		return;
	}
	
	/* Testing Pacman.move() when Pacman has one EMPTY and seven WALLs adjacent to it */
	public void testPacManMove_7Walls() throws FileNotFoundException {
		/* creating test map */
		Map map_7Walls = new Map(3);
		
		/* will be used for setting and adding Pacman to the map */
		Location locPacman = new Location(1, 1);
		PacMan pac_7Walls = new PacMan("pacman", locPacman, map_7Walls);
	

		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting pacman */
				if (row == 1 && col == 1) {
					map_7Walls.add("pacman", locPacman, new PacManComponent(row, col, 20), Map.Type.PACMAN);
					continue;
				} else if (row == 1 && col == 2) {
					map_7Walls.add("empty", loc, new WallComponent(row, col, 20), Map.Type.EMPTY);
					
					continue;
				}
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_7Walls.add("wall", loc, new WallComponent(row, col, 20), Map.Type.WALL);
			}
		}

		ArrayList<Location> returnedList = pac_7Walls.get_valid_moves();

		pac_7Walls.move();
		assertTrue(pac_7Walls.myLoc.equals(returnedList.get(0)));
		assertTrue(map_7Walls.getLoc(returnedList.get(0).contains(Map.Type.PACMAN)));

		return;
	}
	
	/* Testing Pacman.move() when Pacman has four GHOSTs adjacent to it */
	public void testPacManMove_4ghost() throws FileNotFoundException {
		/* creating test map */
		Map map_4ghost = new Map(3);
		
		/* will be used for setting and adding Pacman to the map */
		Location locPacman = new Location(1, 1);
		PacMan pac_4ghost = new PacMan("pacman", locPacman, map_4ghost);
	

		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting pacman */
				if (row == 1 && col == 1) {
					map_4ghost.add("pacman", locPacman, new PacManComponent(row, col, 20), Map.Type.PACMAN);
					continue;
				} else if (row == 0 || (row == 2 && col == 1)) {
					map_4ghost.add("ghost", loc, new WallComponent(row, col, 20), Map.Type.GHOST);
					continue;
				} else if (row == 2 && col == 0) {
					map_4ghost.add("empty", loc, new WallComponent(row, col, 20), Map.Type.EMPTY);
					
					continue;
				}
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_4ghost.add("wall", loc, new WallComponent(row, col, 20), Map.Type.WALL);
			}
		}

		ArrayList<Location> returnedList = pac_4ghost.get_valid_moves();

		pac_4ghost.move();
		assertTrue(pac_4ghost.myLoc.equals(returnedList.get(0)));
		assertTrue(map_4ghost.getLoc(returnedList.get(0).contains(Map.Type.PACMAN)));

		return;
	}
	
	/* Testing Pacman.move() when Pacman has four GHOSTs, one COOKIE, and three EMPTYs adjacent to it */
	public void testPacManMove_4ghost1cookie() throws FileNotFoundException {
		/* creating test map */
		Map map_4ghost1cookie = new Map(3);
		
		/* will be used for setting and adding Pacman to the map */
		Location locPacman = new Location(1, 1);
		PacMan pac_4ghost1cookie = new PacMan("pacman", locPacman, map_4ghost1cookie);
	

		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting pacman */
				if (row == 1 && col == 1) {
					map_4ghost1cookie.add("pacman", locPacman, new PacManComponent(row, col, 20), Map.Type.PACMAN);
					continue;
				} else if (row == 0 || (row == 2 && col == 1)) {
					map_4ghost1cookie.add("ghost", loc, new WallComponent(row, col, 20), Map.Type.GHOST);
					continue;
				} else if (row == 2 && col == 0) {
					map_4ghost1cookie.add("cookie", loc, new WallComponent(row, col, 20), Map.Type.COOKIE);
					
					continue;
				}
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_4ghost1cookie.add("empty", loc, new WallComponent(row, col, 20), Map.Type.EMPTY);
				
			}
		}

		ArrayList<Location> returnedList = pac_4ghost1cookie.get_valid_moves();

		pac_4ghost1cookie.move();
		assertTrue(pac_4ghost1cookie.myLoc.equals(returnedList.get(0)));
		assertTrue(map_4ghost1cookie.getLoc(returnedList.get(0).contains(Map.Type.PACMAN)));

		return;
	}

}
