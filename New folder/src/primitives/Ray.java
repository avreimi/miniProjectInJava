package primitives;

public class Ray {
	private Point3D _p00;
	private Vector _direction;
	
	/********** Constructors ***********/
	public Ray(Point3D _p00, Vector _direction) {
		this._p00 = new Point3D(_p00);
		this._direction = new Vector(_direction).normalize();
	}
	
	public  Ray(Ray other) {
		this._p00=new Point3D(other.get_p00());
		this._direction=new Vector(other.get_direction());
	}
	
	/************** Getters/Setters *******/
	public Point3D get_p00() {
		return _p00;
	}
	public Vector get_direction() {
		return _direction;
	}

	/*************** Administration *****************/ 
	@Override
	public String toString() {
		return "Ray: p00=" + _p00 + ", direction=" + _direction;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ray))
			return false;
		Ray other = (Ray) obj;
		return _p00.equals(other._p00) && _direction.equals(other._direction);

	}
	
	
	

}
