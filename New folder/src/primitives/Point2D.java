package primitives;

/**
 * class for 2D model
 * @author  avreimmi cheshin AHH24826@gmail.com
 *          elchay shoval    
 */
public class Point2D {
	protected Coordinate _x;
	protected Coordinate _y;
	
	/********** Constructors ***********/
	/**
	 * @param x coordinate X
	 * @param y coordinate Y
	 */
	public Point2D(double x, double y) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
	}
	
	
	/**
	 * @param x coordinate X
	 * @param y coordinate Y
	 */
	public Point2D(Coordinate x, Coordinate y) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
	}
	
	/**
	 * Copy constructor for Point2D
	 * @param other a point to copy
	 */
	public Point2D(Point2D other) {
		_x = new Coordinate(other._x);
		_y = new Coordinate(other._y);
	}
	
	/************** Getters/Setters *******/
	/**
	 * getter for y coordinate
	 * @return coordinate x
	 */
	public Coordinate getX() {
		return _x;
	}
	
	/**
	 * Getter for Y coordinate
	 * @return coordinate Y
	 */
	public Coordinate getY() {
		return _y;
	}

	/*************** Administration *****************/
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point2D))
			return false;
		Point2D oth = (Point2D)obj;
		return _x.equals(oth._x) && _y.equals(oth._y);
	}

	@Override
	public String toString() {
		return "(" + _x + "," + _y + ")";
	}
	
}
