import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {

		// test if pacman and cookie in same location
		Map testMap = new Map(3);
		Location pacmanLoc = new Location(1, 1);
		Location cookieLoc = new Location(1, 1);

		CookieComponent cookie = new CookieComponent(1, 1, 20);
		PacManComponent pacmanComp = new PacManComponent(1, 1, 20);

		testMap.add("pacman", pacmanLoc, pacmanComp, Map.Type.PACMAN);
		testMap.add("tok_x1_y1", cookieLoc, cookie, Map.Type.COOKIE);
		PacMan pacman = new PacMan("pacman", pacmanLoc, testMap);
		CookieComponent result = (CookieComponent) pacman.consume();
		assertTrue(result.equals(cookie));

	}

	public void testNoCookiesConsume() throws FileNotFoundException {

		// test if no cookie in pacman location
		Map testMap = new Map(3);
		Location pacmanLoc = new Location(1, 1);
		PacManComponent pacmanComp = new PacManComponent(1, 1, 20);
		testMap.add("pacman", pacmanLoc, pacmanComp, Map.Type.PACMAN);
		PacMan pacman = new PacMan("pacman", pacmanLoc, testMap);
		assertNull(pacman.consume());
	}
}
