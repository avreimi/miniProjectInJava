package geometries;

import java.util.ArrayList;

import primitives.*;

public class Tube extends RadialGeometry {
	private Ray _axisRay;

	/********** Constructors ***********/
	public Tube(double _radius, Ray _axisRay) {
		super(_radius);
		this._axisRay = new Ray(_axisRay);
	}
	
	public Tube(Tube other) {
		super(other);
		this._axisRay = new Ray(other.get_axisRay());
	}

	/************** Getters/Setters *******/
	public Ray get_axisRay() {
		return _axisRay;
	}

	/*************** Administration *****************/ 
	@Override
	public String toString() {
		return "Tube: axis Ray=" + _axisRay;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Tube))
			return false;
		Tube other = (Tube) obj;
		if (_axisRay == null) {
			if (other._axisRay != null)
				return false;
		} else if (!_axisRay.equals(other._axisRay))
			return false;
		return true;
	}

	/************** Operations ***************/
	@Override
	public Vector getNormal(Point3D point) {
	   Vector a= new Vector ( point.getX().get() - _axisRay.get_p00().getX().get(),point.getY().get() - _axisRay.get_p00().getY().get(),
                          point.getZ().get() - _axisRay.get_p00().getZ().get());
    Vector c = new Vector( _axisRay.get_direction().scaling(a.dotProduct(_axisRay.get_direction()) /
                          _axisRay.get_direction().length()*_axisRay.get_direction().length() ) );


        return a.subtract(c);
	}

	@Override
	public ArrayList<Point3D> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

}
