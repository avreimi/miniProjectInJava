package geometries;

import primitives.*;

public class Cylinder extends Tube {
	private double _heghit;

	/********** Constructors ***********/
	public Cylinder(double _radius, Ray _axisRay, double _eghit) {
		super(_radius, _axisRay);
		this._heghit = _eghit;
	}

	public Cylinder(Cylinder other) { 
		super(other);
		this._heghit=other.get_height();
	}

	/************** Getters/Setters *******/
	public double get_height() {
		return _heghit;
	}

	/*************** Administration *****************/ 
	@Override
	public String toString() {
		return "Cylinder: heghit=" + _heghit;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Cylinder))
			return false;
		Cylinder other = (Cylinder) obj;
		if (Double.doubleToLongBits(_heghit) != Double.doubleToLongBits(other._heghit))
			return false;
		return true;
	}

}
