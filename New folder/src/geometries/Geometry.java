package geometries;

import java.util.List;

import primitives.*;


public interface Geometry {
	public abstract Vector getNormal(Point3D point);
	
	public abstract List<Point3D> findIntersections(Ray ray);

}
