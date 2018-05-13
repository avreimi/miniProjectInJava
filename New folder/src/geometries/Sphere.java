package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.*;

/**
 * a class to represent a sphere
 * 
 * @author Chayim
 *
 */
public class Sphere extends RadialGeometry {
	private Point3D _center;

	// ***************** Constructors ********************** //
	public Sphere(double _radius, Point3D _center) {
		super(_radius);
		this._center = new Point3D(_center);
	}

	public Sphere(Sphere other) {
		super(other);
		this._center = new Point3D(other.get_center());
	}

	// ***************** Getters/Setters ********************** //
	public Point3D get_center() {
		return _center;
	}

	/*************** Administration *****************/
	@Override
	public String toString() {
		return "Sphere: center=" + _center;
	}

	/************** Operations ***************/
	@Override
	public Vector getNormal(Point3D point) {
		// A vector that comes out of the head and crosses the ball at the given point
		return point.subtract(_center);
	}

	
	@Override
	public List<Point3D> findIntersections(Ray ray) {
		List<Point3D> pointsList = new ArrayList<Point3D>();
		double lengthRayDirectionToCenterSpher, shortestDistanceRayToCenterSpher, lengthMiddleRayToSpher;

		Point3D p0 = ray.get_p00();
		Vector v = ray.get_direction();

		Vector u = _center.subtract(p0);
		double tm = v.dotProduct(u);
		double lengthU = u.length();
		double d = Math.sqrt(lengthU * lengthU - tm * tm);
		if (d>_radius) 
			return pointsList;
		
		double th = Math.sqrt(_radius * _radius - d * d);
		if(Coordinate.ZERO.equals(th)) {
			if (tm > 0)
				pointsList.add(p0.addVector(v.scaling(tm)));
		} else {
			double t1 = tm -th;
			double t2 = tm + th;
			if (t1 >0)
				pointsList.add(p0.addVector(v.scaling(t1)));
			if (t2 >0)
				pointsList.add(p0.addVector(v.scaling(t2)));
		}
		return pointsList;
	}

}
