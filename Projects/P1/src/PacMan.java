import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;	
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		/* iterates through surrounding grid spaces */
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				/* checks if Type GHOST is present at that grid space */
				if (myMap.getLoc(new Location(myLoc.x + i, myLoc.y + j)).contains(Map.Type.GHOST)) {
					return true;
				}
			}
		}
		/* if no Type GHOST is found then return false */
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
