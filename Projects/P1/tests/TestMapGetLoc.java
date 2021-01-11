import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;

public class TestMapGetLoc extends TestCase {
	
	public void testMapGetLoc() throws FileNotFoundException{
		
		Map testMap = new Map(3);
		Location pacLoc = new Location(1, 1);
		Location cookieLoc0 = new Location(1, 1);
		Location cookieLoc1 = new Location(0, 1);
		Location cookieLoc2 = new Location(2, 2);
		Location cookieLoc3 = new Location(2, 1);
		Location ghostLoc0 = new Location(0, 0);
		Location ghostLoc1 = new Location(1, 1);
		Location ghostLoc2 = new Location(2, 1);
		Location wallLoc0 = new Location(2, 2);
		Location wallLoc1 = new Location(1, 2);

		emptySet = new HashSet<Map.Type>();
		wallSet = new HashSet<Map.Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);

		testMap.add("pacman", pacLoc, new PacManComponent(pacLoc.x, pacLoc.y, 20), Map.Type.PACMAN);
		testMap.add("cookie0", cookieLoc0, new CookieComponent(cookieLoc0.x, cookieLoc0.y, 20), Map.Type.COOKIE);
		testMap.add("cookie1", cookieLoc1, new CookieComponent(cookieLoc1.x, cookieLoc1.y, 20), Map.Type.COOKIE);
		testMap.add("cookie2", cookieLoc2, new CookieComponent(cookieLoc2.x, cookieLoc2.y, 20), Map.Type.COOKIE);
		testMap.add("cookie3", cookieLoc3, new CookieComponent(cookieLoc3.x, cookieLoc3.y, 20), Map.Type.COOKIE);
		testMap.add("ghost0", ghostLoc0, new GhostComponent(ghostLoc0.x, ghostLoc0.y, 20), Map.Type.GHOST);
		testMap.add("ghost1", ghostLoc1, new GhostComponent(ghostLoc1.x, ghostLoc1.y, 20), Map.Type.GHOST);
		testMap.add("ghost2", ghostLoc2, new GhostComponent(ghostLoc2.x, ghostLoc2.y, 20), Map.Type.GHOST);
		testMap.add("wall0", wallLoc0, new WallComponent(wallLoc0.x, wallLoc0.y, 20), Map.Type.WALL);
		testMap.add("wall1", wallLoc1, new WallComponent(wallLoc1.x, wallLoc1.y, 20), Map.Type.WALL);

		// Test location (0, 0)
		HashSet<Map.Type> expectedReturn = new HashSet<Map.Type>();
		expectedReturn.add(Map.Type.GHOST);

		assertTrue(expectedReturn.equals(testMap.getLoc(new Location((0, 0)))));

		// Test location (0, 1)
		expectedReturn = new HashSet<Map.Type>();
		expectedReturn.add(Map.Type.COOKIE);

		assertTrue(expectedReturn.equals(testMap.getLoc(new Location(0, 1))));

		// Test location (0, 2)
		expectedReturn = emptySet;

		assertTrue(expectedReturn.equals(testMap.getLoc(new Location(0, 2))));

		// Test location (1, 0)
		expectedReturn = emptySet;

		assertTrue(expectedReturn.equals(testMap.getLoc(new Location(1, 0))));

		// Test location (1, 1)
		expectedReturn = new HashSet<Map.Type>();
		expectedReturn.add(Map.Type.GHOST);
		expectedReturn.add(Map.Type.PACMAN);
		expectedReturn.add(Map.Type.COOKIE);

		assertTrue(expectedReturn.equals(testMap.getLoc(new Location(1, 1))));

		// Test location (1, 2)
		expectedReturn = wallSet;

		assertTrue(expectedReturn.equals(testMap.getLoc(new Location(1, 2))));

		// Test location (2, 0)
		expectedReturn = emptySet;

		assertTrue(expectedReturn.equals(testMap.getLoc(new Location(2, 0))));

		// Test location (2, 1)
		expectedReturn = new HashSet<Map.Type>();
		expectedReturn.add(Map.Type.COOKIE);
		expectedReturn.add(Map.Type.GHOST);

		assertTrue(expectedReturn.equals(testMap.getLoc(new Location(2, 1))));

		// Test location (2, 2)
		expectedReturn = wallSet;

		assertTrue(expectedReturn.equals(testMap.getLoc(new Location(2, 2))));
	}
}
