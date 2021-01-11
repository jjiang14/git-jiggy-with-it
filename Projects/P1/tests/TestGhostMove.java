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
		Location ghost0Loc = new Location(1, 1);
		Location ghost1Loc = new Location(1, 0);
		Location ghost2Loc = new Location(2, 1);
		Location pacLoc = new Location(1, 1);
		Ghost ghost0 = new Ghost("ghost0", ghost0Loc, map_3ghost1Pacman);
		Ghost ghost1 = new Ghost("ghost1", ghost1Loc, map_3ghost1Pacman);
		Ghost ghost2 = new Ghost("ghost2", ghost2Loc, map_3ghost1Pacman);
		PacMan pacman = new PacMan("pacman", pacLoc, map_3ghost1Pacman);
		
		/* will be used for adding Pacman to the map */
		Location locPacman = new Location(0, 1);

		map_3ghost1Pacman.add("pacman", locPacman, new PacManComponent(locPacman.x, locPacman.y, 20), Map.Type.PACMAN);
		map_3ghost1Pacman.add("ghost0", ghost0Loc, new GhostComponent(ghost0Loc.x, ghost0Loc.y, 20), Map.Type.GHOST);
		map_3ghost1Pacman.add("ghost1", ghost1Loc, new GhostComponent(ghost1Loc.x, ghost1Loc.y, 20), Map.Type.GHOST);
		map_3ghost1Pacman.add("ghost2", ghost2Loc, new GhostComponent(ghost2Loc.x, ghost2Loc.y, 20), Map.Type.GHOST);
		/* using WallComponent because get_valid_moves is setup to check the 
		* Map.Type at all surrounding locations of an object */
		map_3ghost1Pacman.add("wall", new Location(0, 0), new WallComponent(0, 0, 20), Map.Type.WALL);

		Location expectedLoc0 = ghost0.get_valid_moves().get(0);
		ghost0.move();
		Location expectedLoc1 = ghost1.get_valid_moves().get(0);
		ghost1.move();
		Location expectedLoc2 = ghost2.get_valid_moves().get(0);
		ghost2.move();
		//System.out.println("\nExpected location 0: " + expectedLoc0 + "\n" + ghost0.myLoc + "\n" + map_3ghost1Pacman.getLoc(expectedLoc0) + "\n");
		assertTrue(ghost0.myLoc.equals(expectedLoc0));
		assertTrue(map_3ghost1Pacman.getLoc(expectedLoc0).contains(Map.Type.GHOST));
		//System.out.println("\nExpected location 1: " + expectedLoc1 + "\n" + ghost1.myLoc + "\n" + map_3ghost1Pacman.getLoc(expectedLoc1) + "\n");
		assertTrue(ghost1.myLoc.equals(expectedLoc1));
		//assertTrue(map_3ghost1Pacman.getLoc(expectedLoc1).contains(Map.Type.GHOST));
		//System.out.println("\nExpected location 2: " + expectedLoc2 + "\n" + ghost2.myLoc + "\n" + map_3ghost1Pacman.getLoc(expectedLoc2) + "\n");
		assertTrue(ghost2.myLoc.equals(expectedLoc2));
		assertTrue(map_3ghost1Pacman.getLoc(expectedLoc2).contains(Map.Type.GHOST));

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
