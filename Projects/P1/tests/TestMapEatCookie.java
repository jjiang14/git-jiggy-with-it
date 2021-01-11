import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.*;

public class TestMapEatCookie extends TestCase {

	public void testMapEatCookie() throws FileNotFoundException {

		Map testMap = new Map(3);
		Location pacmanLoc = new Location(1, 1);
		Location cookieLoc = new Location(1, 1);

		CookieComponent cookie = new CookieComponent(1, 1, 20);
		PacManComponent pacmanComp = new PacManComponent(1, 1, 20);

		testMap.add("pacman", pacmanLoc, pacmanComp, Map.Type.PACMAN);
		testMap.add("tok_x1_y1", cookieLoc, cookie, Map.Type.COOKIE);

		assertTrue(testMap.eatCookie("pacman").equals(cookie));
	}

	// test when there is no cookie
	public void testNoCookie() {
		Map testMap = new Map(3);
		Location pacmanLoc = new Location(1, 1);
		PacManComponent pacmanComp = new PacManComponent(1, 1, 20);
		testMap.add("pacman", pacmanLoc, pacmanComp, Map.Type.PACMAN);
		assertNull(testMap.eatCookie("pacman"));
	}
}
