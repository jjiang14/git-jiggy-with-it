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
		ArrayList<Location> listValidMoves = new ArrayList<Location>();
		int xCoor = myLoc.x;
		int yCoor = myLoc.y;
		
		/* checking type in field - left side of current location */
		Location locLeft = new Location(xCoor - 1, yCoor);
		/* move left on map possible */
		if (!myMap.getLoc(locLeft).contains(Map.Type.WALL)) {
			listValidMoves.add(locLeft);
		}
		
		/* checking type in field - right side of current location */
		Location locRight = new Location(xCoor + 1, yCoor);
		/* move right on map possible */
		if (!myMap.getLoc(locRight).contains(Map.Type.WALL)) {
			listValidMoves.add(locRight);
		}
		
		/* checking type in field - top side of current location */
		Location locAbove  = new Location(xCoor, yCoor - 1);
		/* move up on map possible */
		if (!myMap.getLoc(locAbove).contains(Map.Type.WALL)) {
			listValidMoves.add(locAbove);
		}
		
		/* checking type in field - bottom side of current location */
		Location locBelow = new Location(xCoor, yCoor + 1);
		/* move sown on map possible */
		if (!myMap.getLoc(locBelow).contains(Map.Type.WALL)) {
			listValidMoves.add(locBelow);
		}
		
		return listValidMoves;	
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
