import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

import Map.Type;

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

	/* Returns an arraylist of Locations that represent valid moves 
	 * that Pacman is able to make given his current location
	 * If there are no valid moves an empty arraylist is returned. 
	 * Valid moves include: 
	 * any Location with Map.Type.COOKIE 
	 * any location with Map.Type.EMPTY */
	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> listValidMoves = new ArrayList<Location>();
		int xCoor = myLoc.x;
		int yCoor = myLoc.y;
		
		/* checking type in field - left side of current location */
		Location locLeft = new Location(xCoor - 1, yCoor);
		HashSet<Map.Type> hashSet = myMap.getLoc(locLeft);
		/* move left on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL) && !hashSet.contains(Map.Type.GHOST)) {
			listValidMoves.add(locLeft);
		}
		
		/* checking type in field - right side of current location */
		Location locRight = new Location(xCoor + 1, yCoor);
		hashSet = myMap.getLoc(locRight);
		/* move right on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL) && !hashSet.contains(Map.Type.GHOST)) {
			listValidMoves.add(locRight);
		}
		
		/* checking type in field - top side of current location */
		Location locAbove  = new Location(xCoor, yCoor - 1);
		hashSet = myMap.getLoc(locAbove);
		/* move up on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL) && !hashSet.contains(Map.Type.GHOST)) {
			listValidMoves.add(locAbove);
		}
		
		/* checking type in field - bottom side of current location */
		Location locBelow = new Location(xCoor, yCoor + 1);
		hashSet = myMap.getLoc(locBelow);
		/* move down on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL) && !hashSet.contains(Map.Type.GHOST)) {
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
