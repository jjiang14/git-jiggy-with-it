import junit.framework.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestPacManValidMoves extends TestCase {
	
	/* Testing get_valid_moves when Pacman has zero adjacent WALLs */
	public void testPacManValidMoves_0Walls() throws FileNotFoundException {
		/* creating test map */
		Map map_0Walls = new Map(3);
		
		/* will be used for setting and adding Pacman to the map */
		Location locPacman = new Location(1, 1);
		PacMan pac_0Walls = new PacMan("pacman", locPacman, map_0Walls);

		/* will be used for testing against returned list from function call */
		List<Location> locList = new ArrayList<Location>();
		
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
				locList.add(loc);
			}
			
		}

		List<Location> returnedList = pac_0Walls.get_valid_moves();
		Collections.sort(locList);
		Collections.sort(returnedList);
		
		/* printing out sorted locList */
		for (Location loc:locList) {
			System.out.println(loc);
		}
		System.out.println("Printing returnedList");
		/* printing out sorted returnedList */
		for (Location loc:returnedList) {
			System.out.println(loc);
		}
		System.out.println();
		
		assertEquals(8, returnedList.size());
		assertTrue(locList.equals(returnedList));
		
		return;
	}
	
	/* Testing get_valid_moves when Pacman has one EMPTY and seven WALLs adjacent to it */
	public void testPacManValidMoves_7Walls() throws FileNotFoundException {
		/* creating test map */
		Map map_7Walls = new Map(3);
		
		/* will be used for setting and adding Pacman to the map */
		Location locPacman = new Location(1, 1);
		PacMan pac_7Walls = new PacMan("pacman", locPacman, map_7Walls);
		
		/* will be used for testing against returned list from function call */
		List<Location> locList = new ArrayList<Location>();

		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting pacman */
				if (row == 1 && col == 1) {
					map_7Walls.add("pacman", locPacman, new PacManComponent(row, col, 20), Map.Type.PACMAN);
					continue;
				} else if (row == 1 && col == 2) {
					map_7Walls.add("empty", loc, new WallComponent(row, col, 20), Map.Type.EMPTY);
					locList.add(loc);
					continue;
				}
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_7Walls.add("wall", loc, new WallComponent(row, col, 20), Map.Type.WALL);
			}
		}

		List<Location> returnedList = pac_7Walls.get_valid_moves();
		Collections.sort(locList);
		Collections.sort(returnedList);
		
		assertTrue(returnedList.size() == 1);
		assertTrue(locList.equals(returnedList));

		return;
	}
	
	/* Testing get_valid_moves when Pacman has four GHOSTs adjacent to it */
	public void testPacManValidMoves_4ghost() throws FileNotFoundException {
		/* creating test map */
		Map map_4ghost = new Map(3);
		
		/* will be used for setting and adding Pacman to the map */
		Location locPacman = new Location(1, 1);
		PacMan pac_4ghost = new PacMan("pacman", locPacman, map_4ghost);
		
		/* will be used for testing against returned list from function call */
		List<Location> locList = new ArrayList<Location>();

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
					locList.add(loc);
					continue;
				}
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_4ghost.add("wall", loc, new WallComponent(row, col, 20), Map.Type.WALL);
			}
		}

		List<Location> returnedList = pac_4ghost.get_valid_moves();
		Collections.sort(locList);
		Collections.sort(returnedList);
		
		assertTrue(returnedList.size() == 1);
		assertTrue(locList.equals(returnedList));

		return;
	}
	
	/* Testing get_valid_moves when Pacman has four GHOSTs, one COOKIE, and three EMPTYs adjacent to it */
	public void testPacManValidMoves_4ghost1cookie() throws FileNotFoundException {
		/* creating test map */
		Map map_4ghost1cookie = new Map(3);
		
		/* will be used for setting and adding Pacman to the map */
		Location locPacman = new Location(1, 1);
		PacMan pac_4ghost1cookie = new PacMan("pacman", locPacman, map_4ghost1cookie);
		
		/* will be used for testing against returned list from function call */
		List<Location> locList = new ArrayList<Location>();

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
					locList.add(loc);
					continue;
				}
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_4ghost1cookie.add("empty", loc, new WallComponent(row, col, 20), Map.Type.EMPTY);
				locList.add(loc);
			}
		}

		List<Location> returnedList = pac_4ghost1cookie.get_valid_moves();
		Collections.sort(locList);
		Collections.sort(returnedList);
		
		assertTrue(returnedList.size() == 4);
		assertTrue(locList.equals(returnedList));

		return;
	}

}
