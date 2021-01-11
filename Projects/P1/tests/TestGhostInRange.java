import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException {
		/* creates new map */
		MainFrame frame = new MainFrame();

		/* creates pacman */
		PacMan pacman = frame.addPacMan(new Location(0, 0));

		/* with no ghosts present on the map, pacman shouldn't detect any ghosts */
		assertFalse(pacman.is_ghost_in_range());

		/* Creates a ghost named Ruford that will not be adjacent to pacman */
		Ghost farGhost = frame.addGhost(new Location(2, 2), "Ruford", Color.blue);

		/* a ghost is on the map but too far away for pacman to detect */
		assertFalse(pacman.is_ghost_in_range());

		/* Creates a ghost named Gerald that will be adjacent to pacman */
		Ghost closeGhost = frame.addGhost(new Location(1, 1), "Gerald", Color.red);

		/* a ghost is on the map and adjacent to pacman, it should be detected */
		assertTrue(pacman.is_ghost_in_range());
	}
}
