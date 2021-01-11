import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException {
		Map testMap = new Map(3);
		Location pacmanLoc = new Location(1, 1);
		Location ghostLoc = new Location(1, 2);
		GhostComponent ghostComp = new GhostComponent(1, 2, 20);
		PacManComponent pacmanComp = new PacManComponent(1, 1, 20);
		testMap.add("pacman", pacmanLoc, pacmanComp, Map.Type.PACMAN);
		testMap.add("ghost", ghostLoc, ghostComp, Map.Type.GHOST);

		PacMan pacman = new PacMan("pacman", pacmanLoc, testMap);
		Ghost ghost = new Ghost("ghost", ghostLoc, testMap);

		assertTrue(ghost.attack());

	}

	public void testUnsuccessfulAttack() throws FileNotFoundException {
		Map testMap = new Map(4);
		Location pacmanLoc = new Location(1, 1);
		Location ghostLoc = new Location(1, 3);
		GhostComponent ghostComp = new GhostComponent(1, 2, 20);
		PacManComponent pacmanComp = new PacManComponent(1, 3, 20);
		testMap.add("pacman", pacmanLoc, pacmanComp, Map.Type.PACMAN);
		testMap.add("ghost", ghostLoc, ghostComp, Map.Type.GHOST);

		PacMan pacman = new PacMan("pacman", pacmanLoc, testMap);
		Ghost ghost = new Ghost("ghost", ghostLoc, testMap);

		assertFalse(ghost.attack());

	}
}
