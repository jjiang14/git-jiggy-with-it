import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

/* assumes Ghost.get_valid_moves() works properly */

public class TestGhostMove extends TestCase {

	/* Testing Ghost.move() when a GHOST has zero adjacent WALLs */
	public void testGhostMove_0Walls() throws FileNotFoundException {
		/* Assuming that getLoc in Map class is correctly implemented */
		// TODO: add Map-getLoc() code once available or test more rigorously

		/* creating test map */
		Map map_0Walls = new Map(3);
		
		/* will be used for setting and adding a ghost to the map */
		Location locGhost = new Location(1, 1);
		Ghost ghost_0Walls = new Ghost("ghost", locGhost, map_0Walls);
		
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
				
			}
			
		}

		ArrayList<Location> returnedList = ghost_0Walls.get_valid_moves();

		ghost_0Walls.move();
		assertTrue(ghost_0Walls.myLoc.equals(returnedList.get(0)));
		assertTrue(map_0Walls.getLoc(returnedList.get(0)).contains(Map.Type.GHOST));
		
		return;
	}
	
	/* Testing Ghost.move() when a GHOST has one EMPTY and seven WALLs adjacent to it */
	public void testGhostMove_7Walls() throws FileNotFoundException {
		/* creating test map */
		Map map_7Walls = new Map(3);
		
		/* will be used for setting and adding a ghost to the map */
		Location locGhost = new Location(1, 1);
		Ghost ghost_7Walls = new Ghost("ghost", locGhost, map_7Walls);
		

		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting ghost */
				if (row == 1 && col == 1) {
					map_7Walls.add("ghost", locGhost, new GhostComponent(row, col, 20), Map.Type.GHOST);
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

		ArrayList<Location> returnedList = ghost_7Walls.get_valid_moves();
		
		ghost_7Walls.move();
		assertTrue(ghost_7Walls.myLoc.equals(returnedList.get(0)));
		assertTrue(map_7Walls.getLoc(returnedList.get(0)).contains(Map.Type.GHOST));

		return;
	}
	
	/* Testing Ghost.move() when a GHOST has three GHOSTs, a PACMAN, and three WALLs adjacent to it */
	public void testGhostMove_3ghost1Pacman() throws FileNotFoundException {
		/* creating test map */
		Map map_3ghost1Pacman = new Map(3);
		
		/* will be used for setting and adding a ghost to the map */
		Location locGhost = new Location(1, 1);
		Ghost ghost_3ghost1Pacman = new Ghost("ghost", locGhost, map_3ghost1Pacman);
		
		/* will be used for adding Pacman to the map */
		Location locPacman = new Location(0, 1);

		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				Location loc = new Location(row, col);
				
				/* setting GHOST */
				if (row == 2 && col == 1) {
					map_3ghost1Pacman.add("pacman", locPacman, new PacManComponent(row, col, 20), Map.Type.PACMAN);
					continue;
				} else if (row == 0) {
					map_3ghost1Pacman.add("ghost", loc, new GhostComponent(row, col, 20), Map.Type.GHOST);
					continue;
				} else if (row == 1 && col == 1) {
					map_3ghost1Pacman.add("ghost", locGhost, new GhostComponent(row, col, 20), Map.Type.GHOST);
					continue;
				}
				/* using WallComponent because get_valid_moves is setup to check the 
				 * Map.Type at all surrounding locations of an object */
				map_3ghost1Pacman.add("empty", loc, new WallComponent(row, col, 20), Map.Type.EMPTY);
			}
		}

		ArrayList<Location> returnedList = ghost_3ghost1Pacman.get_valid_moves();
		
		ghost_3ghost1Pacman.move();
		assertTrue(ghost_3ghost1Pacman.myLoc.equals(returnedList.get(0)));
		assertTrue(map_3ghost1Pacman.getLoc(returnedList.get(0)).contains(Map.Type.GHOST));

		return;
	}
	
	/* Testing Ghost.move() when a GHOST has three GHOSTs and five COOKIEs adjacent to it */
	public void testGhostMove_3ghost5cookie() throws FileNotFoundException {
		/* creating test map */
		Map map_3ghost5cookie = new Map(3);
		
		/* will be used for setting and adding a ghost to the map */
		Location locGhost = new Location(1, 1);
		Ghost ghost_3ghost5cookie = new Ghost("ghost", locGhost, map_3ghost5cookie);

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
			}
		}

		ArrayList<Location> returnedList = ghost_3ghost5cookie.get_valid_moves();
		
		ghost_3ghost5cookie.move();
		assertTrue(ghost_3ghost5cookie.myLoc.equals(returnedList.get(0)));
		assertTrue(map_3ghost5cookie.getLoc(returnedList.get(0)).contains(Map.Type.GHOST));;

		return;
	}
}