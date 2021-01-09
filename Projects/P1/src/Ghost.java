import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
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
		HashSet<Map.Type> hashSet = myMap.getLoc(locLeft);
		/* move left on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL)) {
			listValidMoves.add(locLeft);
		}
		
		/* checking type in field - right side of current location */
		Location locRight = new Location(xCoor + 1, yCoor);
		hashSet = myMap.getLoc(locRight);
		/* move right on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL)) {
			listValidMoves.add(locRight);
		}
		
		/* checking type in field - top side of current location */
		Location locAbove  = new Location(xCoor, yCoor - 1);
		hashSet = myMap.getLoc(locAbove);
		/* move up on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL)) {
			listValidMoves.add(locAbove);
		}
		
		/* checking type in field - bottom side of current location */
		Location locBelow = new Location(xCoor, yCoor + 1);
		hashSet = myMap.getLoc(locBelow);
		/* move down on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL)) {
			listValidMoves.add(locBelow);
		}
		
		return listValidMoves;	
	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
