package geometries;

/**
 * Abstract class that are manage radius and are the super for elements that have radius
 * @author Chayim
 *
 */
public abstract class RadialGeometry implements Geometry {

	protected double _radius;
	
	/********** Constructors ***********/
	/**
	 * constructor
	 * @param _radius - radius
	 */
	public RadialGeometry(double _radius) {
		//?????what is with 0??? 
		if(_radius<0) {
			throw new ExceptionInInitializerError("radius can not be a negative number");
		}
		this._radius = _radius;
	}
	
	/**
	 * copy constructor
	 * @param other - element to copy
	 */
	public RadialGeometry(RadialGeometry other) {
		this._radius = other.get_radius();
	}
	
	/************** Getters/Setters *******/
	/**
	 * getter for radius
	 * @return - radius
	 */
	public double get_radius() {
		return _radius;
	}

	/*************** Administration *****************/ 
	@Override
	public String toString() {
		return "radius=" + _radius;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RadialGeometry))
			return false;
		RadialGeometry other = (RadialGeometry) obj;
		if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
			return false;
		return true;
	}
	

}
