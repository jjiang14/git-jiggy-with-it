import junit.framework.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestGhostValidMoves extends TestCase {
	
	/* Testing get_valid_moves when a GHOST has zero adjacent WALLs */
	public void testGhostValidMoves_0Walls() throws FileNotFoundException {
		/* creating test map */
		Map map_0Walls = new Map(3);
		
		/* will be used for setting and adding a ghost to the map */
		Location locGhost = new Location(1, 1);
		Ghost ghost_0Walls = new Ghost("ghost", locGhost, map_0Walls);

		/* will be used for testing against returned list from function call */
		List<Location> locList = new ArrayList<Location>();
		
		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting ghost */
				if (row == 1 && col == 1) {
					map_0Walls.add("ghost", locGhost, new GhostComponent(row, col, 20), Map.Type.GHOST);
					continue;
				} 
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_0Walls.add("empty", loc, new WallComponent(row, col, 20), Map.Type.EMPTY);
				locList.add(loc);
			}
			
		}

		List<Location> returnedList = ghost_0Walls.get_valid_moves();
		Collections.sort(locList);
		Collections.sort(returnedList);

		assertEquals(8, returnedList.size());
		assertTrue(locList.equals(returnedList));
		
		return;
	}
	
	/* Testing get_valid_moves when a GHOST has one EMPTY and seven WALLs adjacent to it */
	public void testGhostValidMoves_7Walls() throws FileNotFoundException {
		/* creating test map */
		Map map_7Walls = new Map(3);
		
		/* will be used for setting and adding a ghost to the map */
		Location locGhost = new Location(1, 1);
		Ghost ghost_7Walls = new Ghost("ghost", locGhost, map_7Walls);
		
		/* will be used for testing against returned list from function call */
		List<Location> locList = new ArrayList<Location>();

		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting ghost */
				if (row == 1 && col == 1) {
					map_7Walls.add("ghost", locGhost, new GhostComponent(row, col, 20), Map.Type.GHOST);
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

		List<Location> returnedList = ghost_7Walls.get_valid_moves();
		Collections.sort(locList);
		Collections.sort(returnedList);
		
		assertEquals(1, returnedList.size());
		assertTrue(locList.equals(returnedList));

		return;
	}
	
	/* Testing get_valid_moves when a GHOST has three GHOSTs, a PACMAN, and three WALLs adjacent to it */
	public void testGhostValidMoves_3ghost1Pacman() throws FileNotFoundException {
		/* creating test map */
		Map map_3ghost1Pacman = new Map(3);
		
		/* will be used for setting and adding a ghost to the map */
		Location locGhost = new Location(1, 1);
		Ghost ghost_3ghost1Pacman = new Ghost("ghost", locGhost, map_3ghost1Pacman);
		
		/* will be used for adding Pacman to the map */
		Location locPacman = new Location(0, 1);
		
		/* will be used for testing against returned list from function call */
		List<Location> locList = new ArrayList<Location>();

		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting pacman */
				if (row == 2 && col == 1) {
					map_3ghost1Pacman.add("pacman", locPacman, new PacManComponent(row, col, 20), Map.Type.PACMAN);
					locList.add(loc);
					continue;
				} else if (row == 0) {
					map_3ghost1Pacman.add("ghost", loc, new GhostComponent(row, col, 20), Map.Type.GHOST);
					continue;
				} else if (row == 1 && col == 1) {
					map_3ghost1Pacman.add("ghost", locGhost, new GhostComponent(row, col, 20), Map.Type.GHOST);
					locList.add(loc);
					continue;
				}
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_3ghost1Pacman.add("empty", loc, new WallComponent(row, col, 20), Map.Type.EMPTY);
				locList.add(loc);
			}
		}

		List<Location> returnedList = ghost_3ghost1Pacman.get_valid_moves();
		Collections.sort(locList);
		Collections.sort(returnedList);
		
		assertEquals(5, returnedList.size());
		assertTrue(locList.equals(returnedList));

		return;
	}
	
	/* Testing get_valid_moves when a GHOST has three GHOSTs and five COOKIEs adjacent to it */
	public void testGhostValidMoves_3ghost5cookie() throws FileNotFoundException {
		/* creating test map */
		Map map_3ghost5cookie = new Map(3);
		
		/* will be used for setting and adding a ghost to the map */
		Location locGhost = new Location(1, 1);
		Ghost ghost_3ghost5cookie = new Ghost("ghost", locGhost, map_3ghost5cookie);
		
		/* will be used for testing against returned list from function call */
		List<Location> locList = new ArrayList<Location>();

		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting ghost */
				if (row == 1 && col == 1) {
					map_3ghost5cookie.add("ghost", locGhost, new GhostComponent(row, col, 20), Map.Type.GHOST);
					continue;
				} else if (row == 0) {
					map_3ghost5cookie.add("ghost", loc, new GhostComponent(row, col, 20), Map.Type.GHOST);
					continue;
				}
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_3ghost5cookie.add("cookie", loc, new CookieComponent(row, col, 20), Map.Type.COOKIE);
				locList.add(loc);
			}
		}

		List<Location> returnedList = ghost_3ghost5cookie.get_valid_moves();
		Collections.sort(locList);
		Collections.sort(returnedList);
		
		assertEquals(5, returnedList.size());
		assertTrue(locList.equals(returnedList));

		return;
	}
	
}
