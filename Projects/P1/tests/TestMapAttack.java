import java.awt.Color;
import junit.framework.*;
import org.junit.*;

public class TestMapAttack {

	public void testMapAttack() {
		/* creates new map */
		MainFrame frame = new MainFrame();

		/* Creates a ghost named Gerald that will be adjacent to pacman */
		Ghost closeGhost = frame.addGhost(new Location(1, 1), "Gerald", Color.red);
		/* Creates a ghost named Ruford that will not be adjacent to pacman */
		Ghost farGhost = frame.addGhost(new Location(2, 2), "Ruford", Color.blue);

		/* creates pacman */
		PacMan pacman = frame.addPacMan(new Location(0, 0));

		/* checks that Gerald can successfully attack pacman */
		assertTrue(frame.getMap().attack("Gerald"));
		/* checks that Ruford is too far away and cannot attack pacman */
		assertFalse(frame.getMap().attack("Ruford"));
		/* checks that a non-existent ghost is unable to attack pacman */
		assertFalse(frame.getMap().attack("Bobby"));
	}
}
