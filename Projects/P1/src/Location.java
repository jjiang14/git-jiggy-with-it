class Location implements Comparable<Location> {
	public int x;
	public int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Location shift(int x, int y) {
		return new Location(this.x + x, this.y + y);
	}

	public Location unshift(Location other) {
		return new Location(other.x - x, other.y - y);
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location loc  = (Location) o;
        return x == loc.x && y == loc.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
	public int compareTo(Location loc) {
		if (this.x < loc.x) {
			return -1;
		} else if (this.x > loc.x) {
			return 1;
		}
		/* this.x == loc.x */

		if (this.y < loc.y) {
			return -1;
		} else if (this.y > loc.y) {
			return 1;
		}
		/* this.y == loc.y */
		return 0;
	}



	@Override 

	public String toString() {
		return "Location x=" + this.x + " y=" + this.y;
	}
}
