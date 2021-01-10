import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestMapMove extends TestCase {

	/* Testing move with zero walls */
	public void testMapMove_0Walls() throws FileNotFoundException {
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
		
		assertTrue(map_0Walls.move("pacman", locRight, Map.Type.PACMAN));
		assertTrue(map_0Walls.move("pacman", locLeft, Map.Type.PACMAN));
		assertTrue(map_0Walls.move("pacman", locAbove, Map.Type.PACMAN));
		
		/* the below is testing valid Location provided */
		/*
		 * Location invalid = new Location(locAbove.x, locAbove.y - 1);
		 * assertFalse(map_0Walls.move("pacman", invalid, Map.Type.PACMAN));
		 */
		
		assertTrue(map_0Walls.move("pacman", locBelow, Map.Type.PACMAN));	

		return;
	}
	
	/* Testing move with three walls */
	public void testMapMove_3Walls() throws FileNotFoundException {
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

		/* moving right */
		assertTrue(map_3Walls.move("pacman", locRight, Map.Type.PACMAN));
		/* moving left */
		assertTrue(map_3Walls.move("pacman", new Location(locRight.x - 1, locRight.y), Map.Type.PACMAN));
		
		/* the below tests are testing valid Location provided */
		/*
		 * assertFalse(map_3Walls.move("pacman", locAbove, Map.Type.PACMAN));
		 * assertFalse(map_3Walls.move("pacman", locBelow, Map.Type.PACMAN));
		 * assertFalse(map_3Walls.move("pacman", locLeft, Map.Type.PACMAN));
		 */
		return;
	}
	
	/* Testing move with three ghosts */
	public void testMapMove_3ghost() throws FileNotFoundException {
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

		/* moving right */
		assertTrue(map_3ghost.move("pacman", locRight, Map.Type.PACMAN));
		/* moving left */
		assertTrue(map_3ghost.move("pacman", new Location(locRight.x - 1, locRight.y), Map.Type.PACMAN));

		return;
	}
	
	/* Testing move with two ghosts and one cookie */
	public void testMapMove_2ghost1cookie() throws FileNotFoundException {
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

		/* moving to space below with cookie */
		assertTrue(map_2ghost1cookie.move("pacman", locBelow, Map.Type.PACMAN));
		/* moving to space above (aka original location) */
		assertTrue(map_2ghost1cookie.move("pacman", locPacman, Map.Type.PACMAN));
		
		/* moving right */
		assertTrue(map_2ghost1cookie.move("pacman", locRight, Map.Type.PACMAN));
		/* moving left */
		assertTrue(map_2ghost1cookie.move("pacman", new Location(locRight.x - 1, locRight.y), Map.Type.PACMAN));	

		return;
	}
}
