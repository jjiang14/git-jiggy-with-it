import java.awt.Color;
import junit.framework.*;
import org.junit.*;

public class TestMapAttack extends TestCase {

	public void testMapAttack() {
		/* creates new map */
		MainFrame frame = new MainFrame();

		/* Creates a ghost named Gerald that will be adjacent to pacman */
		Ghost closeGhost = frame.addGhost(new Location(1, 1), "Gerald", Color.red);

		/* creates pacman */
		PacMan pacman = frame.addPacMan(new Location(0, 0));

		/* checks that Gerald can successfully attack pacman */
		assertTrue(frame.getMap().attack("Gerald"));
		/* checks that a non-existent ghost is unable to attack pacman */
		assertFalse(frame.getMap().attack("Bobby"));
	}
}
