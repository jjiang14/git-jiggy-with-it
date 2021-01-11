import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException {
		/* creates new map */
		NoFrame frame = new NoFrame();
		
		/* creates pacman */
		PacMan pacman = frame.addPacMan(new Location(0, 0));

		/* Creates a ghost named Ruford that will not be adjacent to pacman */
		Ghost farGhost = frame.addGhost(new Location(2, 2), "Ruford", Color.blue);

		/* Ruford is too far from pacman and won't be able to detect him */
		assertFalse(farGhost.is_pacman_in_range());

		/* Creates a ghost named Gerald that will be adjacent to pacman */
		Ghost closeGhost = frame.addGhost(new Location(1, 1), "Gerald", Color.red);
		
		/* Gerald is adjacent to pacman and will detect him */
		assertTrue(pacman.is_ghost_in_range());
	}
}
