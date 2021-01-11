import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

	public enum Type {
		EMPTY, PACMAN, GHOST, WALL, COOKIE
	}

	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components;
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet;

	private int cookies = 0;

	public Map(int dim) {
		gameOver = false;
		// tracks location of each object
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		// tracks types at all locations that are not empty
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}

	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc))
			field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	/* moves the object specified by name to the location specified by loc 
	 * on success returns true, 
	 * otherwise returns false */
	/* NOTE: It is assumed that the caller of this function will be passing in a valid Location, 
	 * therefore no validation check for loc is required */
	public boolean move(String name, Location loc, Type type) {
		
		if (!locations.containsKey(name)) {
			return false;						
		}
		
		if (!components.containsKey(name)) {
			return false;
		}
		
		if (!field.containsKey(loc)) {
			return false;
		}
		
		/* will be used to update field variable */
		Location currLoc = locations.get(name);
		
		/* updating locations */
		locations.put(name, loc);
		
		/* updating components */
		JComponent currComp = components.get(name);
		currComp.setLocation(loc.x, loc.y);
		
		/* updating field */
		field.get(currLoc).remove(type);
		field.get(loc).add(type);
		
		return true;

	}


	
	// returns a HashSet of the types of of the objects that occur at given location
	// emptySet returned if there are no objects on given location
	// wallSet returned if there is a wall 
	public HashSet<Type> getLoc(Location loc) {
		
		if (this.field.containsKey(loc)) {
			if (this.field.get(loc).contains(Type.WALL)) {
				return this.wallSet;
			}
			return this.field.get(loc);
		}
		else {
			return this.emptySet;
		}

	}

	public boolean attack(String Name) {

		// update gameOver

		/* checks to make sure pacman is present on the map */
		Location pac_loc;
		if (locations.containsKey("pacman")) {
			/* gets pacman's location */
			pac_loc = locations.get("pacman");
		} else {
			return false;
		}
		/* moves the ghost to pacman's location */
		if (move(Name, pac_loc, Map.Type.GHOST) == true) {
			/* if the ghost successfully moves to pacman's position, check to make sure both pacman and ghost are at that coordinate */
			if (field.get(pac_loc).contains(Map.Type.PACMAN) && field.get(pac_loc).contains(Map.Type.GHOST)) {
				/* update gameOver and return true */
				gameOver = true;
				return true;
			}
		}
		/* if the attack was not successful return false */
		return false;
	}

	public JComponent eatCookie(String name) {
		// update locations, components, field, and cookies
		// the id for a cookie at (10, 1) is tok_x10_y1

		// get location of cookie
		Location loc = locations.get(name);

		if (loc == null) {
			return null;
		}

		// remove cookie from field based on location
		HashSet<Type> f = field.get(loc);

		if (f.remove(Type.COOKIE) == false) {
			return null;
		}

		// get cookie id
		String cookieId = "tok_x" + loc.x + "_y" + loc.y;

		// get JComponent of cookie
		JComponent cookie = components.get(cookieId);

		if (cookie == null) {
			return null;
		}

		// remove cookie component
		components.remove(cookieId);

		// add points when cookie is consumed
		// cookies = cookies + 1;

		return cookie;
	}
}
