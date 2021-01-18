import java.util.HashSet;
import java.util.ArrayList;

public class Ghost {
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	/*
	 * Returns an arraylist of Locations that represent valid moves that a ghost is
	 * able to make given their current location If there are no valid moves an
	 * empty arraylist is returned. Valid moves include: any Location with
	 * Map.Type.COOKIE any location with Map.Type.EMPTY any location with
	 * Map.Type.PACMAN
	 */
	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> listValidMoves = new ArrayList<Location>();
		int xCoor = myLoc.x;
		int yCoor = myLoc.y;

		/* checking type in field - left side of current location */
		Location locLeft = new Location(xCoor - 1, yCoor);
		HashSet<Map.Type> hashSet = myMap.getLoc(locLeft);
		/* move left on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.GHOST)) {
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
		Location locAbove = new Location(xCoor, yCoor - 2);
		hashSet = myMap.getLoc(locAbove);
		/* move up on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL) && !hashSet.contains(Map.Type.GHOST)) {
			listValidMoves.add(locAbove);
		}

		/* checking type in field - bottom side of current location */
		Location locBelow = new Location(xCoor, yCoor + 1);
		hashSet = myMap.getLoc(locBelow);
		/* move down on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL)) {
			listValidMoves.add(locBelow);
		}

		/* checking type in field - left upper corner of current location */
		Location locLeftUpper = new Location(xCoor - 1, yCoor - 1);
		hashSet = myMap.getLoc(locLeftUpper);
		/* move to left upper corner on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL) && !hashSet.contains(Map.Type.GHOST)) {
			listValidMoves.add(locLeftUpper);
		}

		/* checking type in field - right upper corner of current location */
		Location locRightUpper = new Location(xCoor + 1, yCoor - 1);
		hashSet = myMap.getLoc(locRightUpper);
		/* move to left upper corner on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL) && !hashSet.contains(Map.Type.GHOST)) {
			listValidMoves.add(locRightUpper);
		}

		/* checking type in field - left lower corner of current location */
		Location locLeftLower = new Location(xCoor - 1, yCoor + 1);
		hashSet = myMap.getLoc(locLeftLower);
		/* move to left upper corner on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL) && !hashSet.contains(Map.Type.GHOST)) {
			listValidMoves.add(locLeftLower);
		}

		/* checking type in field - right lower corner of current location */
		Location locRightLower = new Location(xCoor + 1, yCoor + 1);
		hashSet = myMap.getLoc(locRightLower);
		/* move to left upper corner on map possible */
		if (hashSet != null && !hashSet.contains(Map.Type.WALL) && !hashSet.contains(Map.Type.GHOST)) {
			listValidMoves.add(locRightLower);
		}

		return listValidMoves;
	}

	public boolean move() {
		ArrayList<Location> move_list = this.get_valid_moves();
		if (move_list.size() >= 1) {
			return false;
		}
		myMap.move(this.myName, this.myLoc, Map.Type.GHOST);
		this.myLoc = move_list.get(1);
		return true;
	}

	public boolean is_pacman_in_range() {
		/* iterates through surrounding grid spaces */
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				/* checks if Type PACMAN is present at that grid space */
				if (myMap.getLoc(new Location(myLoc.x + i, myLoc.y + j)).contains(Map.Type.PACMAN)) {
					return true;
				}
			}
		}
		/* if no Type PACMAN is found then return false */
		return false;
	}

	public boolean attack() {
		if (is_pacman_in_range()) {
			return myMap.attack(myName);
		}

		return false;
	}
}
